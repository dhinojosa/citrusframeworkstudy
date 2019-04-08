package com.xyzcorp.services;

import com.xyzcorp.models.Account;

import java.util.List;

public interface AccountService {
   public List<Account> findAll();
   public Account findById(Long id);
}
