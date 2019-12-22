package cn.jsu.ykwoo.spring.learing.transaction.dataobj;

import java.util.Date;
import lombok.Data;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/22 21:14
 */
@Data
public class AccountDO {
  private Long id;
  private Date createdTime;
  private Date updatedTime;
  private String    acctNo;
  private String    userId;
  private Integer   type;
  private Long availableBalance;
  private Long unAvailableBalance;
  private Boolean acctAvailable;
}
