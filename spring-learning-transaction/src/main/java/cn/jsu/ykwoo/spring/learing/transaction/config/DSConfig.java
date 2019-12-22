package cn.jsu.ykwoo.spring.learing.transaction.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/19 23:51
 */
@Configuration
@MapperScan("cn.jsu.ykwoo.spring.learing.transaction.mappers")
public class DSConfig {

  @Bean
  DruidDataSource dataSource(){
    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:create.sql'");
    dataSource.setUsername("");
    dataSource.setPassword("");
    return dataSource;
  }

  @Bean
  SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean datasourceFactory = new SqlSessionFactoryBean();
    datasourceFactory.setDataSource(dataSource());
    datasourceFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*.xml"));
    datasourceFactory.setTypeAliasesPackage("cn.jsu.ykwoo.spring.learing.transaction.dataobj");
    return datasourceFactory.getObject();
  }

  @Bean
  PlatformTransactionManager platformTransactionManager(){
    return new DataSourceTransactionManager(dataSource());
  }

}
