package com.boot.mvc20220916.web.controller.api;

import com.boot.mvc20220916.web.dto.CMRespDto;
import com.boot.mvc20220916.web.dto.ReqAddPostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RequestTestController {

    @PostMapping("/api/v1/rp/post")
    public ResponseEntity<?> addpost(@RequestParam String title,
                                     @RequestParam String writer,
                                     @RequestParam String content) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("writer", writer);
        map.put("content", content);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", map));
    }

    @PostMapping("/api/v1/dto/post")
    public ResponseEntity<?> addpost(ReqAddPostDto reqAddPostDto) {

        log.info("{}", reqAddPostDto);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", reqAddPostDto));
    }

    @PostMapping("/api/v1/file/post")
    public ResponseEntity<?> addpost2(ReqAddPostDto reqAddPostDto) {

        log.info("{}", reqAddPostDto);
        List<String> fileNames = new ArrayList<String>();

        String fileName1 = reqAddPostDto.getFile().getOriginalFilename();
        fileNames.add(fileName1);

        if(reqAddPostDto.getFiles() != null) {
            String fileName2 = reqAddPostDto.getFiles().get(0).getOriginalFilename();
            String fileName3 = reqAddPostDto.getFiles().get(1).getOriginalFilename();
            fileNames.add(fileName2);
            fileNames.add(fileName3);
        }


        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", fileNames));
    }

    @PostMapping("/api/v1/json/post")
    public ResponseEntity<?> addpost3(@RequestBody ReqAddPostDto reqAddPostDto) {  // @RequestBody를 달아줘야만 json으로 받을 수 있음(Json만)

        log.info("{}", reqAddPostDto);

        return ResponseEntity.ok(new CMRespDto(1, "Json으로 게시글 작성 완료", reqAddPostDto));
    }

    @DeleteMapping("/api/v1/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id) {
        log.info("삭제할 게시글 번호: ({})", id);
        return ResponseEntity.ok(new CMRespDto<>(1, "삭제성공", id));
    }


}
