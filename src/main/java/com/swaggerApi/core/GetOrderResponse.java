package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagarsahni on 29/11/16.
 */
@ApiModel
public class GetOrderResponse {

    private List<Order> orders = new ArrayList<>();

    @ApiModelProperty(position = 1, required = true, value = "List of Orders")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
