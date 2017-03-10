package com.swaggerApi.web.controller;

import com.swaggerApi.core.Address;
import com.swaggerApi.core.CourierDetailResponse;
import com.swaggerApi.core.DispatchItemsRequest;
import com.swaggerApi.core.DispatchItemsResponse;
import com.swaggerApi.core.ENUM;
import com.swaggerApi.core.FailedOrderItem;
import com.swaggerApi.core.GetOrderResponse;
import com.swaggerApi.core.InvalidRequest;
import com.swaggerApi.core.Order;
import com.swaggerApi.core.OrderItem;
import com.swaggerApi.core.UnauthorizedResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by admin on 04/03/17.
 */
@Controller
public class OrderProcessing {

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Fetch Orders", notes = "Get Orders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "Page Number",required = false, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "Page Size", required = false, dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "orderIds", value = "Comma Seperated Product Order Ids",required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderItemIds", value = "Comma Seperated Product Order Item Ids", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderDateFrom", value = "Order Date From Format - yyyy-MM-dd'T'HH:mm:ss ",example = "2017-01-02T08:12:53", required = false, dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "orderDateTo", value = "Order Date To Format - yyyy-MM-dd'T'HH:mm:ss",example = "2017-01-02T08:12:53", required = false, dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "orderStatus", value = "Comma Seperated values - CANCELLED or COMPLETE or PROCESSING or CREATED or PENDING_VERIFICATION", required = false, dataType = "String", paramType = "query")

    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
    public @ResponseBody GetOrderResponse getOrders(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize,@QueryParam("orderIds") String orderIds, @QueryParam("orderItemIds") String orderItemIds, @QueryParam("orderDateFrom") String orderDateFrom,@QueryParam("orderDateTo") String orderDateTo, @QueryParam("orderStatus") String orderStatus, HttpServletRequest httpServletRequest) {
        Order order = new Order();
        order.setBillingAddress(new Address());
        order.setShippingAddress(new Address());
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem());
        order.setOrderItems(orderItems);
        GetOrderResponse orderResponse = new GetOrderResponse();
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderResponse.setOrders(orderList);
        return orderResponse;
    }

    @RequestMapping(value = "/orders/dispatch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Dispatch Orders", notes = "Dispatch Orders - Ready to Ship")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
    public @ResponseBody DispatchItemsResponse dispatchItems(@RequestBody DispatchItemsRequest request,HttpServletRequest httpServletRequest) {
        DispatchItemsResponse dispatchItemsResponse = new DispatchItemsResponse();
        dispatchItemsResponse.setStatus(ENUM.Status.PARTIAL_SUCCESS);
        if(request.getOrderItems().size() == 1){
            dispatchItemsResponse.setStatus(ENUM.Status.FAILED);
        }
        FailedOrderItem failedOrderItem = new FailedOrderItem();
        failedOrderItem.setErrorMessage("order Item Id not available");
        failedOrderItem.setOrderItemId(request.getOrderItems().get(0).getOrderItemId());
        List<FailedOrderItem> failedOrderItems = new ArrayList<>();
        failedOrderItems.add(failedOrderItem);
        dispatchItemsResponse.setOrderItems(failedOrderItems);
        return dispatchItemsResponse;
    }

    @RequestMapping(value = "/courierDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderItemIds", value = "Comma Seperated Order Item Id's", required = true, dataType = "String", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
    public @ResponseBody CourierDetailResponse courierDetail(@QueryParam("orderItemIds") String orderItemIds) {
        CourierDetailResponse courierDetailResponse = new CourierDetailResponse();
        return courierDetailResponse;
    }

}
