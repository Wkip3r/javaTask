package org.example.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

@Component
public abstract class LanguageApi {
    public abstract String getRowLanguage(String text) throws HttpStatusCodeException;
}
