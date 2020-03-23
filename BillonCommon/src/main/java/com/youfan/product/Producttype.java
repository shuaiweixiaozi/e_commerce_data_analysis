package com.youfan.product;

public class Producttype {
    private Integer id;
  private String productTypeName;
    private String productTypeleave;
   private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeleave() {
        return productTypeleave;
    }

    public void setProductTypeleave(String productTypeleave) {
        this.productTypeleave = productTypeleave;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
