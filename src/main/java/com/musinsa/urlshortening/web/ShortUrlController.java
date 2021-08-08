package com.musinsa.urlshortening.web;

import com.musinsa.urlshortening.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping("/shorten")
    public ResponseEntity shorten(String url) {
        return new ResponseEntity(shortUrlService.getShortUrl(url), HttpStatus.OK);
    }


}
