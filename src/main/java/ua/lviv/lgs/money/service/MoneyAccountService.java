package ua.lviv.lgs.money.service;

import ua.lviv.lgs.money.domain.MoneyAccount;

public interface MoneyAccountService {

    MoneyAccount create(Long userId, MoneyAccount moneyAccount);

}
