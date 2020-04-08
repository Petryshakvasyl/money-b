package ua.lviv.lgs.money.service;

import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.User;

public interface UserService {

    User create(User user);

    void setCurrentAccount(Long userId, MoneyAccount moneyAccount);

}
