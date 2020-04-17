package ua.lviv.lgs.money.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.domain.enumeration.Type;
import ua.lviv.lgs.money.repository.MoneyAccountRepository;
import ua.lviv.lgs.money.repository.TransactionRepository;
import ua.lviv.lgs.money.repository.UserRepository;
import ua.lviv.lgs.money.service.TransactionService;
import ua.lviv.lgs.money.service.dto.TransactionDTO;
import ua.lviv.lgs.money.service.mapper.TransactionMapper;

@Service
@Profile("test")
public class TransactionTestServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

    private final MoneyAccountRepository moneyAccountRepository;

    private final TransactionMapper transactionMapper;

    public TransactionTestServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository, MoneyAccountRepository moneyAccountRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.moneyAccountRepository = moneyAccountRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public TransactionDTO create(Long userId, TransactionDTO transactionDTO) {
        return new TransactionDTO();
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
