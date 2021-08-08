package com.musinsa.urlshortening.domain.url;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    Optional<ShortUrl> findByShortKey(String shortKey);

}
