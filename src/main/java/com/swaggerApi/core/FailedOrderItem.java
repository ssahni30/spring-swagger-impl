package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class FailedOrderItem {

    private String orderItemId;

    private String errorMessage;

    @ApiModelProperty(position = 1, required = true, value = "Order Item ID")
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }


    @ApiModelProperty(position = 2, required = true, value = "Error Message")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
