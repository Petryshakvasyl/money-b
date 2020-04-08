package ua.lviv.lgs.money.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.repository.MoneyAccountRepository;
import ua.lviv.lgs.money.repository.UserRepository;
import ua.lviv.lgs.money.service.MoneyAccountService;
import ua.lviv.lgs.money.service.exceptions.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MoneyAccountServiceImpl implements MoneyAccountService {

    private final MoneyAccountRepository moneyAccountRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public MoneyAccount create(Long userId, MoneyAccount moneyAccount) {
        moneyAccountRepository.save(moneyAccount);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("user with id " + userId + " was not found"));
        user.getAccounts().add(moneyAccount);
        userRepository.save(user);
        return moneyAccount;
    }
}
