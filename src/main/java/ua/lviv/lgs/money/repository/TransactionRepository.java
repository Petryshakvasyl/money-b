package ua.lviv.lgs.money.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.money.domain.Transaction;
import ua.lviv.lgs.money.domain.enumeration.Type;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByMoneyAccountIdAndType(Long moneyAccountId, Type type, Pageable pageable);

}
