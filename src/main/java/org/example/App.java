package org.example;

import org.example.reader.ReaderThread;
import org.example.writer.WriterThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class App {

    @Autowired
    private ReaderThread reader;

    @Autowired
    private WriterThread writer;

    public void startAnalysisFile() throws IOException {
        ExecutorService producer = Executors.newFixedThreadPool(25);
        ExecutorService consumer = Executors.newFixedThreadPool(25);

        producer.submit(reader);
        consumer.submit(writer);

        producer.shutdown();
        consumer.shutdown();
    }
}
