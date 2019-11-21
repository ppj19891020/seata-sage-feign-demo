package com.fly.seata.controller;

import com.fly.seata.dto.StorageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存接口
 * @author: peijiepang
 * @date 2019-11-21
 * @Description:
 */
@Slf4j
@RequestMapping("/storage")
@RestController
public class StorageController {

  /***
   * 扣减库存
   * @param storageDTO
   */
  @PostMapping(value = "/reduce",consumes = MediaType.APPLICATION_JSON_VALUE)
  public void reduce(StorageDTO storageDTO){
    log.info("订单号:{} 扣减库存成功,{}",storageDTO.getOrderNo(),storageDTO.toString());
  }

  /**
   * 补偿扣减库存
   * @param storageDTO
   */
  @PostMapping(value = "/compensatereduce",consumes = MediaType.APPLICATION_JSON_VALUE)
  public void compensateReduce(StorageDTO storageDTO){
    log.info("补偿扣减库存，订单号:{}",storageDTO.getOrderNo());
  }

}
