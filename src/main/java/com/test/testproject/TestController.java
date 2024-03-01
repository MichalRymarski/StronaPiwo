package com.test.testproject;

import org.springframework.web.bind.annotation.*;
//aby sie nie pierdolic -> mozesz pozniej zmienic

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class TestController {

    @PostMapping("/api/your-endpoint")
    public String insertData(@RequestBody String data) {
        System.out.println(data);
        return "Data received: " + data;
    }

    @GetMapping("/api/your-endpoint")
    public List<String> fetchData() {
        List<String> data = new ArrayList<>();
        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");
        return data;
    }

    @DeleteMapping("/api/your-endpoint/{item}")
    public String deleteItem(@PathVariable String item) {
        System.out.println("Deleted item: " + item);
        return "Item deleted: " + item;
    }

}