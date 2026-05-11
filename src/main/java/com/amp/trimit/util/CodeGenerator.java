package com.amp.trimit.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {

    // Maps to store URL mappings
    private static Map<String, String> shortUrlMap = new HashMap<>();
    private static Map<String, String> longUrlMap = new HashMap<>();

    // Counter (simulating auto-increment ID)
    private static long counter = 101;

    private static final String BASE_URL = "http://localhost:8080/";//"http://trimit/";
 


    //base 62 are [0–9][a-z][A-Z] , length 7
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String codeFromUrlString(String longUrlString){
       
        if(longUrlMap.containsKey(longUrlString)){
            return BASE_URL+longUrlMap.get(longUrlString);
        }

        String code = convertToBase62(counter ,longUrlString);
       

        counter ++;
        // Store mapping
        shortUrlMap.put(code, longUrlString);
        longUrlMap.put(longUrlString, code);
        
   

        return BASE_URL+code;
    }

    private static String convertToBase62(long counter, String longUrlString) {
        StringBuilder sb = new StringBuilder();

        while (counter>0){
            int remainder= (int)(counter % 62);
            sb.append(BASE62.charAt(remainder));
            counter =counter/62;
        }

        return sb.reverse().toString();
    }

    public String findUrlByCode(String code){
      
        shortUrlMap.forEach((k, v) -> System.out.printf(" findByCode  ::: "+"%-15s : %s%n", k, v));
        if(shortUrlMap.containsKey(code)){
           
            return shortUrlMap.get(code);
        }
        return "Url Not Found";
    }
    
}
