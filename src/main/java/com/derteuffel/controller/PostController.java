package com.derteuffel.controller;

import com.derteuffel.entities.User;
import com.derteuffel.repositories.PostRepository;
import com.derteuffel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by derteuffel on 10/03/2019.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/posts")
    public String getAllPosts(Model model, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user1 = userRepository.findByNom(auth.getName());

        session.setAttribute("roles", user1.getRoles());

        return "post/posts";

    }
}
