package com.demirturk.productviewetlprocess.batch.product;

import com.demirturk.productviewetlprocess.exception.EtlProcessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductTransformScheduleJob {

    private final ProductTransformProcess productTransformProcess;

    @Scheduled(fixedDelay = 200000)
    public void runProductTransformScheduleJob() throws EtlProcessException {
        log.info("runProductTransformScheduleJob JOB starting : ".concat(LocalDateTime.now().toString()));
        productTransformProcess.run();
        log.info("runProductTransformScheduleJob JOB ended : ".concat(LocalDateTime.now().toString()));
    }
}
