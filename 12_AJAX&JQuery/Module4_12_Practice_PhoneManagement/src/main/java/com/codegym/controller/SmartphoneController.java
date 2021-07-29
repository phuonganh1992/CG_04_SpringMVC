package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Smartphone>> listPhones(){
        return new ResponseEntity<>(smartphoneService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> create(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findSmartphoneById(@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional=smartphoneService.findById(id);
        if(!smartphoneOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id,@RequestBody Smartphone smartphone){
        Optional<Smartphone> smartphoneOptional=smartphoneService.findById(id);
        if(!smartphoneOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        smartphone.setId(smartphoneOptional.get().getId());
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphone,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

}
