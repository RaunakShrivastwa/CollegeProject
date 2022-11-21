package com.Employee.service;

import com.Employee.entity.User;
import com.Employee.reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class updateImage {
    
    @Autowired
    UserReprository userReprository;
    
    public void updateImage(Long id, MultipartFile file){
        User user=new User();
        user=this.userReprository.findById(id).get();
        System.out.println("user.getFirstName() = " + user.getFirstName());
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
