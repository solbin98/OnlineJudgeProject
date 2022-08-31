package com.project.dao;

import com.project.dto.ProblemTagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProblemTagDao {

    private RowMapper<ProblemTagDto> problemTagDtoRowMapper = new RowMapper<ProblemTagDto>() {
        @Override
        public ProblemTagDto mapRow(ResultSet rs, int i) throws SQLException {
            ProblemTagDto problemTagDto = new ProblemTagDto(
                    rs.getInt("problem_id"),
                    rs.getInt("tag_id")
            );
            return problemTagDto;
        }
    };
    @Autowired
    private JdbcTemplate jdbcTemplate;
}