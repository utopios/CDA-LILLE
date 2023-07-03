package com.example.demorest.controller;

import com.example.demorest.entity.User;
import com.example.demorest.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {


    @Autowired
  private UserService userService;



    @GetMapping("get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){

        if(!userService.getUserById(id).isPresent()){
            String message = "Utilisateur n'existe pas";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.ok(userService.getUserById(id).get());
    }




    @PostMapping("created")
    public ResponseEntity<String> post(@RequestBody User user){

        if(userService.getUserEmail(user.getEmail())){
            String errorMessage = "L'utilisateur existe déjà";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }

        if(user == null || user.getEmail() == null || user.getPassword() == null){
            String message = "Requete invalide : la mot de passe et l'email sont requis";
            return ResponseEntity.badRequest().body(message);

        }
        userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur créé avec succès");

    }

@GetMapping("/all")
    public ResponseEntity<?> getAllUser() {
    List<User> users = userService.getAllUser();
    String message = "La liste est vide";

    if (users.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
    } else {
        return ResponseEntity.ok(users);
    }

}


@PutMapping("put/{id}")
public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody User user){

    if(!userService.getUserById(id).isPresent()){
        String message = "Utilisateur n'existe pas";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    if(user == null || user.getEmail() == null || user.getPassword() == null){
        String message = "Requete invalide : la mot de passe et l'email sont requis";
        return ResponseEntity.badRequest().body(message);

    }
        userService.updateUser(id, user);
    String message = "L'utilisateur avec l'id : " + id + "est mis à jour";
    return ResponseEntity.ok(message);
}

@DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){

    if(!userService.getUserById(id).isPresent()){
        String message = "Utilisateur n'existe pas";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    userService.deleteUser(id);

    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/api/v1/all")).build();

}












}
