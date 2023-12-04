package com.project.entity.concretes.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.entity.concretes.business.StudentInfo;
import com.project.entity.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String ssn;

    private String name;

    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyy-MM-dd")
    private LocalDate birthday;

    private String birthPlace;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Json veriyi JAVA nesnesine cevirirken
    private String password; // hassas veri olduğu için client tarafına gitmesin

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    private Boolean built_in;

    private String motherName;

    private String fatherName;

    private int studentName;

    private boolean isActive;

    private Boolean isAdvisor;

    private Long advisorTeacherId; // sadece ogrenciler icin gerekli

    @Enumerated(EnumType.STRING)
    private Gender gender; // Bay - bay - BAY

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRole userRole;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
    private List<StudentInfo> studentInfos;

    //TODO : - LessonProgram - Meet eklenecek



}
