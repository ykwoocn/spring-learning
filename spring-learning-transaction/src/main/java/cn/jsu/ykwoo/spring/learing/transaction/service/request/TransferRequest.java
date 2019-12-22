package cn.jsu.ykwoo.spring.learing.transaction.service.request;

import lombok.Data;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/22 21:39
 */
@Data
public class TransferRequest {

  private String fromAcctNo;
  private String toAcctNo;
  private Long money;
}
