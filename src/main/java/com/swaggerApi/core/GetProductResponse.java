package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by sagarsahni on 29/11/16.
 */
@ApiModel
public class GetProductResponse {

    private List<Product> products;

    @ApiModelProperty(position = 1, required = true, value = "Products")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
