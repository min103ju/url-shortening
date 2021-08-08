package com.musinsa.urlshortening.web;

import com.musinsa.urlshortening.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final ShortUrlService shortUrlService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/redirect/{shortKey}")
    public String redirect(@PathVariable("shortKey") String shortKey) throws NotFoundException {
        String originUrl = shortUrlService.findOriginUrl(shortKey);
        return "redirect:" + originUrl;
    }

}
