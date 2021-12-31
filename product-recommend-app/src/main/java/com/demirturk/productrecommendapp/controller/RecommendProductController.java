package com.demirturk.productrecommendapp.controller;

import com.demirturk.productrecommendapp.exception.ProductRecommendAppException;
import com.demirturk.productrecommendapp.model.ProductResponse;
import com.demirturk.productrecommendapp.service.RecommendService;
import com.demirturk.productrecommendapp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.RecommendProductController.CONTROLLER)
@RequiredArgsConstructor
@Api(value = ApiPaths.RecommendProductController.CONTROLLER, tags = { "Recommend Product APIs" })
@Slf4j
public class RecommendProductController {

    private final RecommendService recommendService;

    @ApiOperation(value = "Bestsellers by category apis", response = ProductResponse.class)
    @GetMapping(value = "/{userId}")
    public ProductResponse getRecommendProducts(@PathVariable String userId)
            throws ProductRecommendAppException {
        return recommendService.recommendProduct(userId);
    }
}
