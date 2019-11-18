package com.fly.seata.controller;

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

  @GetMapping("/test")
  public String test(){

    return "ok";
  }

}
