package ua.lviv.lgs.money.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.domain.VerificationToken;
import ua.lviv.lgs.money.repository.MoneyAccountRepository;
import ua.lviv.lgs.money.repository.RoleRepository;
import ua.lviv.lgs.money.repository.UserRepository;
import ua.lviv.lgs.money.repository.VerificationTokenRepository;
import ua.lviv.lgs.money.service.UserService;
import ua.lviv.lgs.money.service.exceptions.EntityNotFoundException;
import ua.lviv.lgs.money.service.exceptions.UserAlreadyExistException;
import ua.lviv.lgs.money.utils.SecurityUtils;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final MoneyAccountRepository moneyAccountRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final VerificationTokenRepository tokenRepository;

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


    @Override
    public void confirmRegistration(String token) {
        VerificationToken tokenPersisted = tokenRepository.findByToken(token);
        if (tokenPersisted != null && tokenIsValid(tokenPersisted)) {
            User user = tokenPersisted.getUser();
            user.setEnabled(true);
            userRepository.save(user);
        }

    }

    private boolean tokenIsValid(VerificationToken token) {
        return Duration.between(token.getExpiredDate(), Instant.now()).isNegative();
    }

    @Override
    public Long findCurrentUserId() {
        return userRepository.findByUsername(SecurityUtils.getCurrentUserName()).get().getId();
    }

    @Override
    public Long findUserCurrentAccountId() {
        return userRepository.findByUsername(SecurityUtils.getCurrentUserName()).get().getCurrentAccount().getId();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("" + id));
    }
}
