package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342") //taki jest localhost dla webu default
@RestController
@RequiredArgsConstructor
public class BeerController {
    final private BeerService beerService;


    @GetMapping(value ="/beers/example/{nickName}")
    public List<Beer> getSampleBeer(@PathVariable String nickName){
        List<Beer> beer  = beerService.getBeerByProposed(nickName);
        return beer;
    }

    @GetMapping(value = "beers/all")
    public List<Beer> getAll(){
        List<Beer> beers = beerService.getAllBeers();
        return beers;
    }
}
