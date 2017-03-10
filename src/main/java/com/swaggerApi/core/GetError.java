package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

/**
 * Created by admin on 08/03/17.
 */
@ApiModel
public class GetError {

    private String code;

    private String message;

    private Map<String,String> params;

    @ApiModelProperty(position = 1,value = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ApiModelProperty(position = 2,value = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @ApiModelProperty(position = 3,value = "params")
    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
