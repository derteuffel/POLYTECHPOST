package com.derteuffel.controller;

import com.derteuffel.entities.AddRoleToUser;
import com.derteuffel.entities.Role;
import com.derteuffel.entities.User;
import com.derteuffel.repositories.RoleRepository;
import com.derteuffel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by derteuffel on 06/02/2019.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String form(Model model){
        model.addAttribute("user",new User());
        return "user/form";
    }

    @PostMapping("/save")
    public String save(User user, Errors errors, @RequestParam("file") MultipartFile file, Model model){
        String fileName = fileUploadService.storeFile(file);
        user.setAvatar("/downloadFile/" + fileName);

        User user1= userRepository.findByEmail(user.getEmail());

        if (user1 != null){
            errors.rejectValue("email", "user.error", "There is already a user registered with the email provided");
        }
        if (errors.hasErrors()){
            model.addAttribute("errors","Il existe un Utililsateur avec le meme adresse email.");
            return "user/form";
        }else {
            user.setActive(true);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Role role= roleRepository.findByName("USER");
            if (user.getRoles() == null){
                user.setRoles(new HashSet<Role>(Arrays.asList(role)));
            }
            userRepository.save(user);
        }
        return "redirect:/login";
    }

    @GetMapping("/update/{userId}")
    public String update(@PathVariable Long userId, Model model){
        User user= userRepository.getOne(userId);
        model.addAttribute("user",user);
        return "user/update";
    }

    @PostMapping("/update/{userId}")
    public String update(User user, @RequestParam("file") MultipartFile file){
        String fileName = fileUploadService.storeFile(file);
        user.setAvatar("/downloadFile/" + fileName);

        userRepository.save(user);
        return "redirect:/logout";
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId){
        userRepository.deleteById(userId);
        return "redirect:/user/users";
    }

    @GetMapping("/profile/{userId}")
    public String profile(@PathVariable Long userId, Model model){
        User user= userRepository.getOne(userId);
        model.addAttribute("user",user);
        return "user/profile";
    }

    @GetMapping("/detail/{userId}")
    public String detail(@PathVariable Long userId, Model model){
        User user= userRepository.getOne(userId);
        AddRoleToUser form= new AddRoleToUser(roleRepository.findAll(),user);
        model.addAttribute("form", form);
        model.addAttribute("user",user);
        return "user/detail";
    }

    @PostMapping("/role/save")
    public String role(@PathVariable Long userId, AddRoleToUser form){
    Role role= roleRepository.getOne(form.getRoleId());
    User user=userRepository.getOne(userId);
        user.addRoles(role);
        userRepository.save(user);
        return "redirect:/user/detail/"+user.getUserId();
    }
}
