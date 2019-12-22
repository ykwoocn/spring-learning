package cn.jsu.ykwoo.spring.learing.transaction;

import cn.jsu.ykwoo.spring.learing.transaction.mappers.AccountInfoDAO;
import cn.jsu.ykwoo.spring.learing.transaction.service.AccountService;
import cn.jsu.ykwoo.spring.learing.transaction.service.request.TransferRequest;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.fastjson.JSONObject;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/19 23:45
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@RestController
public class App {

  @Resource
  AccountService accountService;
  @Resource
  AccountInfoDAO accountInfoDAO;
  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

  @RequestMapping("/")
  public String testQuery(){
    return JSONObject.toJSONString(accountInfoDAO.queryAll());
  }

  @RequestMapping("/transfer/{fromAccount}/{toAccount}/{money}")
  public String transafer(@PathVariable String money, @PathVariable String toAccount, @PathVariable String fromAccount){
    TransferRequest transferRequest = new TransferRequest();
    transferRequest.setFromAcctNo(fromAccount);
    transferRequest.setToAcctNo(toAccount);
    transferRequest.setMoney(Long.valueOf(money));
    return JSONObject.toJSONString(accountService.transfer(transferRequest));
  }
}
