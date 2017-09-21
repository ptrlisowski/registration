package pl.sda.nordea.registration.repository;

import org.springframework.data.repository.CrudRepository;

import pl.sda.nordea.registration.entity.Users;

public interface UsersRepository extends CrudRepository<Users, String>{

}
