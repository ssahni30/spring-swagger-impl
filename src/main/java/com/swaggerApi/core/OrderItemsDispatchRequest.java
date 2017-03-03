package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Created by sagarsahni on 20/12/16.
 */
@ApiModel
public class OrderItemsDispatchRequest {

    private int quantity;

    private String orderItemId;

    private BigDecimal taxRate;

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @ApiModelProperty(position = 2, required = true, value = "Quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ApiModelProperty(position = 1, required = true, value = "Order Item ID")
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

}
