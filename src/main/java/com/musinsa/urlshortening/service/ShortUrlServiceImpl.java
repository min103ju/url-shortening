package com.musinsa.urlshortening.service;

import com.musinsa.urlshortening.domain.url.ShortUrl;
import com.musinsa.urlshortening.domain.url.ShortUrlRepository;
import com.musinsa.urlshortening.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Transactional
    @Override
    public String getShortUrl(final String url) {
        ShortUrl shortUrl = shortUrlRepository.findByShortKey(CommonUtils.convertShortKey(url))
            .orElseGet(() -> insertShortUrl(url));
        shortUrl.increaseCount();
        return shortUrl.getShortUrl();
    }

    @Transactional
    @Override
    public ShortUrl insertShortUrl(final String url) {
        return shortUrlRepository.save(
            ShortUrl.builder().url(url).build()
        );
    }

    @Transactional(readOnly = true)
    @Override
    public String findOriginUrl(String shortKey) throws NotFoundException {
        return shortUrlRepository.findByShortKey(shortKey)
            .orElseThrow(() -> new NotFoundException()).getUrl();
    }

}
