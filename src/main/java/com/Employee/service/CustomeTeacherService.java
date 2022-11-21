package com.Employee.service;

import com.Employee.entity.CustomeTeacherDetails;
import com.Employee.entity.CustomeUserDetails;
import com.Employee.entity.Teacher;
import com.Employee.entity.User;
import com.Employee.reprository.TeacherReprositery;
import com.Employee.reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeTeacherService implements UserDetailsService {

    @Autowired
    private TeacherReprositery teacherReprositery;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher user= this.teacherReprositery.findByteacherEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("user is not found ");
        }
        return new CustomeTeacherDetails(user);
    }
}
