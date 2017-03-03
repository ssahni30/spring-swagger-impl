package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class UpdatePricingRequest {

    private List<UpdatePricing> pricingList;

    @ApiModelProperty(position = 1, value = "")
    public List<UpdatePricing> getPricingList() {
        return pricingList;
    }

    public void setPricingList(List<UpdatePricing> pricingList)
    {
        this.pricingList = pricingList;
    }

}
