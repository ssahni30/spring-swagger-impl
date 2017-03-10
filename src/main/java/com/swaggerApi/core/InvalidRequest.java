package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by admin on 08/03/17.
 */
@ApiModel
public class InvalidRequest {

    private List<GetError> errors;

    @ApiModelProperty(position = 1,value = "erros")
    public List<GetError> getErrors() {
        return errors;
    }

    public void setErrors(List<GetError> errors) {
        this.errors = errors;
    }
}
