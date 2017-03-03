package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sagarsahni on 20/12/16.
 */
@ApiModel
public class Inventory {

    private String variantId;

    private int inventory;

    @ApiModelProperty(position = 1, required = true, value = "Variant Id")
    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId ) {
        this.variantId = variantId;
    }

    @ApiModelProperty(position = 2, required = true, value = "Variant Inventory")
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
