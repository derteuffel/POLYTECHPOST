package com.derteuffel.controller;

import com.derteuffel.entities.Post;
import org.springframework.security.core.context.SecurityContextHolder;

import com.derteuffel.entities.User;
import com.derteuffel.repositories.PostRepository;
import com.derteuffel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/posts")
    public String getAllPosts(Model model, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByNom(auth.getName());

        model.addAttribute("user",user);
        session.setAttribute("roles", user.getRoles());
        session.setAttribute("userName",user.getNom());
        session.setAttribute("userAvatar",user.getAvatar());
        model.addAttribute("post",new Post());
        model.addAttribute("userId",user.getUserId());
        model.addAttribute("posts",postRepository.findAll());
        model.addAttribute("users", userRepository.findAll());


        return "posts/posts";
    }
    public FileUploadRespone uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileUploadService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new FileUploadRespone(fileName, fileDownloadUri);
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("post",new Post());

        return "posts/form";
    }

    @PostMapping("/save")
    public String save(Post post,@RequestParam("files") MultipartFile[] files){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByNom(auth.getName());
        List<FileUploadRespone> pieces= Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
        if (pieces.size() == 0) {
            post.setPieces(post.getPieces());
        }else {
            ArrayList<String> filesPaths = new ArrayList<String>();
            for(int i=0;i<pieces.size();i++)
            {

                filesPaths.add(pieces.get(i).getFileDownloadUri());

            }
            post.setPieces(filesPaths);

        }
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/post/posts";
    }



}
