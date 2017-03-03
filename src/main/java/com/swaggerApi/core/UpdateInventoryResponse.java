package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class UpdateInventoryResponse {

    private ENUM.Status status = ENUM.Status.FAILED;

    private List<FailedVariant> failedVariantsList;

    @ApiModelProperty(position = 1, required = true, value = "SUCCESS or FAILED or PARTIAL_SUCCESS")
    public ENUM.Status getStatus() {
        return status;
    }

    public void setStatus(ENUM.Status status) {
        this.status = status;
    }

    @ApiModelProperty(position = 2, value = "", notes = "In Case of FAILED OR PARTIAL_SUCCESS")
    public List<FailedVariant> getFailedVariantsList() {
        return failedVariantsList;
    }

    public void setFailedVariantsList(List<FailedVariant> failedVariantsList)
    {
        this.failedVariantsList = failedVariantsList;
    }

    @ApiModel
    public static class FailedVariant {
        private String variantId = "abcdef";

        private String message = "Variant Id not available";

        @ApiModelProperty(position = 1, value = "Variant Id that Failed")
        public String getVariantId() {
            return variantId;
        }

        public void setVariantId(String variantId) {
            this.variantId = variantId;
        }

        @ApiModelProperty(position = 2, value = "Reason For Failure")
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
