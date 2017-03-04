package com.swaggerApi.web.controller;

import com.swaggerApi.core.Address;
import com.swaggerApi.core.CourierDetailResponse;
import com.swaggerApi.core.DispatchItemsRequest;
import com.swaggerApi.core.DispatchItemsResponse;
import com.swaggerApi.core.ENUM;
import com.swaggerApi.core.FailedOrderItem;
import com.swaggerApi.core.GetOrderResponse;
import com.swaggerApi.core.GetProductCountResponse;
import com.swaggerApi.core.GetProductResponse;
import com.swaggerApi.core.Order;
import com.swaggerApi.core.OrderItem;
import com.swaggerApi.core.Product;
import com.swaggerApi.core.SettlementReportResponse;
import com.swaggerApi.core.SettlementResponse;
import com.swaggerApi.core.UpdateInventoryRequest;
import com.swaggerApi.core.UpdateInventoryResponse;
import com.swaggerApi.core.UpdatePricingRequest;
import com.swaggerApi.core.UpdatePricingResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * Created by apple on 08/11/16.
 */
@Controller
public class ApiDocs {

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Fetch Products", notes = "Get Products")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "Page Number", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "Page Size", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "skus", value = "Comma Seperated Product Sku's", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "publishedStatus", value = "published or unpublished -> default: any", required = false, dataType = "com.swaggerApi.core.ENUM.PublishedStatus", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
    public @ResponseBody GetProductResponse getProduct(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize, @QueryParam("skus")
            String skus, @QueryParam("publishedStatus") ENUM.PublishedStatus publishedStatus, HttpServletRequest httpServletRequest) {
        GetProductResponse getProductResponse = new GetProductResponse();
        Product product = new Product();
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        getProductResponse.setProducts(productList);
        return getProductResponse;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "publishedStatus", value = "published or unpublished -> default: any", required = false, dataType = "com.swaggerApi.core.ENUM.PublishedStatus", paramType = "query")
    })
    @RequestMapping(value = "/productsCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Fetch Products Count", notes = "Get Products Count")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
    public @ResponseBody GetProductCountResponse getProductCount(@QueryParam("publishedStatus") ENUM.PublishedStatus publishedStatus,HttpServletRequest httpServletRequest) {
        GetProductCountResponse count = new GetProductCountResponse();
        count.setCount(BigDecimal.TEN);
        return count;
    }


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
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
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

    @RequestMapping(value = "/updateInventory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Inventory", notes = "Update Inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
    public @ResponseBody UpdateInventoryResponse updateInventory(@RequestBody UpdateInventoryRequest request) {
        UpdateInventoryResponse updateInventoryResponse = new UpdateInventoryResponse();
        updateInventoryResponse.setStatus(ENUM.Status.PARTIAL_SUCCESS);
        if(request.getInventoryList().size() == 1){
            updateInventoryResponse.setStatus(ENUM.Status.FAILED);
        }
        UpdateInventoryResponse.FailedVariant failedVariant = new UpdateInventoryResponse.FailedVariant();
        failedVariant.setMessage("Variant Not Available");
        failedVariant.setVariantId(request.getInventoryList().get(0).getVariantId());
        List<UpdateInventoryResponse.FailedVariant> failedVariantList = new ArrayList<>();
        failedVariantList.add(failedVariant);
        updateInventoryResponse.setFailedVariantsList(failedVariantList);
        return updateInventoryResponse;
    }

    @RequestMapping(value = "/orders/dispatch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Dispatch Orders", notes = "Dispatch Orders - Ready to Ship")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
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

    @RequestMapping(value = "/pricing/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Pricing", notes = "Update Pricing")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
    public @ResponseBody UpdatePricingResponse updatePricing(@RequestBody UpdatePricingRequest request,HttpServletRequest httpServletRequest) {
        UpdatePricingResponse updatePricingResponse = new UpdatePricingResponse();
        UpdatePricingResponse.FailedPricings failedPricings = new UpdatePricingResponse.FailedPricings();
        failedPricings.setVariantId(request.getPricingList().get(0).getVariantId());
        if(request.getPricingList().size() >= 1){
            updatePricingResponse.setStatus(ENUM.Status.PARTIAL_SUCCESS);
        }
        List<UpdatePricingResponse.FailedPricings> failedPricingsList = new ArrayList<>();
        failedPricingsList.add(failedPricings);
        updatePricingResponse.setFailedPricingsList(failedPricingsList);
        return updatePricingResponse;
    }

    @RequestMapping(value = "/settlements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Settlement IDs", notes = "Get Settlement Ids")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "availableFrom",example = "2017-01-02T08:12:53", value = "availableFrom - Format - yyyy-MM-dd'T'HH:mm:ss", dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "availableTo",example = "2017-01-02T08:12:53", value = "availableTo - Format - yyyy-MM-dd'T'HH:mm:ss", dataType = "date", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect"), })
    public @ResponseBody SettlementReportResponse settlementReport(@QueryParam("availableFrom") Date availableFrom,@QueryParam("availableTo") Date availableTo,HttpServletRequest httpServletRequest) {
        SettlementReportResponse settlementReportResponse = new SettlementReportResponse();
        SettlementReportResponse.SettlementReport settlementReport = new SettlementReportResponse.SettlementReport("998888",new Date(),"Settled");
        SettlementReportResponse.SettlementReport settlementReport1 = new SettlementReportResponse.SettlementReport("998877",new Date(),"UnSettled");
        List<SettlementReportResponse.SettlementReport> settlementReportList = new ArrayList<>();
        settlementReportList.add(settlementReport);
        settlementReportList.add(settlementReport1);
        settlementReportResponse.setSettlementReportList(settlementReportList);
        return settlementReportResponse;
    }

    @RequestMapping(value = "/settlement", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Settlement", notes = "Get Settlement")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "settlementId", value = "SettlementId",required = true, dataType = "String", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Perfect"), })
    public @ResponseBody SettlementResponse settlementReport(@QueryParam("settlementId") String settlementId,HttpServletRequest httpServletRequest) {
        SettlementResponse settlementResponse = new SettlementResponse();
        return settlementResponse;
    }

    @RequestMapping(value = "/courierDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderItemIds", value = "Comma Seperated Order Item Id's", required = true, dataType = "String", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 200, message = "Perfect") })
    public @ResponseBody CourierDetailResponse courierDetail(@QueryParam("orderItemIds") String orderItemIds) {
        CourierDetailResponse courierDetailResponse = new CourierDetailResponse();
        return courierDetailResponse;
    }


}
