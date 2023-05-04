package org.example.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;


@Component
public class WriterThread implements Runnable{

    private final BlockingQueue<String> blockingQueue;

    @Value("${task.outputFileName}")
    private String outputFile;

    @Autowired
    public WriterThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter((outputFile));

            while(true){
                String buffer = blockingQueue.take();
                if(buffer.equals("EOF")){
                    break;
                }
                System.out.println(buffer);
                writer.println(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(InterruptedException e){

        } finally{
            writer.close();
        }
    }
}