package com.miu.cs.restfulweb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id) throws UserNotFoundException {
        User user = userService.findUser(id);
        if (user == null) throw new UserNotFoundException(id + " not found");
        return user;
    }

    // API implementation like this doesnt respond with 201, but 200
//    @PostMapping(path = "/users")
//    public User addUser(@RequestBody User user){
//        User newUser = userService.save(user);
//        return retrieveUser(newUser.getId());
//    }

    @PostMapping(path = "/users")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        User newUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
