package org.example.api;

import org.springframework.stereotype.Component;

@Component
public abstract class LanguageApi {
    public abstract String getRowLanguage(String text);
}
