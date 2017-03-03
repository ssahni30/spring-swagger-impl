package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sagarsahni on 20/12/16.
 */
@ApiModel
public class OrderItemLabelRequest {

    private String orderItemId;

    private String invoiceNumber;

    private BigDecimal taxRate;

    private Date invoiceDate;

    @ApiModelProperty(position = 1, required = true, value = "Order Items Label")
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    @ApiModelProperty(position = 2, required = true, value = "Invoice Number")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @ApiModelProperty(position = 4, required = true, value = "Tax Rate")
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @ApiModelProperty(position = 3,example = "2017-01-02T08:12:53", required = true, value = "Invoice Date")
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
