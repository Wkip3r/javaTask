package org.example.reader;

import org.example.api.LanguageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

@Component
public class ReaderThread implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    @Value("${task.fileName}")
    private String fileName;

    @Autowired
    private LanguageApi api;

    private long rowCount;

    @Autowired
    public ReaderThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader((fileName)));
            String buffer;

            while ((buffer = br.readLine()) != null) {
                if (!buffer.isEmpty() && !buffer.isBlank()) {
                    try {
                        String language = api.getRowLanguage(buffer);
                        String result = ++this.rowCount + ": " + language + ": " + buffer;
                        blockingQueue.put(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
            blockingQueue.put("EOF");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {

        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}