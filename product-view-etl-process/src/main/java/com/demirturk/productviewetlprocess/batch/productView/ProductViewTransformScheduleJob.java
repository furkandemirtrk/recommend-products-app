package com.demirturk.productviewetlprocess.batch.productView;


import com.demirturk.productviewetlprocess.exception.EtlProcessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductViewTransformScheduleJob {

    private final ProductViewTransformProcess productViewTransformProcess;

    @Scheduled(fixedDelay = 200000)
    public void runProductViewTransformScheduleJob() throws EtlProcessException {
        log.info("ProductViewTransformScheduleJob JOB starting : ".concat(LocalDateTime.now().toString()));
        productViewTransformProcess.run();
        log.info("ProductViewTransformScheduleJob JOB ended : ".concat(LocalDateTime.now().toString()));
    }
}
