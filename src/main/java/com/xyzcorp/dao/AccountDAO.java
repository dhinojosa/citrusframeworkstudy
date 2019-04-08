package com.xyzcorp.dao;

import com.xyzcorp.models.Account;

import java.util.List;

public interface AccountDAO {
   public List<Account> findAll();

   public Account findById(long i);

   public Long create(Account account);
}
