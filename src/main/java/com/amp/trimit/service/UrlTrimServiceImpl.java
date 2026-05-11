package com.amp.trimit.service;

import org.springframework.stereotype.Service;

import com.amp.trimit.util.CodeGenerator;


@Service
public class UrlTrimServiceImpl implements UrlTrimService {

    private final CodeGenerator codeGenerator;

    private static final String URL_REGEX =
        "^(https?://)([\\w.-]+)(:[0-9]+)?(/.*)?$";

    
    public UrlTrimServiceImpl(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }
    

    public String trimUrl (String longUrlString){
        if (!longUrlString.matches(URL_REGEX)) {
            System.out.println("URL not matching ************");
            throw new IllegalArgumentException("Invalid URL format");
        }
        return codeGenerator.codeFromUrlString(longUrlString);
        
    }

    public String findUrlByCode(String code){
         return codeGenerator.findUrlByCode(code);
    }
}
