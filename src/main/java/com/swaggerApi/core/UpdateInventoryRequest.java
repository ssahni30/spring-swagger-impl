package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by sagarsahni on 17/11/16.
 */
@ApiModel
public class UpdateInventoryRequest {

    private List<Inventory> inventoryList;

    @ApiModelProperty(position = 1, required = true, value = "Inventory Update List")
    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public UpdateInventoryRequest() {
    }

}
