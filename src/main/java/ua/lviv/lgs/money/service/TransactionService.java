package ua.lviv.lgs.money.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.domain.enumeration.Type;
import ua.lviv.lgs.money.service.dto.TransactionDTO;

public interface TransactionService {

    TransactionDTO create(Long userId, TransactionDTO transaction);

    Transaction update(Transaction transaction);

    void deleteById(Long id);

    Page<Transaction> findByAccountId(Long accountId, Type type, Pageable pageable);

}
