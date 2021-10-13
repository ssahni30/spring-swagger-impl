package com.swaggerApi.web.controller;

import com.swaggerApi.core.ENUM;
import com.swaggerApi.core.GetProductCountResponse;
import com.swaggerApi.core.GetProductResponse;
import com.swaggerApi.core.InvalidRequest;
import com.swaggerApi.core.Product;
import com.swaggerApi.core.UnauthorizedResponse;
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
 * Created by sagarsahni on 08/11/16.
 */
@Controller
public class ListingManagement {

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
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
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
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
    public @ResponseBody GetProductCountResponse getProductCount(@QueryParam("publishedStatus") ENUM.PublishedStatus publishedStatus,HttpServletRequest httpServletRequest) {
        GetProductCountResponse count = new GetProductCountResponse();
        count.setCount(BigDecimal.TEN);
        return count;
    }

    @RequestMapping(value = "/updateInventory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Inventory", notes = "Update Inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
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

    @RequestMapping(value = "/pricing/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Pricing", notes = "Update Pricing")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = InvalidRequest.class),
            @ApiResponse(code = 200, message = "Perfect"),
            @ApiResponse(code = 401, message = "Authentication Error", response = UnauthorizedResponse.class)})
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

}
