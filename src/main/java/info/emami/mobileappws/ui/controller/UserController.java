package info.emami.mobileappws.ui.controller;

import info.emami.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import info.emami.mobileappws.ui.model.request.UserDetailsRequestModel;
import info.emami.mobileappws.ui.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {


    Map<String, UserRest> users;


    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page,
                           @RequestParam(value = "limit") int limit ){

        return "get user was called with  page = "  + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE,
                                                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
    },
                produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE

    })
    public ResponseEntity<UserRest> creatUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest result = new UserRest();
        result.setEmail(userDetails.getEmail());
        result.setFirstName(userDetails.getFirstName());
        result.setLastName(userDetails.getLastName());
        result.setPassword(userDetails.getPassword());

        String userId = UUID.randomUUID().toString();
        result.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId , result);
        return new ResponseEntity<>(result, HttpStatus.OK) ;
    }

    @PutMapping(path = "/{userId}", consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE

            })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){

        users.remove(id);
        
        return ResponseEntity.noContent().build();

    }
}
