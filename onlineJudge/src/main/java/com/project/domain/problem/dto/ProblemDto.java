package com.project.domain.problem.dto;

public class ProblemDto {
    int problem_id;
    String title;
    String time_limit;
    String memory_limit;
    String content;
    String input_condition;
    String output_condition;
    String difficulty;
    int testcase_num;

    public ProblemDto(int problem_id, String title, String time_limit, String memory_limit, String content, String input_condition, String output_condition, String difficulty, int testcase_num) {
        this.problem_id = problem_id;
        this.title = title;
        this.time_limit = time_limit;
        this.memory_limit = memory_limit;
        this.content = content;
        this.input_condition = input_condition;
        this.output_condition = output_condition;
        this.difficulty = difficulty;
        this.testcase_num = testcase_num;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(String time_limit) {
        this.time_limit = time_limit;
    }

    public String getMemory_limit() {
        return memory_limit;
    }

    public void setMemory_limit(String memory_limit) {
        this.memory_limit = memory_limit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInput_condition() {
        return input_condition;
    }

    public void setInput_condition(String input_condition) {
        this.input_condition = input_condition;
    }

    public String getOutput_condition() {
        return output_condition;
    }

    public void setOutput_condition(String output_condition) {
        this.output_condition = output_condition;
    }

    public int getTestcase_num() {
        return testcase_num;
    }

    public void setTestcase_num(int tesecase_num) {
        this.testcase_num = tesecase_num;
    }
}
