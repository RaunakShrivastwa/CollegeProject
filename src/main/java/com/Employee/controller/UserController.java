package com.Employee.controller;

import com.Employee.entity.CustomeUserDetails;
import com.Employee.entity.User;
import com.Employee.reprository.UserReprository;
import com.Employee.service.saveService;
import com.Employee.service.updateImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class UserController extends HttpServlet {

   public  String employee_desc;
    @Autowired
    private UserReprository userReprository;

    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private saveService saveService;

    @Autowired
   private updateImage updateImage;

    @GetMapping("/homepage")
    public String viewHomePage(){
        return "index";
    }




    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String Processregistration(@RequestParam("file") MultipartFile file,
                                      @RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      @RequestParam("name") String name,
                                      @RequestParam("last") String last,
                                      @RequestParam("age") String age,
                                      @RequestParam("sem") String sem,
                                      @RequestParam("status") String status

                                      ) {
        String about="shubham";

        this.saveService.saveData(file,email,name,password,last,about,age,sem,status);

        return "redirect:/register";
    }

    @GetMapping("/deleteProd/{id}")
    public String delete(@PathVariable("id") Long id){
        this.userReprository.deleteById(id);
        return "redirect:/updateStudent";
    }

    @GetMapping("/list_users")
    public String viewuserList(Model model){
        List<User> userList=this.userReprository.findAll();
        model.addAttribute("userList",userList);

        return "users";
    }
      @GetMapping("/valide")
        public String valide(){
          return "validation";
        }

        @GetMapping("/enfo")
        public String enfo(){
         return "info";
        }


    @PostMapping("/desc")
    public String infor(User user) {
        System.out.println(user.getLastName());
        CustomeUserDetails customeUserDetails=null;
        System.out.println(customeUserDetails.getUsername());
        return "MyPage";
    }

        @GetMapping("/page")
        public String mypage(Model model){
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                employee_desc = ((UserDetails)principal).getUsername();
            } else {
                employee_desc = principal.toString();
            }
            System.out.println(employee_desc);
            model.addAttribute("employee_desc",employee_desc);
           return "MyPage";
        }

        @GetMapping("/about")
        public String about(){
          return "about";
        }

        @GetMapping("/updateStudent")
        public String updateStudent(Model model){
            List<User> userList=this.userReprository.findAll();
            model.addAttribute("userList",userList);
            return "update_student";
        }

        @PostMapping("/changeAge")
    public String saveName(@RequestParam("id") Long id,
                           @RequestParam("name") String name)
    {
        User p=new User();
        p=this.userReprository.findById(id).get();
        p.setAge(name);
        this.userReprository.save(p);
        return "redirect:/updateStudent";
    }

    @PostMapping("/title")
    public String saveTitle(@RequestParam("id") Long id,
                           @RequestParam("name") String name)
    {
        User p=new User();
        p=this.userReprository.findById(id).get();
        p.setLastName(name);
        this.userReprository.save(p);
        return "redirect:/updateStudent";
    }

    @PostMapping("/changeEmail")
    public String saveEmail(@RequestParam("id") Long id,
                            @RequestParam("name") String name)
    {
        User p=new User();
        p=this.userReprository.findById(id).get();
        p.setEmail(name);
        this.userReprository.save(p);
        return "redirect:/updateStudent";
    }

    @PostMapping("/changeSem")
    public String saveSem(@RequestParam("id") Long id,
                            @RequestParam("name") String name)
    {
        User p=new User();
        p=this.userReprository.findById(id).get();
        p.setSem(name);
        this.userReprository.save(p);
        return "redirect:/updateStudent";
    }

    @PostMapping("/changeStatus")
    public String saveStatus(@RequestParam("id") Long id,
                          @RequestParam("name") String name)
    {
        User p=new User();
        p=this.userReprository.findById(id).get();
        p.setStatus(name);
        this.userReprository.save(p);
        return "redirect:/updateStudent";
    }

    @PostMapping("/changeName")
    public String saveName1(@RequestParam("id") Long id,
                             @RequestParam("name") String name)
    {
        User p=new User();
        p=this.userReprository.findById(id).get();
        p.setFirstName(name);
        this.userReprository.save(p);
        return "redirect:/updateStudent";
    }

    @GetMapping("/job")
    public String job(){
        return "job";
    }

}


