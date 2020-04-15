package ua.lviv.lgs.money.service;

import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.User;

public interface UserService {

    User save(User user);

    void setCurrentAccount(Long userId, MoneyAccount moneyAccount);

    void registerNewUser(User user);

    void confirmRegistration(String token);

    Long findCurrentUserId();

    Long findUserCurrentAccountId();

    User findById(Long id);
}
