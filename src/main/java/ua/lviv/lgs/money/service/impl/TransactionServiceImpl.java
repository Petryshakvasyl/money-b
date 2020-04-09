package ua.lviv.lgs.money.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.money.domain.MoneyAccount;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.domain.enumeration.Type;
import ua.lviv.lgs.money.repository.MoneyAccountRepository;
import ua.lviv.lgs.money.repository.TransactionRepository;
import ua.lviv.lgs.money.repository.UserRepository;
import ua.lviv.lgs.money.service.TransactionService;
import ua.lviv.lgs.money.service.exceptions.EntityNotFoundException;

import javax.management.relation.RelationNotFoundException;
import javax.persistence.SecondaryTable;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final MoneyAccountRepository moneyAccountRepository;

    @Override
    @Transactional
    public Transaction create(Long userId, Transaction transaction) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("user with id " + userId + " was not found"));
        MoneyAccount currentMoneyAccount = user.getCurrentAccount();
        transactionRepository.save(transaction);
        currentMoneyAccount.getTransactions().add(transaction);
        moneyAccountRepository.save(currentMoneyAccount);
        return transaction;
    }

    @Override
    public Transaction update(Transaction transaction) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<Transaction> findByAccountId(Long accountId, Type type, Pageable pageable) {
        return transactionRepository.findByMoneyAccountIdAndType(accountId, type, pageable);
    }
}
