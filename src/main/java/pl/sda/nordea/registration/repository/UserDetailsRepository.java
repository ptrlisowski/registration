package pl.sda.nordea.registration.repository;

import org.springframework.data.repository.CrudRepository;

import pl.sda.nordea.registration.entity.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, String>{

}
