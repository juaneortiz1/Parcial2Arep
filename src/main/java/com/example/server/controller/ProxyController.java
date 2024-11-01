package com.example.server.controller;

import com.example.server.model.Greeting;
import com.example.server.model.ProxyServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class ProxyController {

    private final String[] mathServers = {"http://98.81.121.208:8080", "http://34.229.47.183:8080"};
    private int serverIndex = 0;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String type, @RequestParam String list, @RequestParam String value) {
        String url = mathServers[serverIndex] + "/" + type + "?list=" + list + "&value=" + value;
        serverIndex = (serverIndex + 1) % mathServers.length;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
