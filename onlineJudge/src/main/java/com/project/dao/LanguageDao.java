package com.project.dao;

import com.project.dto.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LanguageDao {

    private RowMapper<LanguageDto> languageDtoRowMapper = new RowMapper<LanguageDto>() {
        @Override
        public LanguageDto mapRow(ResultSet rs, int i) throws SQLException {
            LanguageDto languageDto = new LanguageDto(
                    rs.getInt("language_id"),
                    rs.getString("name")
            );
            return languageDto;
        }
    };

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<LanguageDto> select(){
        return jdbcTemplate.query("select * from language", languageDtoRowMapper);
    }


}
