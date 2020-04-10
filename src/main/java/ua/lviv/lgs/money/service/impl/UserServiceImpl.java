package ua.lviv.lgs.money.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.repository.MoneyAccountRepository;
import ua.lviv.lgs.money.repository.RoleRepository;
import ua.lviv.lgs.money.repository.UserRepository;
import ua.lviv.lgs.money.service.UserService;
import ua.lviv.lgs.money.service.exceptions.EntityNotFoundException;
import ua.lviv.lgs.money.service.exceptions.UserAlreadyExistException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final MoneyAccountRepository moneyAccountRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void setCurrentAccount(Long userId, MoneyAccount moneyAccount) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("user with id " + userId + " was not found"));

        MoneyAccount persistedMoneyAccount = moneyAccountRepository.findById(moneyAccount.getId()).orElseThrow(
                () -> new EntityNotFoundException("money account with id " + moneyAccount.getId() + " was not found"));
        user.setCurrentAccount(persistedMoneyAccount);
        userRepository.save(user);
    }

    @Override
    public void registerNewUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
}
