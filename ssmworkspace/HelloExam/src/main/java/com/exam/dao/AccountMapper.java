package com.exam.dao;

import com.exam.entity.Account;
import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(Account record);

    Account selectByPrimaryKey(String id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);
}