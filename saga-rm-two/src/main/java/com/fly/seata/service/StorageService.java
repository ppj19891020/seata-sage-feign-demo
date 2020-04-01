package com.fly.seata.service;

import com.fly.seata.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: peijiepang
 * @date 2019-11-20
 * @Description:
 */
@Slf4j
@Service("storageService")
public class StorageService {

  @Autowired
  private StorageDao storageDao;

  /**
   * 扣减库存
   * @return
   */
  public String reduceStorage(Long productId,Integer count){
    log.info("reductStorage productId:{} count:{}",productId,count);
    storageDao.reduce(productId,count);
    return "ok";
  }

  /**
   * 回滚扣减库存
   * @return
   */
  public String rollbackReduceStorage(Long prodectId,Integer count){
    log.info("rollbackreducestorage productId:{} count:{}",prodectId,count);
    storageDao.rollback(prodectId,count);
    return "ok";
  }

}
