package com.project.service.user;

import com.project.entity.concretes.user.User;
import com.project.entity.enums.RoleType;
import com.project.payload.mappers.UserMapper;
import com.project.payload.request.user.StudentRequest;
import com.project.payload.response.ResponseMessage;
import com.project.payload.response.user.StudentResponse;
import com.project.repository.UserRepository;
import com.project.service.UserRoleService;
import com.project.service.helper.MethodHelper;
import com.project.service.validator.UniquePropertyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UserRepository userRepository;
    private final MethodHelper methodHelper;
    private final UniquePropertyValidator uniquePropertyValidator;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;

    public ResponseMessage<StudentResponse> saveStudent(StudentRequest studentRequest) {

        User advisorTeacher = methodHelper.isUserExist(studentRequest.getAdvisorTeacherId());

        methodHelper.checkAdvisor(advisorTeacher);

        uniquePropertyValidator.checkDuplicate(studentRequest.getUsername(),
                studentRequest.getSsn(),
                studentRequest.getPhoneNumber(),
                studentRequest.getEmail());

        User student = userMapper.mapStudentRequestToUser(studentRequest);

        student.setAdvisorTeacherId(advisorTeacher.getId());
        student.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        student.setUserRole(userRoleService.getUserRole(RoleType.STUDENT));
        student.setActive(true);
        student.setIsAdvisor(Boolean.FALSE);
        student.setStudentNumber(10);


    }

    private int getLastNumber(){

    }



}
