package com.satya.apiRateLimiter.controller;


import com.satya.apiRateLimiter.dtos.Areav1;
import com.satya.apiRateLimiter.dtos.RectangleDimensionsv1;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping(value = "/api/v1/area", consumes = MediaType.APPLICATION_JSON_VALUE)

public class AreaCalculatorController {

    private final Bucket bucket;
    public AreaCalculatorController(){
        Bandwidth limit = Bandwidth.classic(20 , Refill.greedy(20 , Duration.ofMinutes(1)));
        this.bucket = Bucket.builder()
                    .addLimit(limit)
                    .build();
    }

    @PostMapping(value = "/rectangle" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Areav1> rectangle(@RequestBody RectangleDimensionsv1 dimensions){

        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(new Areav1("Rectangle", dimensions.getBreadth() * dimensions.getLength()));
        }

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }



}
