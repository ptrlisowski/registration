package pl.sda.nordea.registration.repository;

import org.springframework.data.repository.CrudRepository;

import pl.sda.nordea.registration.entity.UserRoles;

public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {

}
