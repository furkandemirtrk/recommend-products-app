package com.demirturk.streamreaderapp.service;

import com.demirturk.streamreaderapp.model.ProductView;
import com.demirturk.streamreaderapp.repository.ProductViewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ProductViewService {

    private final ProductViewRepository productViewRepository;

    @KafkaListener(topics = "SendProductView",containerFactory = "kafkaListenerContainerFactory")
    public void consume(ProductView productView){
        log.info("Save productView : ".concat(productView.toString()));
        productViewRepository.save(productView);
    }
}
