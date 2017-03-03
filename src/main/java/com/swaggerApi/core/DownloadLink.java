package com.swaggerApi.core;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by apple on 18/11/16.
 */
public class DownloadLink {

    private String url;

    @ApiModelProperty(position = 1, required = true, value = "Download Link")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
