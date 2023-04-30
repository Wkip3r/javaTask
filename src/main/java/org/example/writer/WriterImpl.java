package org.example.writer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component("writerBean")
public class WriterImpl implements Writer {

    @Value("${task.outputFileName}")
    private String outputFileName;

    @Override
    public void write(long rowCount,String language,String text) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.outputFileName, true)))) {
            String result = rowCount + ": " + language + ": " + text;
            System.out.println(result);
            out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
