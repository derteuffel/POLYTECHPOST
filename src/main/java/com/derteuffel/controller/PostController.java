package com.derteuffel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neword on 10/03/2019.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/all")
    public String postAll()
    {
        return "posts/post_all";
    }
}
