package com.db.naceloader.model;

public class NaceBuilder {
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

    public NaceBuilder setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public NaceBuilder setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public NaceBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public NaceBuilder setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public NaceBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public NaceBuilder setIncludes(String includes) {
        this.includes = includes;
        return this;
    }

    public NaceBuilder setAlsoIncludes(String alsoIncludes) {
        this.alsoIncludes = alsoIncludes;
        return this;
    }

    public NaceBuilder setRulings(String rulings) {
        this.rulings = rulings;
        return this;
    }

    public NaceBuilder setExcludes(String excludes) {
        this.excludes = excludes;
        return this;
    }

    public NaceBuilder setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public Nace createNace() {
        return new Nace(orderId, level, code, parent, description, includes, alsoIncludes, rulings, excludes, reference);
    }
}