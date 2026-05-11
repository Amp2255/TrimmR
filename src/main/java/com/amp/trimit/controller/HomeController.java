package com.amp.trimit.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amp.trimit.dto.TrimUrlRequest;
import com.amp.trimit.dto.TrimUrlResponse;
import com.amp.trimit.service.UrlTrimService;


@RestController
public class HomeController{

    private final UrlTrimService urlTrimService;

    public HomeController(UrlTrimService urlTrimService){
        this.urlTrimService = urlTrimService;
    }


    @PostMapping("/api/shorten")
    public ResponseEntity<TrimUrlResponse> shortenUrl(@RequestBody TrimUrlRequest urlRequest) {
        
        try {
            String urlString = urlRequest.getLongUrl();
            String shortUrl = urlTrimService.trimUrl(urlString);
            TrimUrlResponse trimUrlResponse = new TrimUrlResponse(
                urlRequest.getLongUrl(),
                shortUrl,
                "URL shortened successfully"
            );
            return new ResponseEntity<>(trimUrlResponse, HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            TrimUrlResponse trimUrlResponse = new TrimUrlResponse(
                urlRequest.getLongUrl(),
                null,
                e.getMessage()
            );
            return new ResponseEntity<>(trimUrlResponse, HttpStatusCode.valueOf(400));
        }
    }

    // @GetMapping("/{code}")
    // public ResponseEntity<Void> redirect(@PathVariable String code) {
    //     System.out.println(" code *****"+ code);
    //     String longUrl = urlTrimService.findUrlByCode(code);
    //     if (longUrl == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.status(302)
    //         .location(URI.create(longUrl))
    //         .build();
    // }
    
}