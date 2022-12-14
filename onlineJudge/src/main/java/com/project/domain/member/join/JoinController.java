package com.project.domain.member.join;

import com.project.common.ResponseForm;
import com.project.domain.member.MemberDto;
import com.project.domain.member.profile.ProfileDto;
import com.project.domain.member.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class JoinController {
    @Autowired
    ProfileService profileService;
    @Autowired
    JoinService joinService;
    @Autowired
    MailService mailService;
    @Autowired
    JoinValidator joinValidator;
    @Autowired
    MessageSource messageSource;

    Locale locale = Locale.getDefault();

    @GetMapping("/join")
    public String getJoinPage(){
        return "join/joinPage";
    }

    @PostMapping("/join")
    @Transactional
    public String join(@Validated @ModelAttribute("JoinFormData") JoinFormData joinFormData, BindingResult bindingResult, Model model){
        // joinValidator 을 통한 회원 가입 폼 데이터 검증
        joinValidator.validate(joinFormData, bindingResult);
        if(bindingResult.hasErrors()) {
            setModelObjectFromJoinFormData(model, joinFormData);
            return "join/joinPage";
        }

        joinService.joinMember(convertJoinFormDataToMemberDto(joinFormData));
        int member_id = joinService.getLastMemberId();
        profileService.insert(new ProfileDto(member_id, 0, 0));
        return "login/loginPage";
    }

    @PostMapping("/email")
    public ResponseEntity<ResponseForm> sendEmail(@RequestParam String email) throws Exception {
        mailService.sendAuthMail(email);
        ResponseForm responseForm = new ResponseForm(messageSource.getMessage("emailSendingSuccess", null, locale));
        return new ResponseEntity<ResponseForm>(responseForm, HttpStatus.OK);
    }

    @PostMapping(value ="/emailCertification")
    @ResponseBody
    public ResponseEntity<ResponseForm> certificateEmail(@RequestParam("email") String email,
                                               @RequestParam("code") String code) throws Exception {
        mailService.checkAuthCode(email, code);
        ResponseForm responseForm = new ResponseForm(messageSource.getMessage("emailCertificationSuccess", null, locale));
        return new ResponseEntity<ResponseForm>(responseForm, HttpStatus.OK);
    }

    @GetMapping("/emailCertificationPage*")
    public String getEmailCertificatePage(@RequestParam("email") String email, Model model){
        model.addAttribute("email", email);
        return "join/emailCertificationPage";
    }

    public MemberDto convertJoinFormDataToMemberDto(JoinFormData joinFormData){
        return new MemberDto(0,
                joinFormData.getUsername(),
                joinFormData.getPassword(),
                joinFormData.getNickName(),
                joinFormData.getEmail(),
                joinFormData.getIntroduction(),
                "ROLE_USER",
                LocalDateTime.now());
    }

    public void setModelObjectFromJoinFormData(Model model, JoinFormData joinFormData){
        model.addAttribute("username", joinFormData.getUsername());
        model.addAttribute("password", joinFormData.getPassword());
        model.addAttribute("passwordCheck", joinFormData.getPasswordCheck());
        model.addAttribute("nickName", joinFormData.getNickName());
        model.addAttribute("introduction", joinFormData.getIntroduction());
    }

}
