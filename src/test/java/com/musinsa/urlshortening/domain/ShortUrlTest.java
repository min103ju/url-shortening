package com.musinsa.urlshortening.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.urlshortening.domain.url.ShortUrl;
import org.junit.jupiter.api.Test;

public class ShortUrlTest {

    @Test
    void encodeBase62() {
        // given & when
        String expected = "bTJPw";
        ShortUrl shortUrl = ShortUrl.builder().url("https://www.musinsa.com").build();

        // then
        assertThat(shortUrl.getShortKey()).isEqualTo(expected);
    }
}
