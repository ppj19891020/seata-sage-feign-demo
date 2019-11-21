package com.fly.seata.service;

import com.fly.seata.dto.OrderDTO;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 下单服务
 * @author: peijiepang
 * @date 2019-11-19
 * @Description:
 */
@Slf4j
@Service("orderService")
public class OrderService {

  /**
   * 返回下单流程
   * @param order
   * @return
   */
  public String createOrder(OrderDTO order){
    String orderNo = UUID.randomUUID().toString();
    log.info("模拟下单成功流程,订单号：{} 订单信息:{}",orderNo,order.toString());
    throw new RuntimeException("模拟下单失败！！！");
//    return UUID.randomUUID().toString();
  }

  /**
   * 下单通知消息
   */
  public void orderCreateMessage(String orderNo){
    log.info("下单通知消息,订单号:{}",orderNo);
  }

  /**
   * 下单失败消息
   * @param order
   */
  public boolean createOrderFailMessage(OrderDTO order){
    log.info("下单失败消息，下单信息:{}",order.toString());
    return true;
  }

}
