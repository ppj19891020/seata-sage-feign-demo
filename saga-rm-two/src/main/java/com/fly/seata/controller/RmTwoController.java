package com.fly.seata.controller;

import io.seata.saga.engine.StateMachineEngine;
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
@RequestMapping("/rm2")
@RestController
public class RmTwoController {

  @Autowired
  private StateMachineEngine stateMachineEngine;

  @GetMapping("/test")
  public String test(){
    Map<String,Object> startParms = new HashMap<>();
    startParms.put("productId",1L);
    startParms.put("count",1);
    stateMachineEngine.start("storageProcess",null,startParms);
    return "ok";
  }

}
