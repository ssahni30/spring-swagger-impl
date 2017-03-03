package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Created by sagarsahni on 21/12/16.
 */
@ApiModel
public class UpdatePricing {
    private String variantId;

    private BigDecimal listingPrice;

    private BigDecimal mrp;

    private BigDecimal msp;

    @ApiModelProperty(position = 1, value = "Variant Id")
    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    @ApiModelProperty(position = 2, value = "New Listed Price")
    public BigDecimal getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(BigDecimal listingPrice) {
        this.listingPrice = listingPrice;
    }

    @ApiModelProperty(position = 3, value = "MRP")
    public BigDecimal getMrp() {
        return mrp;
    }

    public void setMrp(BigDecimal mrp) {
        this.mrp = mrp;
    }

    @ApiModelProperty(position = 4, value = "MSP")
    public BigDecimal getMsp() {
        return msp;
    }

    public void setMsp(BigDecimal msp) {
        this.msp = msp;
    }
}
