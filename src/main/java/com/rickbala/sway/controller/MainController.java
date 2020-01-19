package com.rickbala.sway.controller;

import com.rickbala.sway.main.SwayApp;
import com.rickbala.sway.model.Sway;
import com.rickbala.sway.model.repository.SwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    SwayRepository swayRepository;

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

    @ResponseBody
    @GetMapping("/sway")
    public String sway(ModelMap modelMap){
        String body = "<h1>Hello Swayer!</h1>";

        SwayApp swayApp = new SwayApp();
        body += "<h2>" + swayApp.createRandomMoto() + "</h2>";
        body += "<input type='text'/>";

        return body;
    }

    @ResponseBody
    @GetMapping("/saveTest")
    public String saveTest() {
        Sway sway = new Sway("I'm swaying!");
        //swayDAO.save(sway);
        swayRepository.save(sway);

        System.out.println("Salvo com sucesso!");
        return "sucesso";
    }

}
