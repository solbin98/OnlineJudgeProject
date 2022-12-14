package com.project.domain.problem.service;

import com.project.domain.problem.dto.ProblemTagDto;
import com.project.domain.problem.dto.ProblemTagJoinDto;
import com.project.domain.problem.dto.TagDto;
import com.project.domain.problem.dao.ProblemTagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemTagService {
    @Autowired
    ProblemTagDao problemTagDao;

    public List<ProblemTagJoinDto> getProblemTagJoinDtoListByProblemId(int problem_id){
        return problemTagDao.selectByProblemIdWithJoin(problem_id);
    }

    public void addProblemTagDtos(List<TagDto> problemTagDtoList, int problem_id) throws Exception{
        for(int i=0;i<problemTagDtoList.size();i++){
            problemTagDao.insert(new ProblemTagDto(problem_id, problemTagDtoList.get(i).getTag_id()));
        }
    }
}
