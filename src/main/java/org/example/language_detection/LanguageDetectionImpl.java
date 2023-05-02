package org.example.language_detection;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;
import org.springframework.stereotype.Component;

@Component("languageDetectionBean")
public class LanguageDetectionImpl implements LanguageDetection{

    private final LanguageDetector languageDetector = LanguageDetectorBuilder
            .fromAllLanguages()
            .withPreloadedLanguageModels()
            .build();

    @Override
    public String detectLanguage(String row) {
        Language detectedLanguage = this.languageDetector.detectLanguageOf(row);

        return detectedLanguage.toString();
    }
}
