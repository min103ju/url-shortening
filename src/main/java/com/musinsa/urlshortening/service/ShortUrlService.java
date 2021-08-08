package com.musinsa.urlshortening.service;

import com.musinsa.urlshortening.domain.url.ShortUrl;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface ShortUrlService {

    String getShortUrl(final String url);

    ShortUrl insertShortUrl(final String url);

    String findOriginUrl(final String shortKey) throws NotFoundException;
}
