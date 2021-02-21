package com.hogwarts.blog.controller.admin;


import com.hogwarts.blog.pojo.Blog;
import com.hogwarts.blog.pojo.User;
import com.hogwarts.blog.service.BlogService;
import com.hogwarts.blog.service.UserService;
import com.hogwarts.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes, Model model){
        User user = userService.checkUser(username, MD5Utils.code(password));
        System.out.println(user);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            List<Blog> blogs = blogService.listNewBlog(3);
            model.addAttribute("blogs",blogs);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }


}
