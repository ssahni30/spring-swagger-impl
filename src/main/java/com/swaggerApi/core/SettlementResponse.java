package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sagarsahni on 28/12/16.
 */
@ApiModel
public class SettlementResponse {

    private List<OrderItems> orderItemsList;

    private Date settlementStartDate;

    private Date settlementEndDate;

    private Date depositDate;

    private BigDecimal totalAmount = BigDecimal.valueOf(300);

    private String  currency = "INR";

    private String settlementSheetUrl = "www.github.com/ssahni30";

    public SettlementResponse() {
        List<AmountBreakdown> amountBreakdownList = new ArrayList<>();
        AmountBreakdown breakdownO = new AmountBreakdown(ENUM.AmountType.PRINCIPAL,BigDecimal.valueOf(1000));
        AmountBreakdown breakdownO1 = new AmountBreakdown(ENUM.AmountType.COMMISSION,BigDecimal.valueOf(-100));
        AmountBreakdown breakdownO2 = new AmountBreakdown(ENUM.AmountType.FIXED_FEE,BigDecimal.valueOf(-50));
        AmountBreakdown breakdownO3 = new AmountBreakdown(ENUM.AmountType.SHIPPING_FEE,BigDecimal.valueOf(-150));
        AmountBreakdown breakdownO4 = new AmountBreakdown(ENUM.AmountType.TOTAL_TAX,BigDecimal.valueOf(-150));
        amountBreakdownList.add(breakdownO);
        amountBreakdownList.add(breakdownO1);
        amountBreakdownList.add(breakdownO2);
        amountBreakdownList.add(breakdownO3);
        amountBreakdownList.add(breakdownO4);
        OrderItems orderItem1 = new OrderItems("12345","abcdef", ENUM.TransactionType.RETURN,BigDecimal.valueOf(650),BigDecimal.valueOf(350),amountBreakdownList);
        List<AmountBreakdown> amountBreakdowns = new ArrayList<>();
        AmountBreakdown breakdownR = new AmountBreakdown(ENUM.AmountType.PRINCIPAL,BigDecimal.valueOf(-500));
        AmountBreakdown breakdownR1 = new AmountBreakdown(ENUM.AmountType.COMMISSION,BigDecimal.valueOf(-100));
        AmountBreakdown breakdownR2 = new AmountBreakdown(ENUM.AmountType.REFUND_COMMISSION,BigDecimal.valueOf(100));
        AmountBreakdown breakdownR3 = new AmountBreakdown(ENUM.AmountType.SHIPPING_FEE,BigDecimal.valueOf(100));
        AmountBreakdown breakdownR4 = new AmountBreakdown(ENUM.AmountType.TOTAL_TAX,BigDecimal.valueOf(50));
        amountBreakdowns.add(breakdownR);
        amountBreakdowns.add(breakdownR1);
        amountBreakdowns.add(breakdownR2);
        amountBreakdowns.add(breakdownR3);
        amountBreakdowns.add(breakdownR4);
        OrderItems orderItem2 = new OrderItems("12300","abcdas", ENUM.TransactionType.RETURN,BigDecimal.valueOf(-350),BigDecimal.valueOf(250),amountBreakdowns);
        List<OrderItems> orderItemsList = new ArrayList<>();
        orderItemsList.add(orderItem1);
        orderItemsList.add(orderItem2);
        this.orderItemsList = orderItemsList;
    }

    @ApiModelProperty (example = "2017-01-02T08:12:53",value = "Settlement Start Date")
    public Date getSettlementStartDate() {
        return settlementStartDate;
    }

    public void setSettlementStartDate(Date settlementStartDate) {
        this.settlementStartDate = settlementStartDate;
    }

    @ApiModelProperty(example = "2017-01-02T08:12:53",value = "Settlement End Date")
    public Date getSettlementEndDate() {
        return settlementEndDate;
    }

    public void setSettlementEndDate(Date settlementEndDate) {
        this.settlementEndDate = settlementEndDate;
    }

