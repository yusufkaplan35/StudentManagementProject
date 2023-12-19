package com.project.controller.business;

import com.project.payload.request.business.EducationTermRequest;
import com.project.payload.response.ResponseMessage;
import com.project.payload.response.business.EducationTermResponse;
import com.project.service.business.EducationTermService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/educationTerms")
public class EducationTermController {

    private final EducationTermService educationTermService;

    @PostMapping("/save") //http://localhost:8080/educationTerms/save + POST + JSON
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public ResponseMessage<EducationTermResponse> saveEducationTerm(@RequestBody @Valid EducationTermRequest educationTermRequest){
        return educationTermService.saveEducationTerm(educationTermRequest);
    }


    @GetMapping("/{id}") //http://localhost:8080/educationTerms/1 + GET
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER')")
    public EducationTermResponse getEducationTermById(@PathVariable Long id){
        return educationTermService.getEducationTermById(id);
    }


    @GetMapping("/getAll") //http://localhost:8080/educationTerms/getAll + GET
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER')")
    public List<EducationTermResponse> getAllEducationTerms(){
        return educationTermService.getAllEducationTerms();
    }

    @GetMapping("/getAllEducationTermByPage")//http://localhost:8080/educationTerms/getAllEducationTermByPage + GET
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER')")
    public Page<EducationTermResponse> getAllEducationTermByPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "startDate") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type
    ){
        return educationTermService.getAllEducationTermByPage(page,size,sort,type);
    }

    @DeleteMapping("/delete/{id}")//http://localhost:8080/educationTerms/delete/2 + DELETE
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
    public ResponseMessage<?> deleteEducationTermById(@PathVariable Long id){
        return educationTermService.deleteEducationTermById(id);
    }


    @PutMapping("/update/{id}")//http://localhost:8080/educationTerms/update/2 + PUT
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
    public ResponseMessage<EducationTermResponse> updateEducationTerm(@PathVariable Long id,
                                                                      @RequestBody @Valid EducationTermRequest educationTermRequest){
        return educationTermService.updateEducationTerm(id,educationTermRequest);
    }






}
