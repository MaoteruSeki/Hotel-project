package com.example.hotelproject.controller;

import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.entity.Resarvation;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ResarvationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotel_id}/resarvations")
public class ResarvationController {
    @Autowired
    private ResarvationRepository resarvationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("new")
    public String newResarvation(@PathVariable Long hotel_id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "新規予約");
        return "resarvation/new";
    }

    @PostMapping
    public String create(@PathVariable Long hotel_id, @ModelAttribute Resarvation resarvation) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        resarvation.setHotel(hotel);
        resarvationRepository.save(resarvation);
        return "redirect:/hotels/{hotel_id}/resarvations/"+ resarvation.getId();
    }
    
    @GetMapping("{id}")
    public String show(@PathVariable Long hotel_id,@PathVariable Long id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        Resarvation resarvation = resarvationRepository.findById(id).orElse(null);
        model.addAttribute("resarvation", resarvation);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "御予約ありがとうございます");
        return "resarvation/show";
    }

}