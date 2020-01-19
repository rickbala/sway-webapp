package com.rickbala.sway.controller;

import com.rickbala.sway.model.Sway;
import com.rickbala.sway.model.repository.SwayRepository;
import com.rickbala.sway.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SwayController {

    @Autowired
    SwayRepository swayRepository;

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){
        modelMap.addAttribute("sway", new Sway());
        modelMap.addAttribute("greeting", Utils.createRandomMoto() );
        List<Sway> listOfSways = swayRepository.findAll();
        modelMap.addAttribute("listOfSways", listOfSways);
        return "index";
    }

    @PostMapping("/save")
    public String saveSway(@ModelAttribute Sway sway) {
        swayRepository.save(sway);
        return "redirect:/";
    }

}
