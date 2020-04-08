package ua.lviv.lgs.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.money.domain.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
