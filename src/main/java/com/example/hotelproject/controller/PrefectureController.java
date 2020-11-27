package com.example.hotelproject.controller;

import java.util.List;

import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.entity.Prefecture;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.PrefectureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prefectures")
public class PrefectureController {

    @Autowired
    private PrefectureRepository prefectureRepository;
    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping
    public String index(Model model) {
        List<Prefecture> prefectures = prefectureRepository.findAll();

        model.addAttribute("prefectures", prefectures);
        model.addAttribute("title", "ホテル検索");
        return "prefecture/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Prefecture prefecture = prefectureRepository.findById(id).orElse(null);
        List<Hotel> hotels= hotelRepository.findByPrefectureId(id);
        model.addAttribute("hotels", hotels);
        model.addAttribute("prefecture", prefecture);
        model.addAttribute("title", "Show Hotel");
        return "prefecture/show";
    }

}