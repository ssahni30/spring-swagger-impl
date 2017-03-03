package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sagarsahni on 20/12/16.
 */
@ApiModel
public class CourierDetailResponse {

    private ENUM.CourierStatus status = ENUM.CourierStatus.AVAILABLE;

    private String awbNo = "qgshu1363";

    private String courierCode = "FD";

    private String courierName = "Fastest Delivery";

    private String  additionalInfo;

    @ApiModelProperty(position = 1, required = true, value = "Status")
    public ENUM.CourierStatus getStatus() {
        return status;
    }

    public void setStatus(ENUM.CourierStatus status) {
        this.status = status;
    }

    @ApiModelProperty(position = 2, required = true, value = "Courier Code")
    public String getCourierCode() {
        return courierCode;
    }

    public void setCourierCode(String courierCode) {
        this.courierCode = courierCode;
    }

    @ApiModelProperty(position = 3, value = "Courier Name")
    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    @ApiModelProperty(position = 4, value = "Additional Info")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @ApiModelProperty(position = 1, required = true, value = "Awb No/Tracking Number")
    public String getAwbNo() {
        return awbNo;
    }

    public void setAwbNo(String awbNo) {
        this.awbNo = awbNo;
    }
}
