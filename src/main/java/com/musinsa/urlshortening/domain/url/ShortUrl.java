package com.musinsa.urlshortening.domain.url;

import com.musinsa.urlshortening.constants.Constants;
import com.musinsa.urlshortening.utils.CommonUtils;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pkey;

    @Column(nullable = false)
    private String url;

    @Column(length = 8, unique = true)
    private String shortKey;

    @Column(unique = true)
    private String shortUrl;

    @Column
    private long reqCount = 0L;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    private ShortUrl(String url) {
        CommonUtils.validateUrl(url);
        this.url = url;
        this.shortKey = CommonUtils.convertShortKey(this.url);
        this.shortUrl = Constants.CURRENT_PATH + this.shortKey;
    }

    public String getShortKey() {
        return shortKey;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getUrl() {
        return url;
    }

    public void increaseCount() {
        this.reqCount++;
    }


}
