package com.boot.mvc20220916.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentListDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String sudentPhone;
}
