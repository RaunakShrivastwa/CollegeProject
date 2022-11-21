package com.Employee.controller;

import com.Employee.entity.Teacher;
import com.Employee.entity.User;
import com.Employee.reprository.TeacherReprositery;
import com.Employee.service.TeacherSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherReprositery teacherReprositery;

    @Autowired
    TeacherSaveService saveService;


    @GetMapping("/teacher")
    public String addTeacher(Model model){
        model.addAttribute("user",new User());
        return "teacher_signup";
    }

    @PostMapping("/teacher_register")
    public String Processregistration(@RequestParam("file") MultipartFile file,
                                      @RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      @RequestParam("name") String name,
                                      @RequestParam("age") String age,
                                      @RequestParam("sub") String sem,
                                      @RequestParam("qualification") String status

    ) {
//        String about="shubham";

        this.saveService.saveData(file,email,name,password,age,sem,status);

        return "redirect:/teacher";
    }

    @GetMapping("/list_teachers")
    public String viewuserList(Model model){
        List<Teacher> userList=this.teacherReprositery.findAll();
        model.addAttribute("userList",userList);

        return "Teachers";
    }

    @GetMapping("/updateTeacher")
    public String updateStudent(Model model){
        List<Teacher> userList=this.teacherReprositery.findAll();
        model.addAttribute("userList",userList);
        return "update_teacher";
    }


    @PostMapping("/changeTeacherEmail")
    public String saveEmail(@RequestParam("id") Long id,
                            @RequestParam("name") String name)
    {
        Teacher p=new Teacher();
        p=this.teacherReprositery.findById(id).get();
        p.setTeacherEmail(name);
        this.teacherReprositery.save(p);
        return "redirect:/updateTeacher";
    }


    @PostMapping("/changeTeacherName")
    public String saveName(@RequestParam("id") Long id,
                            @RequestParam("name") String name)
    {
        Teacher p=new Teacher();
        p=this.teacherReprositery.findById(id).get();
        p.setTeacherName(name);
        this.teacherReprositery.save(p);
        return "redirect:/updateTeacher";
    }


    @PostMapping("/teacherAge")
    public String saveAge(@RequestParam("id") Long id,
                           @RequestParam("name") String name)
    {
        Teacher p=new Teacher();
        p=this.teacherReprositery.findById(id).get();
        p.setTeacherAge(name);
        this.teacherReprositery.save(p);
        return "redirect:/updateTeacher";
    }

    @PostMapping("/teacherSubject")
    public String saveSubject(@RequestParam("id") Long id,
                          @RequestParam("name") String name)
    {
        Teacher p=new Teacher();
        p=this.teacherReprositery.findById(id).get();
        p.setTeacherSubject(name);
        this.teacherReprositery.save(p);
        return "redirect:/updateTeacher";
    }


    @PostMapping("/teacherQualification")
    public String saveQualification(@RequestParam("id") Long id,
                              @RequestParam("name") String name)
    {
        Teacher p=new Teacher();
        p=this.teacherReprositery.findById(id).get();
        p.setTeacherQualification(name);
        this.teacherReprositery.save(p);
        return "redirect:/updateTeacher";
    }
    @GetMapping("/deleteTeacherProd/{id}")
    public String delete(@PathVariable("id") Long id){
        this.teacherReprositery.deleteById(id);
        return "redirect:/updateTeacher";
    }

}
