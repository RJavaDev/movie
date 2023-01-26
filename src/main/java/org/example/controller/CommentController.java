package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @GetMapping("/list/{id}")
    public String getComment(@PathVariable String id){
        return "comment";
    }
    @GetMapping("/add/{id}")
    public String addMovieComment(@PathVariable String id){

    }


}
