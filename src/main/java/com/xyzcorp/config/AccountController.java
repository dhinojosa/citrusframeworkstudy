package com.xyzcorp.config;

import com.xyzcorp.models.Account;
import com.xyzcorp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/myservice")
class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> findAll() {
        return List.of(new Account("Clampett", "Clemens", UUID.randomUUID(), LocalDate.now()));
    }

    @GetMapping(value = "/{id}")
    public Account findById(@PathVariable("id") Long id) {
        return new Account("Bob", "Clown", UUID.randomUUID(), LocalDate.now());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Account account) {
        return 12L;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id,
                       @RequestBody Account resource) {

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {

    }

}