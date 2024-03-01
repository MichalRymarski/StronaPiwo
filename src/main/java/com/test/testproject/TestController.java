package com.test.testproject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}