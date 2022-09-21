package com.boot.mvc20220916.web.controller.api;

import com.boot.mvc20220916.web.dto.CMRespDto;
import com.boot.mvc20220916.web.dto.StudentListDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData() {  // ResponseEntity : http응답용, 프로토콜과 같이 --> Json Object로 보면 안됨
        return new ResponseEntity<String>("ResponseEntity 응답", HttpStatus.OK); // body에 내용에 따라 일반 텍스트나 json object로 바뀜
    }

    @GetMapping("/api/v1/entity/data2")
    public ResponseEntity<?> getData2() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());
        return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/v1/entity/data3")
    public ResponseEntity<?> getData3() {
        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<String>("test", headers, HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data4")
    public ResponseEntity<?> getData4() {
        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<>(new CMRespDto<>(1, "전송 성공", "테스트 데이터"), headers, HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1","aaaa11111");
        return ResponseEntity.ok().headers(headers).body(new CMRespDto<>(1, "메세지", "test"));
    }

    @GetMapping("/api/v1/test/students")
    public ResponseEntity<?> getData6() {
        HttpHeaders headers = new HttpHeaders();
        List<StudentListDto> dtoList = new ArrayList<StudentListDto>();

        dtoList.add(StudentListDto.builder().studentCode(20220001).build());
        dtoList.add(StudentListDto.builder().studentCode(20220002).build());
        dtoList.add(StudentListDto.builder().studentCode(20220003).build());
        dtoList.add(StudentListDto.builder().studentCode(20220004).build());

        StringBuilder studentCodeList = new StringBuilder();
        for(StudentListDto studentListDto : dtoList) {
            studentCodeList.append(studentListDto.getStudentCode());
            studentCodeList.append(", ");
        }
        studentCodeList.delete(studentCodeList.length() - 2, studentCodeList.length());

        headers.add("student_code_list", studentCodeList.toString());

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .headers(headers)
                .body(new CMRespDto<>(-1, "HTTP메소드를 확인해 주세요", dtoList));

//        return new ResponseEntity<>(
//                new CMRespDto<>(-1, "HTTP 메소드를 확인해 주세요", dtoList),
//                headers,
//                HttpStatus.METHOD_NOT_ALLOWED
//        );
    }
}
