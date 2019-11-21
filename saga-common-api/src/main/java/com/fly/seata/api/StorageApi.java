package com.fly.seata.api;

import com.fly.seata.dto.StorageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: peijiepang
 * @date 2019-11-18
 * @Description:
 */
@FeignClient(name = "seata-sage-rm-two")
public interface StorageApi {

  @GetMapping("/rm2/test")
  String test();

  @PostMapping(value = "/storage/reduce",consumes = MediaType.APPLICATION_JSON_VALUE)
  void reduce(StorageDTO storageDTO);

  @PostMapping(value = "/storage/compensatereduce",consumes = MediaType.APPLICATION_JSON_VALUE)
  void compensateReduce(StorageDTO storageDTO);

}
