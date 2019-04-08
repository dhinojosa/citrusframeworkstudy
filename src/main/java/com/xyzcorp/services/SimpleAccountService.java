package com.xyzcorp.services;

import com.xyzcorp.dao.AccountDAO;
import com.xyzcorp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleAccountService implements AccountService {

    private final AccountDAO accountDAO;
    private final JavaMailSender javaMailSender;

    @Autowired
    public SimpleAccountService(AccountDAO accountDAO, JavaMailSender javaMailSender) {
        this.accountDAO = accountDAO;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountDAO.findById(id);
    }

    public void create(Account account) {
        accountDAO.create(account);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("dhinojosa@evolutionnext.com");
        message.setSubject("Welcome");
        message.setText("Welcome to our test app");

        javaMailSender.send(message);
    }
}
