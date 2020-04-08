package ua.lviv.lgs.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.money.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
