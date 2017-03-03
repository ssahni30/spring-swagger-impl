package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Created by apple on 15/11/16.
 */
@ApiModel
public class Variant {

    private String                  variantId = "123";

    private String                  title = "5 Buttons";

    private String                  imageUrl;

    private String                  productUrl;

    private String                  sku = "MOUSE5-123";

    private String                  size = "3X4X5";

    private String                  color = "Blue";

    private String                  productDescription;

    private boolean                 live = true;

    private int                     inventory = 100;

    private int                     blockedInventory = 1;

    private int                     pendency = 2;

    private ItemPrice               itemPrice;

    public Variant() {
        ItemPrice itemPrice = new ItemPrice();
        this.itemPrice = itemPrice;
    }

    @ApiModelProperty(value = "Url of product on channel")
    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @ApiModelProperty(value = "Image Url for Variant")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @ApiModelProperty(position = 1,required = true,value = "Variant Listed Identifier")
    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    @ApiModelProperty(position = 2,required = true,value = "Tile of Product Variant")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ApiModelProperty(position = 3,required = true,value = "SKU of an Item ")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @ApiModelProperty(position = 4, value = "Item Size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @ApiModelProperty(position = 5, value = "Item Color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @ApiModelProperty(position = 7, value = "Item Description")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @ApiModelProperty(position = 6, value = "Item Live or Not")
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    @ApiModelProperty(position = 9, value = "Available Inventory")
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @ApiModelProperty(position = 10, value = "Blocked Inventory")
    public int getBlockedInventory() {
        return blockedInventory;
    }

    public void setBlockedInventory(int blockedInventory) {
        this.blockedInventory = blockedInventory;
    }

    @ApiModelProperty(position = 11, value = "Pendency")
    public int getPendency() {
        return pendency;
    }

    public void setPendency(int pendency) {
        this.pendency = pendency;
    }

    @ApiModelProperty(position = 8, value = "Price Components", notes = "Required for Pricing Update Task")
    public ItemPrice getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(ItemPrice itemPriceprice) {
        this.itemPrice = itemPrice;
    }

    @ApiModel
    public class ItemPrice {

        private BigDecimal          listingPrice = BigDecimal.valueOf(500);

        private BigDecimal          mrp = BigDecimal.valueOf(600);

        private BigDecimal          msp = BigDecimal.valueOf(495);

        private BigDecimal          netSellerPayable = BigDecimal.valueOf(400);

        private String              currency = "INR";

        @ApiModelProperty(value = "Price Listed / Selling Price")
        public BigDecimal getListingPrice() {
            return listingPrice;
        }

        public void setListingPrice(BigDecimal listingPrice) {
            this.listingPrice = listingPrice;
        }

        @ApiModelProperty(value = "Actaul Price or MRP")
        public BigDecimal getMrp() {
            return mrp;
        }

        public void setMrp(BigDecimal mrp) {
            this.mrp = mrp;
        }

        @ApiModelProperty(value = "MSP")
        public BigDecimal getMsp() {
            return msp;
        }

        public void setMsp(BigDecimal msp) {
            this.msp = msp;
        }

        @ApiModelProperty(value = "Transfer Price = Listing Price - Channel Recovery")
        public BigDecimal getNetSellerPayable() {
            return netSellerPayable;
        }

        public void setNetSellerPayable(BigDecimal netSellerPayable) {
            this.netSellerPayable = netSellerPayable;
        }

        @ApiModelProperty(value = "Currency")
        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }


}
