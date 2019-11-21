package com.fly.seata.dto;

import java.math.BigDecimal;

/**
 * 订单dto
 * @author: peijiepang
 * @date 2019-11-19
 * @Description:
 */
public class OrderDTO {

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 商品id
   */
  private Long productId;

  /**
   * 数量
   */
  private Integer count;

  /**
   * 总价
   */
  private BigDecimal price;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "OrderDTO{" +
        "userId=" + userId +
        ", productId=" + productId +
        ", count=" + count +
        ", price=" + price +
        '}';
  }
}
