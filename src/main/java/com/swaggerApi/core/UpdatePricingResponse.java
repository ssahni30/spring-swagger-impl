package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by sagarsahni on 17/11/16.
 */
@ApiModel
public class UpdatePricingResponse {

    private ENUM.Status status;

    private List<FailedPricings> failedPricingsList;

    public UpdatePricingResponse() {
        this.status = ENUM.Status.FAILED;
    }

    @ApiModelProperty(position = 1, required = true, value = "SUCCESS or FAILED or PARTIAL_SUCCESS")
    public ENUM.Status getStatus() {
        return status;
    }

    public void setStatus(ENUM.Status status) {
        this.status = status;
    }

    @ApiModelProperty(position = 2, value = "failed update Sku Pricing")
    public List<FailedPricings> getFailedPricingsList() {
        return failedPricingsList;
    }

    public void setFailedPricingsList(List<FailedPricings> failedPricingsList)
    {
        this.failedPricingsList = failedPricingsList;
    }

    @ApiModel
    public static class FailedPricings {
        private String variantId;

        private String Message;

        public FailedPricings() {
            Message = "Invalid Id";
        }

        @ApiModelProperty(position = 1, required = true, value = "Variant Id")
        public String getVariantId() {
            return variantId;
        }

        public void setVariantId(String variantId) {
            this.variantId = variantId;
        }

        @ApiModelProperty(position = 2, required = true, value = "Message")
        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }
    }
}
