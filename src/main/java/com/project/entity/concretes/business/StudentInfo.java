package com.project.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.entity.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer absentee;

    private Double midtermExam;

    private Double finalExam;

    private Double examAverage;

    private String infoNote;

    @Enumerated(EnumType.STRING)
    private String letterGrade; // AA- Aa - aa

    @ManyToOne
    @JsonIgnore
    private User teacher;

    @ManyToOne
    @JsonIgnore
    private User student;

    // TODO: LESSON - EducationTerm eklenecek











}
