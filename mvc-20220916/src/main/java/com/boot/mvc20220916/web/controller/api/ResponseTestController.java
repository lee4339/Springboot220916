package com.boot.mvc20220916.web.controller.api;

import com.boot.mvc20220916.web.dto.ResponseDataDto;
import com.boot.mvc20220916.web.dto.StudentListDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController // @ResponseBody가 생략  // 데이터를 처리할 수 있게 하는 컨트롤러
public class ResponseTestController {
    
//    @ResponseBody // 일반 데이터를 리스폰스하는 어노테이션 //json타입으로 출력
    @GetMapping("/api/v1/data1")
    public Map<String, Object> getData() {  // map --> json 형태로 출력  // 객체를 응답하면 json으로 응답한다.
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("이름", "이건호");
        data.put("연락처", "010-0000-0000");
        return data;
    }

//    @ResponseBody
    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2() {
        return ResponseDataDto.builder()
                .value1("그냥문자열")
                .value2(1000)
                .value3(true)
                .build();
    }

//    @ResponseBody
    @GetMapping("/api/v1/data3")
    public Object getData3() {
        return ResponseDataDto.builder()
                .value1("그냥문자열")
                .value2(1000)
                .value3(true)
                .build();
    }

    @GetMapping("/api/v1/students")
    public Map<String, Object> getStudentList() {
        Map<String, Object> students = new HashMap<String, Object>();

        List<StudentListDto> studentList = new ArrayList<StudentListDto>();

        StudentListDto s1 = StudentListDto.builder()
                .studentCode(20220001)
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산진구")
                .sudentPhone("010-0000-0000")
                .build();

        studentList.add(s1);

        StudentListDto s2 = StudentListDto.builder()
                .studentCode(20220002)
                .studentName("김준이")
                .studentYear(4)
                .studentAddress("동래구")
                .sudentPhone("010-1111-1111")
                .build();

        studentList.add(s2);

        students.put("students", studentList);

        return students;
    }
}
