package org.example.entity;

import org.springframework.stereotype.Component;

@Component
public class DetectLanguageResponse {

    private String languageCode;

    public DetectLanguageResponse() {}

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        return "DetectLanguageResponse{" +
                "languageCode='" + languageCode + '\'' +
                '}';
    }
}
