package com.example.hrfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/proxy")
@CrossOrigin(origins = "*")
public class ApiProxyController {

    @Autowired
    private WebClient webClient;

    @GetMapping
    public ResponseEntity<String> proxyGet(@RequestParam String endpoint) {
        System.out.println("Proxy request received for endpoint: " + endpoint);
        
        try {
            String response = webClient.get()
                    .uri(endpoint)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnError(error -> System.err.println("WebClient error: " + error.getMessage()))
                    .onErrorResume(e -> {
                        System.err.println("Error calling API: " + e.getMessage());
                        e.printStackTrace();
                        return Mono.just("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
                    })
                    .block();
            
            System.out.println("Response received, length: " + (response != null ? response.length() : 0));
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            System.err.println("Exception in proxy: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
    
    @PatchMapping
    public ResponseEntity<String> proxyPatch(@RequestParam String endpoint, @RequestBody String body) {
        System.out.println("Proxy PATCH request received for endpoint: " + endpoint);
        System.out.println("Request body: " + body);
        
        try {
            String response = webClient.patch()
                    .uri(endpoint)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnError(error -> System.err.println("WebClient error: " + error.getMessage()))
                    .onErrorResume(e -> {
                        System.err.println("Error calling API: " + e.getMessage());
                        e.printStackTrace();
                        return Mono.just("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
                    })
                    .block();
            
            System.out.println("Response received, length: " + (response != null ? response.length() : 0));
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            System.err.println("Exception in proxy: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
    
    @PutMapping
    public ResponseEntity<String> proxyPut(@RequestParam String endpoint, @RequestBody String body) {
        System.out.println("Proxy PUT request received for endpoint: " + endpoint);
        System.out.println("Request body: " + body);
        
        try {
            String response = webClient.put()
                    .uri(endpoint)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnError(error -> System.err.println("WebClient error: " + error.getMessage()))
                    .onErrorResume(e -> {
                        System.err.println("Error calling API: " + e.getMessage());
                        e.printStackTrace();
                        return Mono.just("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
                    })
                    .block();
            
            System.out.println("Response received, length: " + (response != null ? response.length() : 0));
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            System.err.println("Exception in proxy: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
}
