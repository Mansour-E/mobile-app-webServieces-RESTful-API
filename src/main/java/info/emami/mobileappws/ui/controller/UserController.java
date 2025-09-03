package info.emami.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {


    @GetMapping
    public String getUser(){

        return "get user was called";
    }

    @PostMapping
    public String creatUser(){

        return "Creat user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
