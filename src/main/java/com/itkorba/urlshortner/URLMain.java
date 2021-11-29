package com.itkorba.urlshortner;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class URLMain {
    private int length;
    private String domain;
    private Map<String, String> ShortToLongURL;
    private Map<String, String> LongToShortURL;
    private final ArrayList<Character> allowedChar;

    URLMain(){
        this("localhost:8080",6);
    }
    URLMain(String domain, int length){
        this.length = length;
        this.domain = domain;

        this.ShortToLongURL = new HashMap<>();
        LongToShortURL = new HashMap<>();
        this.allowedChar = new ArrayList<>();
        for(char i='a';i<='z';i++){
            this.allowedChar.add(i);
        }
        for(char i='A';i<='Z';i++){
            this.allowedChar.add(i);
        }
        for(char i='0';i<='9';i++){
            this.allowedChar.add(i);
        }
    }

    public String shortenURL(String LongURL){
        if(!LongToShortURL.containsKey(LongURL)) {
            String shortURL = "";
            while (true) {
                for (int i = 0; i < this.length; i++) {
                    Random random = new Random();
                    int index = random.nextInt(61);
                    char ch = this.allowedChar.get(index);
                    shortURL += ch;
                }
                if (!ShortToLongURL.containsKey(shortURL)) break;
            }
            ShortToLongURL.put(shortURL, LongURL);
            LongToShortURL.put(LongURL, shortURL);
            return "http://"+domain+'/'+shortURL;

        }else{
            return "http://"+domain+'/'+LongToShortURL.get(LongURL);
        }
    }

    public String expandURL(String ShortURL) throws Exception{
        if(ShortToLongURL.containsKey(ShortURL)){
            return ShortToLongURL.get(ShortURL);
        }
        throw new Exception("No Short URL Found");
    }
}