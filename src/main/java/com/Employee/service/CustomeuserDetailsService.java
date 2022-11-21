package com.Employee.service;

import com.Employee.entity.CustomeUserDetails;
import com.Employee.entity.User;
import com.Employee.reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeuserDetailsService implements UserDetailsService {

    @Autowired
    private UserReprository userReprository;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      User user= this.userReprository.findByEmail(email);
      if(user==null){
          throw new UsernameNotFoundException("user is not found ");
      }
        return new CustomeUserDetails(user);
    }
}
