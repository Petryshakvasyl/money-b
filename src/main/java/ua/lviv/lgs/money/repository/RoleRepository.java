package ua.lviv.lgs.money.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.money.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
