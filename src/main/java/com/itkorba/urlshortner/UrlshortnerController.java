package com.itkorba.urlshortner;

import com.itkorba.urlshortner.Models.UrlStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UrlshortnerController {

    @Autowired
    URLMain URLMain1;


    @GetMapping("/")
    public String getLongURL( Model model) throws Exception {
        model.addAttribute("UrlStructure", new UrlStructure());
        return "index";
    }

    @PostMapping("/shorten")
    public String getshortURL(@ModelAttribute UrlStructure urlStructure, Model model){
        String shortUrl = URLMain1.shortenURL(urlStructure.getLongURL());
        urlStructure.setShortURL(shortUrl);
        model.addAttribute("UrlStructure", urlStructure);
        return "index";
    }
    @GetMapping(path = "{id}")
    public String getPersonByID(@PathVariable("id") String id) throws  Exception{
        return "redirect:"+ URLMain1.expandURL(id);
    }


}
