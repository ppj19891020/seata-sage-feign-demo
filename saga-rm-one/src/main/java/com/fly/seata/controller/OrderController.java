package com.fly.seata.controller;

import com.fly.seata.dto.OrderDTO;
import com.fly.seata.service.OrderService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务
 * @author: peijiepang
 * @date 2019-11-21
 * @Description:
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  /**
   * 生成订单号服务
   * @return
   */
  @GetMapping("/createOrderNo")
  public String createOrderNo(){
    String orderNo = UUID.randomUUID().toString();
    log.info("生成订单号成功,订单号为:{}",orderNo);
    return UUID.randomUUID().toString();
  }

  /**
   * 创建订单服务
   * @param orderDTO
   * @return
   */
  @PostMapping(value = "/createOrderNo",consumes = MediaType.APPLICATION_JSON_VALUE)
  public String createOrder(@RequestBody OrderDTO orderDTO){
    orderService.createOrder(orderDTO);
    return "ok";
  }

  /**
   * 取消订单服务
   * @param orderNo
   * @param type 类型 1：订单号生成失败  2：订单生成失败
   */
  @GetMapping("/canal/{orderNo}")
  public void canalOrder(@PathVariable("orderNo") String orderNo,@RequestParam("type") Integer type){
    log.info("取消订单成功，订单号为:{} type:{}",orderNo,type);
    orderService.canalOrder(orderNo);
  }

}
