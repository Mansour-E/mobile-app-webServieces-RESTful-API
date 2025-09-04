package info.emami.mobileappws.ui.controller;

import info.emami.mobileappws.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {


    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page,
                           @RequestParam(value = "limit") int limit ){

        return "get user was called with  page = "  + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}")
    public UserRest getUser(@PathVariable String userId){

        UserRest result = new UserRest("Mansour", "Emami", "mansuurem@gmail.com", userId);
        return result;
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
