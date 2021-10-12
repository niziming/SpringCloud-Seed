package cn.zm.plus.web.service.impl;

import cn.zm.plus.web.entity.Account;
import cn.zm.plus.web.mapper.AccountMapper;
import cn.zm.plus.web.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.zm.plus.web.entity.dto.AccountDTO;
import cn.zm.plus.web.entity.vo.AccountVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.zm.plus.utils.ConvertUtil;


@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Override
    public IPage<AccountVO> selectByPage(IPage<Account> page, AccountDTO account) {
        IPage<Account> accountPage = baseMapper.selectPage(page, new QueryWrapper<>());
        return ConvertUtil.buildPage(accountPage);
    }
}
