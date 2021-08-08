package com.musinsa.urlshortening.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.urlshortening.domain.url.ShortUrl;
import com.musinsa.urlshortening.domain.url.ShortUrlRepository;
import com.musinsa.urlshortening.utils.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ShortUrlRepositoryTest {

    private final String url = "https://musinsa.com";
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ShortUrlRepository shortUrlRepository;

    ShortUrl shortUrl;

    @BeforeEach
    void setUp() {
        shortUrl = ShortUrl.builder().url(url).build();
        entityManager.persist(shortUrl);
        entityManager.flush();
    }

    @Test
    void findShortUrlTest() {
        // given
        String shortKey = CommonUtils.convertShortKey(url);

        // when
        ShortUrl findShortUrl = shortUrlRepository.findByShortKey(shortKey).get();

        // then
        assertThat(findShortUrl).isEqualTo(shortUrl);
    }

}
