package org.example;

import org.example.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class App {
    @Autowired
    private Reader reader;

    public void startAnalysisFile() throws IOException {
        reader.read();
    }
}
