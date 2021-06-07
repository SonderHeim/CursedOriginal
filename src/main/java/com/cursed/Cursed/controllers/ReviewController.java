package com.cursed.Cursed.controllers;

import com.cursed.Cursed.models.Review;
import com.cursed.Cursed.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/review")
    public String reviewMain(Model model){
        Iterable<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "review";
    }

    @GetMapping("/reviews/add")
    public String MainPage5(Model model) {
        model.addAttribute("Review", new Review());
        return "reviews-add";
    }

    @PostMapping("/reviews/add")
    public String ReviewAdd (@RequestParam String name, @RequestParam String text, Model model){
        Review review = new Review(text, name);
        reviewRepository.save(review);
        return "reviews-add";
    }
}