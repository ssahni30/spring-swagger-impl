package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by admin on 08/03/17.
 */
@ApiModel
public class UnauthorizedResponse {

    private String              description;

    private String reason = "authToken expired/Invalid authToken";

    @ApiModelProperty(position = 1,value = "Reason",example = "authToken expired/Invalid authToken")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @ApiModelProperty(position = 2,value = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
