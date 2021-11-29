package com.itkorba.urlshortner.Models;

import org.springframework.lang.NonNull;

public class UrlStructure {
        @NonNull
        private  String shortURL;
        @NonNull
        private  String longURL;

    public String getShortURL() {
        return shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setShortURL(String shortURL) {
         this.shortURL=shortURL;
    }

    public void setLongURL(@NonNull String longURL) {
        this.longURL = longURL;
    }
}
