package com.amp.trimit.dto;

import lombok.Getter;

@Getter
public class TrimUrlResponse {
    
    private String longUrl;
    private String shortUrl;
    private String message;

    public TrimUrlResponse(String longUrl2, String urlString, String string) {
        this.longUrl = longUrl2;
        this.shortUrl = urlString;
        this.message = string;
    }
}
