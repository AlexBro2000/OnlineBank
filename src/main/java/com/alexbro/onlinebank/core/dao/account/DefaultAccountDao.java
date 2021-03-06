package com.alexbro.onlinebank.core.dao.account;

import com.alexbro.onlinebank.core.dao.util.SessionProvider;
import com.alexbro.onlinebank.core.entity.Account;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultAccountDao implements AccountDao {

    private static final String GET_ACCOUNT_BY_CODE_QUERY = "SELECT a FROM Account a WHERE a.code = :code";
    private static final String GET_ACCOUNT_BY_CARD_NUMBER_QUERY = "SELECT a FROM Account a WHERE a.cardNumber = :cardNumber";
    private static final String FIND_ALL_BY_CURRENCY_QUERY = "SELECT a FROM Account a INNER JOIN a.currency c WHERE c.code =:currencyCode";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public Optional<Account> findByCode(String code) {
        return sessionProvider.getSession().createQuery(GET_ACCOUNT_BY_CODE_QUERY, Account.class).setParameter("code", code).
                uniqueResultOptional();
    }

    @Override
    public Optional<Account> findByCardNumber(Long cardNumber) {
        return sessionProvider.getSession().createQuery(GET_ACCOUNT_BY_CARD_NUMBER_QUERY, Account.class).
                setParameter("cardNumber", cardNumber).
                uniqueResultOptional();
    }

    @Override
    public void update(Account account) {
        sessionProvider.getSession().update(account);
    }

    @Override
    public List<Account> findAllByCurrency(String currencyCode) {
        return sessionProvider.getSession().createQuery(FIND_ALL_BY_CURRENCY_QUERY, Account.class).
                setParameter("currencyCode", currencyCode).list();
    }
}
