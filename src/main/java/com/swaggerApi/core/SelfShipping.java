package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Created by sagarsahni on 20/12/16.
 */
@ApiModel
public class SelfShipping {

    private Date dispatchDate;

    private String invoiceNumber;

    private Date invoiceDate;

    private String deliveryPartner;

    private String trackingId;

    private Date tentativeDeliveryDate;

    @ApiModelProperty(example = "2017-01-02T08:12:53",value = "Tentative Delivery Date")
    public Date getTentativeDeliveryDate() {
        return tentativeDeliveryDate;
    }

    public void setTentativeDeliveryDate(Date tentativeDeliveryDate) {
        this.tentativeDeliveryDate = tentativeDeliveryDate;
    }

    @ApiModelProperty(example = "2017-01-02T08:12:53",value = "Dispatch Date")
    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    @ApiModelProperty(value = "Invoice Number")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @ApiModelProperty(example = "2017-01-02T08:12:53",value = "Invoice Date")
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @ApiModelProperty(value = "Delivery Partner")
    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    @ApiModelProperty(value = "Tracking Id")
    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }
}