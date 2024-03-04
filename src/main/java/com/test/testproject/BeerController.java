package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:63342") //taki jest localhost dla webu default
@RestController
@RequiredArgsConstructor
public class BeerController {
    final private BeerService beerService;

    @GetMapping(value ="/beers/example")
    public Beer getSampleBeer(){
        Beer beer  = new Beer();
        beer.setUrl("https://lh3.googleusercontent.com/proxy/W4796kkGOCR407yQ7AORs0X470nPaR3UmWV2UQYfOvf7ZZRcO42Ruo2KA09GyyG1IwrgsJEsssIX2rJ-GeRHnWBAqdw8CBfkMRUQe9-IvxL3osg922mydgPhacwFCcmg17WiMYqNP90hxHGzvd-ub0c623thsHWSMRIYW12hqIhltw");
        beer.setDescription("pyszna perła chmiel");
        beer.setProposedBy("Michas");
        return beer;
    }
}
