package com.codegym.controller;

import moduls.NgheNhac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.NgheNhacService;

import java.io.File;
import java.io.IOException;

@Controller
public class NgheNhacController {
    @Autowired
    NgheNhacService ngheNhacService;

    @RequestMapping("home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        ngheNhacService.findAll();
        modelAndView.addObject("list", ngheNhacService.list);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        ngheNhacService.delete(index);
        return "redirect:/home";
    }


    @GetMapping("/play{index}")
    public ModelAndView showPlay(@PathVariable int index, Model model) {
        ModelAndView modelAndView = new ModelAndView("play");
        model.addAttribute("list", ngheNhacService.list.get(index));
        return modelAndView;
    }





    @PostMapping("create")
    public String create(@ModelAttribute NgheNhac ngheNhac, @RequestParam MultipartFile uppMusic) {
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






    @PostMapping("/edit{index}")
    public ModelAndView edit(@ModelAttribute NgheNhac ngheNhac, @RequestParam MultipartFile uppMusic) {
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\JAVA MD4\\MD4-04-UngDungNgheNhac\\src\\main\\webapp\\fileMusic/" + nameMusic));
            String urlMusic = "/music/" + nameMusic;
            ngheNhac.setFileMusic(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        ngheNhacService.edit(ngheNhac);
        return new ModelAndView("redirect:/home");
    }



    @GetMapping("/edit{index}")
    public ModelAndView showEdit(@PathVariable int index, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit");
        model.addAttribute("list", ngheNhacService.list.get(index));
        return modelAndView;
    }






}
