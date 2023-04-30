package org.example.language_detection;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;
import org.springframework.stereotype.Component;

@Component("languageDetectionBean")
public class LanguageDetectionImpl implements LanguageDetection{

    @Override
    public String detectLanguage(String row) {
        LanguageDetector languageDetector = LanguageDetectorBuilder.fromAllLanguages().build();
        Language detectedLanguage = languageDetector.detectLanguageOf(row);

        return detectedLanguage.toString();
    }
}
