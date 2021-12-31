package com.demirturk.productrecommendapp.controller;

import com.demirturk.productrecommendapp.exception.ProductRecommendAppException;
import com.demirturk.productrecommendapp.model.DeleteProductViewRequest;
import com.demirturk.productrecommendapp.model.ProductResponse;
import com.demirturk.productrecommendapp.service.ProductViewService;
import com.demirturk.productrecommendapp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.ProductViewController.CONTROLLER)
@RequiredArgsConstructor
@Api(value = ApiPaths.ProductViewController.CONTROLLER, tags = { "Products View APIs" })
@Slf4j
public class ProductViewController {

    private final ProductViewService productViewService;

    @ApiOperation(value = "Last ten products viewed apis", response = ProductResponse.class)
    @GetMapping(value = "/{userId}")
    public ProductResponse getLastTenProductsViewedByUser(@PathVariable String userId)
            throws ProductRecommendAppException {
        return productViewService.getLastTenProductsViewedByUser(userId);
    }

    @ApiOperation(value = "Last ten products viewed apis", response = ProductResponse.class)
    @DeleteMapping
    public Boolean deleteProductViewByUserIdAndProductId(@RequestBody DeleteProductViewRequest deleteProductViewRequest)  {
        return productViewService.deleteProductViewByUserIdAndProductId(deleteProductViewRequest);
    }
}
