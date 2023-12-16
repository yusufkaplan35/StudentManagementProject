package com.project.controller.user;


import com.project.payload.request.user.StudentRequest;
import com.project.payload.response.ResponseMessage;
import com.project.payload.response.user.StudentResponse;
import com.project.service.user.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save") // http://localhost:8080/students/save + POST + JSON
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ResponseMessage<StudentResponse>> saveStudent(
            @RequestBody @Valid StudentRequest studentRequest){
        return ResponseEntity.ok(studentService.saveStudent(studentRequest));
    }




}
