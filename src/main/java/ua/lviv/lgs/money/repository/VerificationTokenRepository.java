package ua.lviv.lgs.money.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.money.domain.VerificationToken;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

}
