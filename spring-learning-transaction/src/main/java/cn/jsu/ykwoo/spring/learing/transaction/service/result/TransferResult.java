package cn.jsu.ykwoo.spring.learing.transaction.service.result;

import cn.jsu.ykwoo.spring.learing.transaction.dataobj.AccountDO;
import lombok.Data;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/22 21:40
 */
@Data
public class TransferResult {

  private boolean success;
  private String code;
  private String msg;
  private AccountDO fromAccountDO;
  private AccountDO toAccountDO;


  public static TransferResult buildError(String msg){
    TransferResult transferResult = new TransferResult();
    transferResult.setCode("500");
    transferResult.setMsg(msg);
    transferResult.setSuccess(false);
    return transferResult;
  }
  public static TransferResult buildSuccess(AccountDO fromAccountDO,AccountDO toAccountDO){
    TransferResult transferResult = new TransferResult();
    transferResult.setCode("200");
    transferResult.setMsg("");
    transferResult.setSuccess(true);
    transferResult.setFromAccountDO(fromAccountDO);
    transferResult.setToAccountDO(toAccountDO);
    return transferResult;
  }
}
