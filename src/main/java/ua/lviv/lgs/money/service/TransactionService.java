package ua.lviv.lgs.money.service;

import org.springframework.data.domain.Page;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.domain.enumeration.Type;

public interface TransactionService {

    Transaction create(Long userId, Transaction transaction);

    Transaction update(Transaction transaction);

    void deleteById(Long id);

    Page<Transaction> findByAccountId(Long accountId, Type type);

}
