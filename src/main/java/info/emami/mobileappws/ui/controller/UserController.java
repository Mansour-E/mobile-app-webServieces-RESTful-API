package info.emami.mobileappws.ui.controller;

import info.emami.mobileappws.ui.model.request.UserDetailsRequestModel;
import info.emami.mobileappws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {


    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page,
                           @RequestParam(value = "limit") int limit ){

        return "get user was called with  page = "  + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE,
                                                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        UserRest result = new UserRest("Mansour", "Emami", "mansuurem@gmail.com", userId);
        return new ResponseEntity<>(result,HttpStatus.BAD_GATEWAY);
    }

    @PostMapping(consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
    },
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE

    })
    public ResponseEntity<UserRest> creatUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest result = new UserRest();
        result.setEmail(userDetails.getEmail());
        result.setFirstName(userDetails.getFirstName());
        result.setLastName(userDetails.getLastName());
        result.setUserId(userDetails.getUserId());

        return new ResponseEntity<>(result, HttpStatus.OK) ;
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
