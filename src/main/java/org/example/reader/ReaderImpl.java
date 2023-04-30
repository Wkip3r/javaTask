package org.example.reader;

import org.example.language_detection.LanguageDetection;
import org.example.writer.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component("readerBean")
public class ReaderImpl implements Reader {

    @Value("${task.fileName}")
    private String fileName;

    private long rowCount;

    @Autowired
    private Writer writer;

    @Autowired
    private LanguageDetection languageDetection;

    @Override
    public void read()  {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String language = languageDetection.detectLanguage(line);
                writer.write(++this.rowCount,language,line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
