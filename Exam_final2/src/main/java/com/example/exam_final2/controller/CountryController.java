package com.zingmp3.controller;

import com.zingmp3.model.Country;
import com.zingmp3.service.city.ICityService;
import com.zingmp3.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping("")
    public ResponseEntity<Iterable<Country>> findAll() {
        Iterable<Country> countries= countryService.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

//    @PostMapping("/api")
//    public ResponseEntity<Product> create(@RequestBody Product product) {
//        productService.save(product);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/api/{id}")
//    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
//    }
//
//    @GetMapping("/api/search/{name}")
//    public ResponseEntity<List<Product>> findProductById(@PathVariable String name,Pageable pageable) {
//        Page<Product> products = productService.findByNameContaining(name,pageable);
//        if (!products.hasContent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(products.getContent(), HttpStatus.OK);
//    }
//
//    @PutMapping("/api/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        product.setId(productOptional.get().getId());
//        productService.save(product);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/api/{id}")
//    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        productService.delete(id);
//        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
//    }

}
