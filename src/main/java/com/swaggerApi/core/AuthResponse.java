package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class AuthResponse {


    private ENUM.AuthenticationStatus status;

    private String accessToken;

    @ApiModelProperty(position = 1, required = true, value = "Status for given Request")
    public ENUM.AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(ENUM.AuthenticationStatus status) {
        this.status = status;
    }

    @ApiModelProperty(position = 2, value = "Authentication Token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
