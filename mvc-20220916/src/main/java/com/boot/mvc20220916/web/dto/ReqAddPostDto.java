package com.boot.mvc20220916.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReqAddPostDto {
    private String title;
    private String writer;
    private String content;
    private MultipartFile file;
    private List<MultipartFile> files;
}
