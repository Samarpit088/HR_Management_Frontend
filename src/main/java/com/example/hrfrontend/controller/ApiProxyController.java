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
        try {
            String response = webClient.get()
                    .uri(endpoint)
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorResume(e -> {
                        return Mono.just("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
                    })
                    .block();
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
    
    @PatchMapping
    public ResponseEntity<String> proxyPatch(@RequestParam String endpoint, @RequestBody String body) {
        try {
            String response = webClient.patch()
                    .uri(endpoint)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .onErrorResume(e -> {
                        return Mono.just("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
                    })
                    .block();
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
    
    @PutMapping
    public ResponseEntity<String> proxyPut(@RequestParam String endpoint, @RequestBody String body) {
        try {
            String response = webClient.put()
                    .uri(endpoint)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody)))
                    )
                    .bodyToMono(String.class)
                    .onErrorResume(e -> {
                        String errorMessage = e.getMessage();
                        if (errorMessage != null && errorMessage.startsWith("{")) {
                            return Mono.just(errorMessage);
                        } else {
                            return Mono.just("{\"error\":\"" + (errorMessage != null ? errorMessage.replace("\"", "'") : "Unknown error") + "\"}");
                        }
                    })
                    .block();
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
    
    @PostMapping
    public ResponseEntity<String> proxyPost(@RequestParam String endpoint, @RequestBody String body) {
        try {
            String response = webClient.post()
                    .uri(endpoint)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody)))
                    )
                    .bodyToMono(String.class)
                    .onErrorResume(e -> {
                        String errorMessage = e.getMessage();
                        if (errorMessage != null && errorMessage.startsWith("{")) {
                            return Mono.just(errorMessage);
                        } else {
                            return Mono.just("{\"error\":\"" + (errorMessage != null ? errorMessage.replace("\"", "'") : "Unknown error") + "\"}");
                        }
                    })
                    .block();
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
    
    @DeleteMapping
    public ResponseEntity<String> proxyDelete(@RequestParam String endpoint) {
        try {
            String response = webClient.delete()
                    .uri(endpoint)
                    .retrieve()
                    .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody)))
                    )
                    .bodyToMono(String.class)
                    .onErrorResume(e -> {
                        String errorMessage = e.getMessage();
                        if (errorMessage != null && errorMessage.startsWith("{")) {
                            return Mono.just(errorMessage);
                        } else {
                            return Mono.just("{\"error\":\"" + (errorMessage != null ? errorMessage.replace("\"", "'") : "Unknown error") + "\"}");
                        }
                    })
                    .block();
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response != null ? response : "{\"message\":\"Deleted successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage().replace("\"", "'") + "\"}");
        }
    }
}
