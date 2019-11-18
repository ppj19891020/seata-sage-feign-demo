package com.fly.seata.controller;

import com.fly.seata.api.RmOneApi;
import com.fly.seata.api.RmTwoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  private RmOneApi rmOneApi;

  @Autowired
  private RmTwoApi rmTwoApi;

  @GetMapping("/test")
  public String test(){
    rmOneApi.test();
    rmTwoApi.test();
    return "ok";
  }

}
