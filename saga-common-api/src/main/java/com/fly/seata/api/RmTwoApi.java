package com.fly.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: peijiepang
 * @date 2019-11-18
 * @Description:
 */
@FeignClient(name = "seata-sage-rm-two")
public interface RmTwoApi {

  @GetMapping("/rm2/test")
  String test();

}
