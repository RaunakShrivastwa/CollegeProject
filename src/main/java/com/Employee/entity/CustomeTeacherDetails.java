package com.Employee.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomeTeacherDetails implements UserDetails {

    private Teacher teacher;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        HashSet<SimpleGrantedAuthority> set=new HashSet<>();
        set.add(new SimpleGrantedAuthority(this
                .teacher.getTeacheRole()));
        return set;
    }



    public CustomeTeacherDetails(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String getPassword() {
        return this.teacher.getTeacherPassword();
    }

    @Override
    public String getUsername() {
        return this.teacher.getTeacherEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName(){
        return teacher.getTeacherName();
    }
}
