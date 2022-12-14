package com.project.exception;

import com.project.common.ResponseForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerClass {
    // Validation 어노테이션을 통해 검출된 에러를 받는 핸들러
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseForm> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        ResponseForm responseForm = new ResponseForm(e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> errorList = bindingResult.getAllErrors();
        List<ResponseForm.FieldError> list = new ArrayList<>();

        for(int i=0;i<errorList.size();i++){
            FieldError error = (FieldError) errorList.get(i);
            list.add(new ResponseForm.FieldError(error.getDefaultMessage(), (String)error.getRejectedValue(), error.getField()));
        }

        responseForm.setFieldErrorList(list);
        return new ResponseEntity<ResponseForm>(responseForm, HttpStatus.BAD_REQUEST);
    }

    // 기타 모든 에러
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseForm> generalExceptionHandler(Exception e){
        ResponseForm responseForm = new ResponseForm(e.getMessage());
        return new ResponseEntity<ResponseForm>(responseForm, HttpStatus.BAD_REQUEST);
    }
}
