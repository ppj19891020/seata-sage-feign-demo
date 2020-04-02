package com.fly.seata.controller;

import com.fly.seata.api.OrderApi;
import com.fly.seata.api.StorageApi;
import com.fly.seata.dto.OrderDTO;
import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.statelang.domain.StateMachineInstance;
import io.seata.spring.annotation.GlobalTransactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: peijiepang
 * @date 2019-11-18
 * @Description:
 */
@RequestMapping("/tm")
@RestController
public class TmController {

  @Autowired
  private OrderApi orderApi;

  @Autowired
  private StorageApi storageApi;

  @Autowired
  private StateMachineEngine stateMachineEngine;

  @GlobalTransactional
  @GetMapping("/test")
  public String test(){
    orderApi.test();
    storageApi.test();
//    throw new RuntimeException("模拟抛出异常");
    return "ok";
  }

  /**
   * 模拟购买商品流程
   * @return
   */
  @GlobalTransactional
  @PostMapping("/purchase")
  public String purchase(@RequestBody OrderDTO orderDTO){
    Map<String, Object> startParams = new HashMap<>();
    startParams.put("order",orderDTO);
    StateMachineInstance stateMachineInstance = stateMachineEngine.start("purchaseProcess",null,startParams);
    return "执行状态:"+stateMachineInstance.getStatus().getStatusString();
  }

}
