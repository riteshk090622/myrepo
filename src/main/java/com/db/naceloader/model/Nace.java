package com.db.naceloader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nace {

    @Id
    private Integer orderId;
    private Integer level;
    private String code;
    private String parent;
    private String description;
    private String includes;
    private String alsoIncludes;
    private String rulings;
    private String excludes;
    private String reference;

    public Nace(){

    }

    public Nace(Integer orderId, Integer level, String code){
        this.orderId = orderId;
        this.level = level;
        this.code = code;
    }

    public Nace(Integer orderId, Integer level, String code, String parent, String description, String includes, String alsoIncludes, String rulings, String excludes, String reference) {
        this.orderId = orderId;
        this.level = level;
        this.code = code;
        this.parent = parent;
        this.description = description;
        this.includes = includes;
        this.alsoIncludes = alsoIncludes;
        this.rulings = rulings;
        this.excludes = excludes;
        this.reference = reference;
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getIncludes() {
        return includes;
    }

    public void setIncludes(String includes) {
        this.includes = includes;
    }

    public String getAlsoIncludes() {
        return alsoIncludes;
    }

    public void setAlsoIncludes(String alsoIncludes) {
        this.alsoIncludes = alsoIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getExcludes() {
        return excludes;
    }

    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
