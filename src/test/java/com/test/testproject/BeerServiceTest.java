package com.test.testproject;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class BeerServiceTest {

// mock i @Autowired robia doslownie to samo (wstrzykuja zaleznosci)
    @Mock
    private BeerRepository beerRepository;
    private BeerService beerService;

    /*
        tutaj w tym momencie wlasnie to robi/ autowired jest przyjemniejsze i szybsze ale chcialem
        ci tylko pokazac ze takie cos tez istnieje(tak uzywa sie go tez czasami)
    */
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        beerService = new BeerService(beerRepository);
    }

    @Test
    void getAllBeers_ReturnList(){

        Beer beer1 = new Beer();
        Beer beer2 = new Beer();

        when(beerRepository.findAll()).thenReturn(Arrays.asList(beer1, beer2));
        List<Beer> beers = beerService.getAllBeers();
        assertEquals(2, beers.size());

        // sprawdza poprawnosc wywolania metody (czy zwraca dobra liste)
        verify(beerRepository, times(1)).findAll();
    }


    @Test
    void addBeer_SavesAndReturns(){

        Beer beer = new Beer();

        when(beerRepository.save(any(Beer.class))).thenReturn(beer);
        Beer savedBeer = beerService.addBeer(beer);
        assertEquals(beer, savedBeer);

        //sprawdza tez poprawnosc wywolania metody (zapisuje piwo i je zwraca)
        verify(beerRepository, times(1)).save(beer);
    }

    @Test
    void getAllBeers_NoBeers_ReturnsEmptyList() {

        when(beerRepository.findAll()).thenReturn(Collections.emptyList());
        List<Beer> beers = beerService.getAllBeers();
        assertTrue(beers.isEmpty());

        verify(beerRepository, times(1)).findAll();
    }

}
