package com.code.bootjpa.controller;

import java.util.List;
import java.util.Optional;

import com.code.bootjpa.dao.AlienRepo;
import com.code.bootjpa.modal.Alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(Alien alien) {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public ModelAndView addAlien(Alien alien){
        repo.save(alien);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        return mv;
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int id){
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(id).orElse(new Alien());
        mv.addObject("alien", alien);
        return mv;
    }

    @RequestMapping("/getAlienByTech")
    public ModelAndView getAlienByTech(@RequestParam String tech){
        ModelAndView mv = new ModelAndView("showAliens.jsp");
        System.out.println(repo.findByTech(tech));
        System.out.println(repo.findByTechSorted(tech));
        System.out.println(repo.findByIdGreaterThan(102));
        // Alien alien = repo.findById(id).orElse(new Alien());
        // mv.addObject("alien", alien);
        return mv;
    }

    // @RequestMapping(path="/aliens", produces={"application/xml"}) //this will make it only support xml response
    @RequestMapping("/aliens")
    public List<Alien> aliens() {
        return repo.findAll();
    }

    // @PostMapping(path="/alien", consumes={"application/json"})
    @PostMapping("/alien")
    public Alien createAlien(@RequestBody Alien alien){ //@RequestBody will only accept raw-json request data
        repo.save(alien);
        return alien;
    }

    @PutMapping("/alien")
    public Alien updateAlien(Alien alien){
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("/alien/{id}")
    public String removeAlien(@PathVariable("id") int id){
        repo.deleteById(id);
        return "deleted " + id;
    }

    @GetMapping("/alien/{id}")
    public Optional<Alien> findAlien(@PathVariable("id") int id) {
        return repo.findById(id);
    }
}