package com.amp.trimit.service;

import org.springframework.stereotype.Service;


@Service
public interface UrlTrimService {
    
    String trimUrl(String longUrl);

    String findUrlByCode(String code);
}
