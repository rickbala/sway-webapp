package com.rickbala.sway.controller;

import com.rickbala.sway.model.Sway;
import com.rickbala.sway.model.repository.SwayRepository;
import com.rickbala.sway.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
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

    //@PreAuthorize("isAuthenticated")
    @PostMapping("/save")
    public String saveSway(@ModelAttribute Sway sway) {
        sway.setId(Utils.createRandomSwayId());
        sway.setDate(new Date());
        if (sway.getText().length() > 2000) sway.setText(sway.getText().substring(0, 2000));
        swayRepository.save(sway);
        String res = "redirect:/";
        if (sway.getChannel() != null && !sway.getChannel().equals(DEFAULT_CHANNEL)) res += sway.getChannel();
        return res;
    }

    private void populateModelMap(ModelMap modelMap, Sway sway) {
        modelMap.addAttribute("sway", sway);
        modelMap.addAttribute("greeting", Utils.createRandomMoto());
        List<Sway> listOfSways = swayRepository.findTop1000ByChannelOrderByDateDesc(sway.getChannel());
        modelMap.addAttribute("listOfSways", listOfSways);
        modelMap.addAttribute("randomChannel", Utils.createRandomChannel());
    }

}
