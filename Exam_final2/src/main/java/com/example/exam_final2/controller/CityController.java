package com.example.exam_final2.controller;


import com.example.exam_final2.model.City;
import com.example.exam_final2.model.Country;
import com.example.exam_final2.service.city.ICityService;
import com.example.exam_final2.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAll() {
        Iterable<City> cities= cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> create(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }

//    @GetMapping("/search/{name}")
//    public ResponseEntity<List<City>> findProductById(@PathVariable String name) {
//        Page<City> products = productService.findByNameContaining(name,pageable);
//        if (!products.hasContent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(products.getContent(), HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        city.setId(cityOptional.get().getId());
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteProduct(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.delete(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }
}
