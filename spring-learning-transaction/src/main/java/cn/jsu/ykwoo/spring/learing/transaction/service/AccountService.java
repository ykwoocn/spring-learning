package cn.jsu.ykwoo.spring.learing.transaction.service;

import cn.jsu.ykwoo.spring.learing.transaction.service.request.TransferRequest;
import cn.jsu.ykwoo.spring.learing.transaction.service.result.TransferResult;

/**
 * @author ykwoo
 * @version 1.0
 * @date 2019/12/22 21:37
 */
public interface AccountService {

   TransferResult transfer(TransferRequest transferRequest);
}
