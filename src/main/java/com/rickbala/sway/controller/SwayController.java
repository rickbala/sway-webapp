package com.rickbala.sway.controller;

import com.rickbala.sway.model.Sway;
import com.rickbala.sway.model.repository.SwayRepository;
import com.rickbala.sway.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SwayController {

    @Autowired
    SwayRepository swayRepository;

    private static final String DEFAULT_CHANNEL = "/";

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){
        Sway sway = new Sway(DEFAULT_CHANNEL);
        populateModelMap(modelMap, sway);
        return "index";
    }

    @GetMapping("/{channel}")
    public String getChannelName(@PathVariable("channel") String channel, ModelMap modelMap){
        Sway sway = new Sway(channel);
        populateModelMap(modelMap, sway);
        return "index";
    }

    @PostMapping("/save")
    public String saveSway(@ModelAttribute Sway sway) {
        swayRepository.save(sway);
        String res = "redirect:/";
        if (sway.getChannel() != null && !sway.getChannel().equals(DEFAULT_CHANNEL)) res += sway.getChannel();
        return res;
    }

    private void populateModelMap(ModelMap modelMap, Sway sway) {
        modelMap.addAttribute("sway", sway);
        modelMap.addAttribute("greeting", Utils.createRandomMoto());
        List<Sway> listOfSways = swayRepository.findTop10ByChannelOrderByIdDesc(sway.getChannel());
        modelMap.addAttribute("listOfSways", listOfSways);
    }

}
