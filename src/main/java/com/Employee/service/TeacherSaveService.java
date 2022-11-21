package com.Employee.service;

import com.Employee.entity.Teacher;
import com.Employee.entity.User;
import com.Employee.reprository.TeacherReprositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class TeacherSaveService {

    @Autowired
    TeacherReprositery teacherReprositery;
    public void saveData(MultipartFile file, String email, String name, String password,String age, String sub, String qualification){
        Teacher teacher=new Teacher();
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            teacher.setTeacherImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        teacher.setTeacherEmail(email);
        teacher.setTeacherName(name);
        teacher.setTeacheRole("ROLE_NORMAL");
        teacher.setTeacherAge(age);
        teacher.setTeacherQualification(qualification);
        teacher.setTeacherSubject(sub);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        teacher.setTeacherPassword(encode);
        this.teacherReprositery.save(teacher);

    }
}
