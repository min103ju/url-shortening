package com.musinsa.urlshortening.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    void validateUrlTest() {
        // given & when & then
        assertThatThrownBy(() -> {
            CommonUtils.validateUrl("not url");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertHashTest() {
        // given
        String url = "https://www.musinsa.com";

        // when
        int hash = CommonUtils.hashUrl(url);

        // then
        assertThat(hash).isEqualTo(url.hashCode());
    }

}
