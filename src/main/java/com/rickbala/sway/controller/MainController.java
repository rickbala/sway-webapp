package com.rickbala.sway.controller;

import com.rickbala.sway.model.Sway;
import com.rickbala.sway.model.repository.SwayRepository;
import com.rickbala.sway.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    SwayRepository swayRepository;

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){
        modelMap.addAttribute("sway", new Sway());
        modelMap.addAttribute("greeting", Utils.createRandomMoto() );
        return "index";
    }

    @ResponseBody
    @PostMapping("/save")
    public String saveTest(ModelMap modelMap) {
        Sway sway = (Sway)modelMap.getAttribute("sway");
        swayRepository.save(sway);

        System.out.println("Salvo com sucesso!");
        return "sucesso";
    }

}
