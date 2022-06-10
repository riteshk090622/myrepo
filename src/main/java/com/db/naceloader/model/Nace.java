package com.db.naceloader.model;

public class Nace {
    private Integer orderId;
    private Integer level;
    private String code;

    public Nace(Integer orderId, Integer level, String code) {
        this.orderId = orderId;
        this.level = level;
        this.code = code;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
