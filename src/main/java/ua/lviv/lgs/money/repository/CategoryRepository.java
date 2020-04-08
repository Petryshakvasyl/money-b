package ua.lviv.lgs.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.money.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
