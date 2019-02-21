package com.derteuffel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by derteuffel on 10/02/2019.
 */
@Controller
public class ConnectionController {
    @GetMapping("/login")
    public String login(){
        return "connection";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
