package com.example.rentals.users;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Integer> {
    Users findUsersByUserNameAndPassword(String userName, String password);

}
