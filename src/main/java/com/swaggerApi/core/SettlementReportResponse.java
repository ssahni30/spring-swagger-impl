package com.swaggerApi.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;

/**
 * Created by apple on 17/11/16.
 */
@ApiModel
public class SettlementReportResponse {

    private List<SettlementReport> settlementReportList;

    @ApiModelProperty(position = 1,required = true, value = "Report List")
    public List<SettlementReport> getSettlementReportList() {
        return settlementReportList;
    }

    public void setSettlementReportList(List<SettlementReport> settlementReportList)
    {
        this.settlementReportList = settlementReportList;
    }

    @ApiModel
    public static class SettlementReport {

        private String settlementId;

        private Date   created;

        private String status;

        public SettlementReport(String settlementId, Date created, String status) {
            this.settlementId = settlementId;
            this.created = created;
            this.status = status;
        }

        @ApiModelProperty(position = 1,required = true, value = "Settlement Id")
        public String getReportId() {
            return settlementId;
        }

        public void setReportId(String settlementId) {
            this.settlementId = settlementId;
        }

        @ApiModelProperty(position = 2,value = "created")
        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        @ApiModelProperty(position = 2,value = "Status")
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
