package com.codegym.controller;

import moduls.NgheNhac;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.NgheNhacService;

import java.io.File;
import java.io.IOException;

@Controller
public class NgheNhacController {
    NgheNhacService ngheNhacService = new NgheNhacService();

    @RequestMapping("home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list",ngheNhacService.list);
        return modelAndView;
    }

    @PostMapping("create")
    public String create(@ModelAttribute NgheNhac ngheNhac, @RequestParam MultipartFile uppMusic){
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\JAVA MD4\\MD4-04-UngDungNgheNhac\\src\\main\\webapp\\fileMusic/" + nameMusic));
            String urlImg = "/music/" + nameMusic;
            ngheNhac.setFileMusic(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        ngheNhacService.save(ngheNhac);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new NgheNhac());

        return modelAndView;
    }

}
