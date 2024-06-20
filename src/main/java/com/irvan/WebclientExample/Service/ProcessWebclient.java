package com.irvan.WebclientExample.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ProcessWebclient {
    private String urlString = "https://api.zippopotam.us/us/53418";
    private String urlString2 = "https://api.zippopotam.us/us/33162";
    private long timeout = 10000;

    public ResponseEntity<String> processRandom() {
        ResponseEntity<String> response = null;
        WebClient webClient = WebClient.create();
        Mono<ResponseEntity<String>> responseMono = webClient.get()
                .uri(urlString)
//                    .header("Authorization","xxx")
                .accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
                .retrieve()
                .onRawStatus(status -> status >= 300, responseNOK -> Mono.empty())
                .toEntity(String.class)
                .timeout(Duration.ofSeconds(timeout));

        response = responseMono.block();
        return response;
    }
}
