package com.musinsa.urlshortening.constants;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public final class Constants {

    public static final String CURRENT_PATH = ServletUriComponentsBuilder.fromCurrentContextPath()
        .toUriString() + "/";

}
