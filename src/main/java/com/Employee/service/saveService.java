package com.Employee.service;

import com.Employee.entity.User;
import com.Employee.reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class saveService {

    @Autowired
    private UserReprository userReprository;
    public void saveData(MultipartFile file, String email, String name, String password, String last,String about, String age,String sem,String status){
        User user=new User();
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setEmail(email);
        user.setFirstName(name);
        user.setRole("ROLE_NORMAL");
        user.setLastName(last);
        user.setAbout(about);
        user.setAge(age);
        user.setSem(sem);
        user.setStatus(status);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        user.setPassword(encode);
        this.userReprository.save(user);

    }
}
