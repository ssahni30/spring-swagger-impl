package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by sagarsahni on 17/11/16.
 */
@ApiModel
public class GenerateLabelResponse {

    private ENUM.Status status;

    private List<FailedOrderItem> orderItems;

    @ApiModelProperty(position = 2, value = "Failed Order Items", notes = "In Case of FAILED OR PARTIAL_SUCCESS")
    public List<FailedOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<FailedOrderItem> orderItems)
    {
        this.orderItems = orderItems;
    }

    @ApiModelProperty(position = 1, required = true, value = "SUCCESS or FAILED or PARTIAL_SUCCESS")
    public ENUM.Status getStatus() {
        return status;
    }

    public void setStatus(ENUM.Status status) {
        this.status = status;
    }

}
