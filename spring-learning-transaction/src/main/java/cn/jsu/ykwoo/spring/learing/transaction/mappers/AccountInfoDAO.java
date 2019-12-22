package cn.jsu.ykwoo.spring.learing.transaction.mappers;

import cn.jsu.ykwoo.spring.learing.transaction.dataobj.AccountDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/22 21:17
 */
public interface AccountInfoDAO {

  AccountDO queryById(@Param("id") Long id);
  AccountDO queryByAcctNo(@Param("acctNo") String acctNo);
  AccountDO queryByAcctNoLock(@Param("acctNo") String acctNo);

  int updateAccountMoney(@Param("acctNo") String acctNo,@Param("money") Long money);
  List<AccountDO> queryAll();
}
