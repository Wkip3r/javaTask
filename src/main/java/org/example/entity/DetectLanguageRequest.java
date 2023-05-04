package org.example.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetectLanguageRequest {

    private String text;

    private List<String> languageCodeHints;

    private String folderId;

    public DetectLanguageRequest(String text, List<String> languageCodeHints, String folderId) {
        this.text = text;
        this.languageCodeHints = languageCodeHints;
        this.folderId = folderId;
    }

    public DetectLanguageRequest() {}

    public DetectLanguageRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getLanguageCodeHints() {
        return languageCodeHints;
    }

    public void setLanguageCodeHints(List<String> languageCodeHints) {
        this.languageCodeHints = languageCodeHints;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    @Override
    public String toString() {
        return "DetectLanguageRequest{" +
                "text='" + text + '\'' +
                ", languageCodeHints=" + languageCodeHints +
                ", folderId='" + folderId + '\'' +
                '}';
    }
}
