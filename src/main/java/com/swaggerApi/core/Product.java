package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sagarsahni on 08/11/16.
 */
@ApiModel
public class Product {

    private String               id = "111111";

    private String               parentTitle = "Gaming Mouse";

    private String               brand = "Game";

    private List<Variant>        variants;

    private BigDecimal           commissionPercentage = BigDecimal.valueOf(5.3);

    private BigDecimal           paymentGatewayCharge = BigDecimal.valueOf(1.1);

    private BigDecimal           logisticsCost = BigDecimal.TEN;

    private String               additionalInfo;

    private Date                 created;

    public Product(){
        List<Variant> variantList = new ArrayList<>();
        variantList.add(new Variant());
        this.variants = variantList;
    }

    @ApiModelProperty(position = 1, required = true, value = "Product Identifier")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ApiModelProperty(position = 2, required = true, value = "General Title of Product")
    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    @ApiModelProperty(position = 4, value = "Brand or Vendor")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @ApiModelProperty(position = 5, required = true, value = "Variants of Product")
    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    @ApiModelProperty(position = 6, value = "Commission Percentage")
    public BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(BigDecimal commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    @ApiModelProperty(position = 7, value = "Payment Gateway Charges")
    public BigDecimal getPaymentGatewayCharge() {
        return paymentGatewayCharge;
    }

    public void setPaymentGatewayCharge(BigDecimal paymentGatewayCharge) {
        this.paymentGatewayCharge = paymentGatewayCharge;
    }

    @ApiModelProperty(position = 8, value = "Logistic Charges")
    public BigDecimal getLogisticsCost() {
        return logisticsCost;
    }

    public void setLogisticsCost(BigDecimal logisticsCost) {
        this.logisticsCost = logisticsCost;
    }

    @ApiModelProperty(position = 9, value = "Any other Info")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @ApiModelProperty(position = 10,example = "2017-01-02T08:12:53", value = "Product Created Date")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
