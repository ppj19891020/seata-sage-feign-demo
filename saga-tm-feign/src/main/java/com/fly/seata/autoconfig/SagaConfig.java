package com.fly.seata.autoconfig;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.engine.config.DbStateMachineConfig;
import io.seata.saga.engine.impl.ProcessCtrlStateMachineEngine;
import io.seata.saga.rm.StateMachineEngineHolder;
import java.util.concurrent.ThreadPoolExecutor;
import javax.sql.DataSource;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

/**
 * @author: peijiepang
 * @date 2019-11-18
 * @Description:
 */
@Configuration
public class SagaConfig {

  @ConfigurationProperties("spring.datasource.saga")
  @Bean
  public DataSource dataSource(){
    return new DruidDataSource();
  }

  @Bean
  public DbStateMachineConfig dbStateMachineConfig(){
    DbStateMachineConfig dbStateMachineConfig = new DbStateMachineConfig();
    dbStateMachineConfig.setDataSource(dataSource());
    Resource[] resources = {new ClassPathResource("statelang/purchase.json")};
    dbStateMachineConfig.setResources(resources);
    dbStateMachineConfig.setEnableAsync(true);
    dbStateMachineConfig.setThreadPoolExecutor(threadPoolExecutor());
    dbStateMachineConfig.setApplicationId("sage-tm");
    dbStateMachineConfig.setTxServiceGroup("my_test_tx_group");
    return dbStateMachineConfig;
  }

  /**
   * saga状态图执行引擎
   * @return
   */
  @Bean
  public StateMachineEngine processCtrlStateMachineEngine(){
    ProcessCtrlStateMachineEngine stateMachineEngine = new ProcessCtrlStateMachineEngine();
    stateMachineEngine.setStateMachineConfig(dbStateMachineConfig());
    return stateMachineEngine;
  }

  @Bean
  public StateMachineEngineHolder stateMachineEngineHolder(){
    StateMachineEngineHolder stateMachineEngineHolder = new StateMachineEngineHolder();
    stateMachineEngineHolder.setStateMachineEngine(processCtrlStateMachineEngine());
    return stateMachineEngineHolder;
  }

  @Bean
  public ThreadPoolExecutor threadPoolExecutor(){
    ThreadPoolExecutorFactoryBean threadPoolExecutorFactoryBean = new ThreadPoolExecutorFactoryBean();
    threadPoolExecutorFactoryBean.setCorePoolSize(1);
    threadPoolExecutorFactoryBean.setMaxPoolSize(20);
    threadPoolExecutorFactoryBean.setThreadNamePrefix("saga_");
    return (ThreadPoolExecutor)threadPoolExecutorFactoryBean.getObject();
  }

}
