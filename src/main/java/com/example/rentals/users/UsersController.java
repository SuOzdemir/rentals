package com.example.rentals.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersController {

    private UsersRepository usersRepository;


    @GetMapping("/users/user")
    public Optional<Users> getUser(@PathVariable Integer id)
    {
        return usersRepository.findById ( id);
    }


    @GetMapping("/users/authanticate")
    public Users getAuthanticate(@PathVariable String userName, @PathVariable
            String  password)
    {
        return usersRepository.findUsersByUserNameAndPassword (userName,password);
    }

    @GetMapping("/users/users")
    public Iterable<Users> getUser()
    {
        return usersRepository.findAll ( );
    }

    @RequestMapping("/start")
    public String start()
    {
        return "start";
    }

    @PostMapping(path="/users/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Users> updateUser(@RequestBody Users newUser)
    {
        Users user=usersRepository.save ( newUser );
        return new ResponseEntity<> ( (user), HttpStatus.CREATED );
    }


}
