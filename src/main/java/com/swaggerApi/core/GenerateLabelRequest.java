package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class GenerateLabelRequest {

    private List<OrderItemLabelRequest> orderItems;

    private int                 boxLength;

    private int                 boxWidth;

    private int                 boxHeight;

    private Integer             estimatedWeight;

    @ApiModelProperty(position = 4, required = true, value = "Order Items")
    public List<OrderItemLabelRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemLabelRequest> orderItems) {
        this.orderItems = orderItems;
    }

    @ApiModelProperty(position = 1, required = true, value = "Box Length (in mm)")
    public int getBoxLength() {
        return boxLength;
    }

    public void setBoxLength(int boxLength) {
        this.boxLength = boxLength;
    }

    @ApiModelProperty(position = 1,value = "Box Width (in mm)")
    public int getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(int boxWidth) {
        this.boxWidth = boxWidth;
    }

    @ApiModelProperty(position = 2, value = "Box Height (in mm)")
    public int getBoxHeight() {
        return boxHeight;
    }

    public void setBoxHeight(int boxHeight) {
        this.boxHeight = boxHeight;
    }

    @ApiModelProperty(position = 3, value = "Box Weight (in kg)")
    public Integer getEstimatedWeight() {
        return estimatedWeight;
    }

    public void setEstimatedWeight(Integer estimatedWeight) {
        this.estimatedWeight = estimatedWeight;
    }
}
