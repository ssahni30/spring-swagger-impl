package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class Order {
    private String               id = "Order-123";

    private Date                 orderDate;

    private ENUM.OrderStatus     orderStatus = ENUM.OrderStatus.CREATED;

    private Date                 sla;

    private int                  priority = 3;

    private String               paymentType = "COD";

    private boolean              taxExempted = false;

    private boolean              cFormProvided = false;

    private boolean              thirdPartyShipping = false;

    private String               additionalInfo;

    private List<OrderItem>     orderItems;

    private OrderPrice           orderPrice;

    private Address              billingAddress;

    private Address              shippingAddress;

    public Order(){
        OrderPrice orderPrice = new OrderPrice();
        this.orderPrice = orderPrice;
        Address address = new Address();
        this.shippingAddress = address;
        this.billingAddress = address;
    }

    @ApiModelProperty(position = 10, value = "Is CForm Provided" )
    public boolean iscFormProvided() {
        return cFormProvided;
    }

    public void setcFormProvided(boolean cFormProvided) {
        this.cFormProvided = cFormProvided;
    }

    @ApiModelProperty(position = 10, value = "Is Third Party Shipping" )
    public boolean isThirdPartyShipping() {
        return thirdPartyShipping;
    }

    public void setThirdPartyShipping(boolean thirdPartyShipping) {
        this.thirdPartyShipping = thirdPartyShipping;
    }

    @ApiModelProperty(position = 1, required = true, value = "Order ID")
    public String getId() {
        return id;
    }

    @ApiModelProperty(position = 2,example = "2017-01-02T08:12:53", required = true, value = "Order Date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ApiModelProperty(position = 3, required = true, value = "Order Status values =  PENDING_VERIFICATION or CREATED or PROCESSING or COMPLETE or CANCELLED" )
    public ENUM.OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ENUM.OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @ApiModelProperty(position = 4,example = "2017-01-02T08:12:53",value = "SLA or Fulfillment By" )
    public Date getSla() {
        return sla;
    }

    public void setSla(Date sla) {
        this.sla = sla;
    }

    @ApiModelProperty(position = 5, value = "Priority - High Value equals High Priority" )
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @ApiModelProperty(position = 6, value = "Payment Type - COD or PREPAID" )
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @ApiModelProperty(position = 9, value = "Is Tax Exempted" )
    public boolean isTaxExempted() {
        return taxExempted;
    }

    public void setTaxExempted(boolean taxExempted) {
        this.taxExempted = taxExempted;
    }

    @ApiModelProperty(position = 13, value = "Additional Info" )
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @ApiModelProperty(position = 8, required = true, value = "Sale Order Items" )
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @ApiModelProperty(position = 7,value = "Sale Order Pricing Components" )
    public OrderPrice getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(OrderPrice orderPrice) {
        this.orderPrice = orderPrice;
    }

    @ApiModelProperty(position = 12,required = true,value = "Billing Address" )
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @ApiModelProperty(position = 11,required = true,value = "Shipping Address" )
    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @ApiModel
    public class OrderPrice {

        private BigDecimal          totalShippingCharges = BigDecimal.valueOf(100);

        private BigDecimal          totalDiscount = BigDecimal.ZERO;

        private BigDecimal          totalPrepaidAmount = BigDecimal.ZERO;

        private BigDecimal          totalGiftCharges = BigDecimal.ZERO;

        private BigDecimal          totalCashOnDeliveryCharges = BigDecimal.ZERO;

        private String              currency = "INR";

        @ApiModelProperty(value = "Total COD Charges" )
        public BigDecimal getTotalCashOnDeliveryCharges() {
            return totalCashOnDeliveryCharges;
        }

        public void setTotalCashOnDeliveryCharges(BigDecimal totalCashOnDeliveryCharges) {
            this.totalCashOnDeliveryCharges = totalCashOnDeliveryCharges;
        }

        @ApiModelProperty(value = "Total Shipping Charges" )
        public BigDecimal getTotalShippingCharges() {
            return totalShippingCharges;
        }

        public void setTotalShippingCharges(BigDecimal totalShippingCharges) {
            this.totalShippingCharges = totalShippingCharges;
        }

        @ApiModelProperty(value = "Total Discount On Order" )
        public BigDecimal getTotalDiscount() {
            return totalDiscount;
        }

        public void setTotalDiscount(BigDecimal totalDiscount) {
            this.totalDiscount = totalDiscount;
        }

        @ApiModelProperty(value = "Total Amount Paid" )
        public BigDecimal getTotalPrepaidAmount() {
            return totalPrepaidAmount;
        }

        public void setTotalPrepaidAmount(BigDecimal totalPrepaidAmount) {
            this.totalPrepaidAmount = totalPrepaidAmount;
        }

        @ApiModelProperty(value = "Total Gift Charges" )
        public BigDecimal getTotalGiftCharges() {
            return totalGiftCharges;
        }

        public void setTotalGiftCharges(BigDecimal totalGiftCharges) {
            this.totalGiftCharges = totalGiftCharges;
        }

        @ApiModelProperty(value = "Currency" )
        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
