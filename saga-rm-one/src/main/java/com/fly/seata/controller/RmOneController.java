package com.fly.seata.controller;

import com.fly.seata.dto.OrderDTO;
import io.seata.saga.engine.StateMachineEngine;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: peijiepang
 * @date 2019-11-18
 * @Description:
 */
@RequestMapping("/rm1")
@RestController
public class RmOneController {

  @Autowired
  private StateMachineEngine stateMachineEngine;

  @GetMapping("/test")
  public String test(){
    Map<String, Object> startParams = new HashMap<>();
    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setUserId(1l);
    orderDTO.setCount(1);
    orderDTO.setPrice(new BigDecimal(19));
    orderDTO.setProductId(1l);
    startParams.put("order",orderDTO);
    stateMachineEngine.start("orderProcess",null,startParams);
    return "ok";
  }

}
