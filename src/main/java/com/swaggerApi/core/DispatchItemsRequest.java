package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class DispatchItemsRequest {

    private List<OrderItemsDispatchRequest> orderItems;

    private SelfShipping selfShipping;

    @ApiModelProperty(position = 1, required = true, value = "Order Items")
    public List<OrderItemsDispatchRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsDispatchRequest> orderItems) {
        this.orderItems = orderItems;
    }

    @ApiModelProperty(position = 1, value = "", notes = "only if self Shipping")
    public SelfShipping getSelfShipping() {
        return selfShipping;
    }

    public void setSelfShipping(SelfShipping selfShipping) {
        this.selfShipping = selfShipping;
    }

}
