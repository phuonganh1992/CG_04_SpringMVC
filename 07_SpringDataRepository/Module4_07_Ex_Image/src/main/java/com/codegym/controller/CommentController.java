package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/home")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("/comment");
        Iterable<Comment> comments= commentService.findAll();
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }
    @GetMapping("/saveComment")
    public String addComment(Comment comment){
        commentService.save(comment);
        return "redirect:/home";
    }

    @GetMapping("/likeComment/{id}")
    public String like(@PathVariable long id){
        Optional<Comment> comment = commentService.findById(id);
        comment.get().setLikes(comment.get().getLikes()+1);
        commentService.save(comment.get());
        return "redirect:/home";
    }

    @GetMapping("/dislikeComment/{id}")
    public String disLike(@PathVariable long id){
        Optional<Comment> comment = commentService.findById(id);
        comment.get().setLikes(comment.get().getLikes()-1);
        commentService.save(comment.get());
        return "redirect:/home";
    }
}
