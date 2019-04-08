package com.xyzcorp.dao;

import com.xyzcorp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class JDBCTemplateAccountDAO implements AccountDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCTemplateAccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM ACCOUNT",
                getAccountRowMapper());
    }

    private RowMapper<Account> getAccountRowMapper() {
        return (resultSet, i) -> accountToResultSet(resultSet);
    }

    @Override
    public Account findById(long i) {
        return jdbcTemplate.query("SELECT * from ACCOUNT as account where account.id = ?",
                this::accountToResultSet);
    }

    private Account accountToResultSet(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        Date registeredDate = resultSet.getDate("registeredDate");
        String uuidString = resultSet.getString("uuid");
        return new Account(firstName, lastName,
                UUID.fromString(uuidString),
                registeredDate.toLocalDate());
    }

    @Override
    public Long create(Account account) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->
                connection.prepareStatement(
                        "INSERT into ACCOUNT as account (firstName, lastName, registeredDate, uuid) values (?,?,?,?)"), keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }
}
