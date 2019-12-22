package cn.jsu.ykwoo.spring.learing.transaction.service.impl;

import cn.jsu.ykwoo.spring.learing.transaction.dataobj.AccountDO;
import cn.jsu.ykwoo.spring.learing.transaction.mappers.AccountInfoDAO;
import cn.jsu.ykwoo.spring.learing.transaction.service.AccountService;
import cn.jsu.ykwoo.spring.learing.transaction.service.request.TransferRequest;
import cn.jsu.ykwoo.spring.learing.transaction.service.result.TransferResult;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/22 21:42
 */
@Component
public class AccountServiceImpl implements AccountService {

  @Resource
  AccountInfoDAO accountInfoDAO;
  @Override
  @Transactional
  public TransferResult transfer(TransferRequest transferRequest) {
    if(!validation(transferRequest)){
      return TransferResult.buildError("illegal params!");
    }
    //只锁出钱账户
    AccountDO fromAccount = accountInfoDAO.queryByAcctNoLock(transferRequest.getFromAcctNo());
    if (fromAccount.getAvailableBalance()-transferRequest.getMoney() < 0){
      return TransferResult.buildError("Sorry,Your account balance is insufficient!");
    }

    AccountDO toAccount = accountInfoDAO.queryByAcctNo(transferRequest.getToAcctNo());

    accountInfoDAO.updateAccountMoney(fromAccount.getAcctNo(),0-transferRequest.getMoney());
    accountInfoDAO.updateAccountMoney(toAccount.getAcctNo(),transferRequest.getMoney());
    fromAccount.setAvailableBalance(fromAccount.getAvailableBalance() - transferRequest.getMoney());
    toAccount.setAvailableBalance(toAccount.getAvailableBalance() + transferRequest.getMoney());
    return  TransferResult.buildSuccess(fromAccount,toAccount);
  }

  private boolean validation(TransferRequest transferRequest) {
    return StringUtils.isNoneBlank(transferRequest.getFromAcctNo())
        && StringUtils.isNoneBlank(transferRequest.getToAcctNo())
        && null != transferRequest.getMoney();
  }
}