    @ApiModelProperty(example = "2017-01-02T08:12:53",value = "Amount Deposited or to be Deposited")
    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    @ApiModelProperty(required = true, value = "Total Amount Transfered to seller")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @ApiModelProperty(value = "Currency Code")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @ApiModelProperty(value = "Report Sheet")
    public String getSettlementSheetUrl() {
        return settlementSheetUrl;
    }

    public void setSettlementSheetUrl(String settlementSheetUrl) {
        this.settlementSheetUrl = settlementSheetUrl;
    }

    @ApiModelProperty(position = 1,required = true, value = "Reports")
    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItems> orderItemsList)
    {
        this.orderItemsList = orderItemsList;
    }

    @ApiModel
    public class OrderItems {

        private String orderId;

        private String  orderItemId;

        private Date orderDate;

        private int quantity = 1;

        private ENUM.TransactionType transactionType;

        private BigDecimal amountTransferredToSeller;

        private BigDecimal amountDeductedByChannel;

        private List<AmountBreakdown> amountBreakdownList;

        public OrderItems(String orderId, String orderItemId, ENUM.TransactionType transactionType,
                BigDecimal amountTransferredToSeller, BigDecimal amountDeductedByChannel,
                List<AmountBreakdown> amountBreakdownList)
        {
            this.orderId = orderId;
            this.orderItemId = orderItemId;
            this.transactionType = transactionType;
            this.amountTransferredToSeller = amountTransferredToSeller;
            this.amountDeductedByChannel = amountDeductedByChannel;
            this.amountBreakdownList = amountBreakdownList;
        }

        @ApiModelProperty(position = 1,required = true, value = "Order Id")
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        @ApiModelProperty(required = true, value = "Quantity")
        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @ApiModelProperty(position = 3,required = true, value = "Amount Transfered to Seller")
        public BigDecimal getAmountTransferredToSeller() {
            return amountTransferredToSeller;
        }

        public void setAmountTransferredToSeller(BigDecimal amountTransferredToSeller) {
            this.amountTransferredToSeller = amountTransferredToSeller;
        }

        @ApiModelProperty(position = 4,required = true, value = "Amount Deducted")
        public BigDecimal getAmountDeductedByChannel() {
            return amountDeductedByChannel;
        }

        public void setAmountDeductedByChannel(BigDecimal amountDeductedByChannel) {
            this.amountDeductedByChannel = amountDeductedByChannel;
        }

        @ApiModelProperty(required = true, value = "Breakdown")
        public List<AmountBreakdown> getAmountBreakdownList() {
            return amountBreakdownList;
        }

        public void setAmountBreakdownList(List<AmountBreakdown> amountBreakdownList) {
            this.amountBreakdownList = amountBreakdownList;
        }

        @ApiModelProperty(position = 2,required = true, value = "Order Item Id")
        public String getOrderItemId() {
            return orderItemId;
        }

        public void setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
        }

        @ApiModelProperty(example = "2017-01-02T08:12:53",required = true, value = "Order Item Id")
        public Date getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        @ApiModelProperty(position = 5,required = true, value = "Transaction Type")
        public ENUM.TransactionType getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(ENUM.TransactionType transactionType) {
            this.transactionType = transactionType;
        }
    }

    @ApiModel
    public class AmountBreakdown {

        private ENUM.AmountType amountType;

        private String amountDescription;

        private BigDecimal amount;

        public AmountBreakdown(ENUM.AmountType amountType, BigDecimal amount) {
            this.amountType = amountType;
            this.amount = amount;
        }

        @ApiModelProperty(position = 1,required = true, value = "Amount Type")
        public ENUM.AmountType getAmountType() {
            return amountType;
        }

        public void setAmountType(ENUM.AmountType amountType) {
            this.amountType = amountType;
        }

        @ApiModelProperty(position = 3,value = "Description if any")
        public String getAmountDescription() {
            return amountDescription;
        }

        public void setAmountDescription(String amountDescription) {
            this.amountDescription = amountDescription;
        }

        @ApiModelProperty(position = 2,required = true, value = "Amount")
        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }
}
