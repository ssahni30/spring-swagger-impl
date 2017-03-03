package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Created by sagarsahni on 29/11/16.
 */
@ApiModel
public class GetProductCountResponse {

    private BigDecimal count;

    @ApiModelProperty(position = 1, required = true, value = "Count of the total Products")
    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
