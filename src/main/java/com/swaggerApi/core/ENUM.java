package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;

/**
 * Created by apple on 18/11/16.
 */
@ApiModel
public class ENUM {

    @ApiModel
    public enum AuthenticationStatus {
        SUCCESS,
        INVALID_CREDENTIALS
    }

    @ApiModel
    public enum CourierStatus {
        AVAILABLE,
        SELLER_SHIPPING,
        COURIER_NOT_ASSIGNED
    }

    @ApiModel
    public enum OrderStatus {
        CANCELLED,
        COMPLETE,
        PROCESSING,
        CREATED,
        PENDING_VERIFICATION
    }

    @ApiModel
    public enum OrderItemStatus {
        CANCELLED,
        CREATED,
        PROCESSING,
        PACKED,
        READY_TO_DISPATCH,
        DISPATCHED,
        DELIVERED,
        REPLACED,
        RETURN_REQUESTED,
        RETURNED
    }

    @ApiModel
    public enum ShippingMethod {
        STD,
        EXP,
        PKP,
        CHQ
    }

    @ApiModel
    public enum Status {
        SUCCESS,
        FAILED,
        PARTIAL_SUCCESS
    }

    @ApiModel
    public enum PublishedStatus {
        PUBLISHED,
        UNPUBLISHED
    }

    @ApiModel
    public enum TransactionType {
        ORDER,
        RETURN,
        OTHER_TRANSACTION
    }

    @ApiModel
    public enum AmountType {
        PRINCIPAL,
        SHIPPING,
        OTHER_ITEM_PRICE_CHARGES,
        COMMISSION,
        FIXED_FEE,
        SHIPPING_FEE,
        TOTAL_TAX,
        OTHER_ITEM_CHARGES,
        REFUND_COMMISSION,
        ORDER_CANCELLATION_CHARGE,
        DISCOUNT
    }

}
