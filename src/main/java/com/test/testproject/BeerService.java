package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {
    private final BeerRepository beerRepository;

    public List<Beer> getAllBeers(){
        return beerRepository.findAll();
    }

    public Beer addBeer(Beer beer){
        return beerRepository.save(beer);
    }
}
