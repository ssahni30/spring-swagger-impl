package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Created by apple on 17/11/16.
 */

@ApiModel
public class OrderItem {

    private String  orderItemId = "orderitem-1234";

    private String  productId = "111111";

    private String  variantId = "123";

    private String  sku = "MOUSE5-123";

    private String  title = "Gaming Mouse 5 Buttons";

    private ENUM.OrderItemStatus status = ENUM.OrderItemStatus.CREATED;

    private ENUM.ShippingMethod  shippingMethodCode = ENUM.ShippingMethod.STD;

    private int quantity = 1;

    private boolean onHold = false;

    private int packetNumber;

    private OrderItemPrice  orderItemPrice;

    private GiftWrap    giftWrap;

    public OrderItem() {
        GiftWrap giftWrap = new GiftWrap();
        this.giftWrap = giftWrap;
        OrderItemPrice orderItemPrice = new OrderItemPrice();
        this.orderItemPrice = orderItemPrice;
    }

    @ApiModelProperty(position = 1, required = true, value = "Order Item Id" )
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    @ApiModelProperty(position = 2, required = true, value = "Product Id" )
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @ApiModelProperty(position = 3, required = true, value = "Variant Id" )
    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    @ApiModelProperty(position = 4, required = true, value = "Order Item SKU" )
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @ApiModelProperty(position = 5, required = true, value = "Product Title + Variant Title" )
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ApiModelProperty(position = 6, value = "STD (Standard) or EXP (Express) or PKP (Pickup) or CHQ (Standard Cheque)" )
    public ENUM.ShippingMethod getShippingMethodCode() {
        return shippingMethodCode;
    }

    public void setShippingMethodCode(ENUM.ShippingMethod shippingMethodCode) {
        this.shippingMethodCode = shippingMethodCode;
    }

    @ApiModelProperty(position = 7, value = "Quantity" )
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ApiModelProperty(position = 9, value = "On Hold" )
    public boolean isOnHold() {
        return onHold;
    }

    public void setOnHold(boolean onHold) {
        this.onHold = onHold;
    }

    @ApiModelProperty(position = 10, value = "Divide Items in Different Packages - ShipTogether" )
    public int getPacketNumber() {
        return packetNumber;
    }

    public void setPacketNumber(int packetNumber) {
        this.packetNumber = packetNumber;
    }

    @ApiModelProperty(position = 7, value = "Order Item Price Components" )
    public OrderItemPrice getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(OrderItemPrice orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    @ApiModelProperty(position = 8, value = "Only If Gift Wrap Applicable" )
    public GiftWrap getGiftWrap() {
        return giftWrap;
    }

    public void setGiftWrap(GiftWrap giftWrap) {
        this.giftWrap = giftWrap;
    }

    @ApiModelProperty(position = 1,required = true,value = "Order Item Status" )
    public ENUM.OrderItemStatus getStatus() {
        return status;
    }

    public void setStatus(ENUM.OrderItemStatus status) {
        this.status = status;
    }

    @ApiModel
    public class OrderItemPrice {

        private BigDecimal          sellingPrice = BigDecimal.valueOf(500);

        private BigDecimal          shippingCharges = BigDecimal.valueOf(100);

        private BigDecimal          discount = BigDecimal.ZERO;

        private BigDecimal          cashOnDeliveryCharges = BigDecimal.ZERO;

        private BigDecimal          totalPrice = sellingPrice.add(shippingCharges).subtract(discount).add(cashOnDeliveryCharges);

        private BigDecimal          transferPrice = BigDecimal.valueOf(450);

        private String              currency = "INR";

        @ApiModelProperty(position = 1, value = "COD Charges" )
        public BigDecimal getCashOnDeliveryCharges() {
            return cashOnDeliveryCharges;
        }

        public void setCashOnDeliveryCharges(BigDecimal cashOnDeliveryCharges) {
            this.cashOnDeliveryCharges = cashOnDeliveryCharges;
        }

        @ApiModelProperty(position = 1, value = "Selling Price" )
        public BigDecimal getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(BigDecimal sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        @ApiModelProperty(position = 2, value = "Shipping Charges" )
        public BigDecimal getShippingCharges() {
            return shippingCharges;
        }

        public void setShippingCharges(BigDecimal shippingCharges) {
            this.shippingCharges = shippingCharges;
        }

        @ApiModelProperty(position = 3, value = "Discount" )
        public BigDecimal getDiscount() {
            return discount;
        }

        public void setDiscount(BigDecimal discount) {
            this.discount = discount;
        }

        @ApiModelProperty(position = 4, value = "Final Price" )
        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
        }

        @ApiModelProperty(position = 5, value = "Channel Recovery" )
        public BigDecimal getTransferPrice() {
            return transferPrice;
        }

        public void setTransferPrice(BigDecimal transferPrice) {
            this.transferPrice = transferPrice;
        }

        @ApiModelProperty(position = 6, value = "Currency" )
        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    @ApiModel
    public class GiftWrap {

        private String  giftWrapMessage = "HAPPY BIRTHDAY";

        private BigDecimal  giftWrapCharges = BigDecimal.ZERO;

        @ApiModelProperty(position = 1, value = "Gift Wrap Message" )
        public String getGiftWrapMessage() {
            return giftWrapMessage;
        }

        public void setGiftWrapMessage(String giftWrapMessage) {
            this.giftWrapMessage = giftWrapMessage;
        }

        @ApiModelProperty(position = 2, value = "Gift Wrap Charges" )
        public BigDecimal getGiftWrapCharges() {
            return giftWrapCharges;
        }

        public void setGiftWrapCharges(BigDecimal giftWrapCharges) {
            this.giftWrapCharges = giftWrapCharges;
        }
    }
}
