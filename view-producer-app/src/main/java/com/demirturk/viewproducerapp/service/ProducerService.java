package com.demirturk.viewproducerapp.service;

import com.demirturk.viewproducerapp.model.ProductView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
@Service
public class ProducerService {
    private static final String TOPIC_NAME = "SendProductView";

    private final KafkaTemplate<String, ProductView> kafkaTemplate;

    @PostConstruct
    public void send() {
        ObjectMapper mapper = new ObjectMapper();
        try (
                FileReader fileReader = new FileReader("src/main/resources/product-views.json");
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                kafkaTemplate.send(TOPIC_NAME, mapper.readValue(currentLine, ProductView.class));
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (IOException ex) {
            log.error(ex.getMessage(), "io exception");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
