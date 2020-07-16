package com.alexbro.onlinebank.facade.account;

import com.alexbro.onlinebank.facade.data.account.AccountData;
import com.alexbro.onlinebank.facade.data.exchange.ExchangeData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountFacade {

    void transfer(String accountCode, Long cardNumber, BigDecimal sum);

    List<AccountData> findAllByCurrency(String currencyCode);

    Optional<AccountData> findByCode(String code);

    Optional<AccountData> findByCardNumber(Long cardNumber);

    ExchangeData getExchangeData(AccountData accountFrom, AccountData accountTo, BigDecimal sum);

    void exchange(String accountFromCode, String accountToCode, BigDecimal sum);

}
