package com.example.getmesocial2.resource;

import com.example.getmesocial2.exception.RestrictedInfoException;
import com.example.getmesocial2.exception.RestrictedNameException;
import com.example.getmesocial2.model.FirebaseUser;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.FirebaseService;
import com.example.getmesocial2.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user,@RequestHeader(name="idToken") String idToken) throws RestrictedNameException, IOException, FirebaseAuthException {
        if(user.getName().equalsIgnoreCase("root")){
            throw new RestrictedNameException();
        }

        else {

            FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
            if(firebaseUser!=null){
                return userService.saveUser(user);

            }
            else
                return null;


        }
        }



    @GetMapping
    public List<User> getAllUser() {

        return userService.getAllUser();
    }


    @PutMapping
    public User updateUser(@RequestBody User user,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return userService.updateUserById(user);

        }
        else
            return null;
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userId") String userId,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException  {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser!=null){
            userService.deleteUser(userId);

        }

    }


    @GetMapping("/find")
    public User getById(@RequestParam(name = "id") String id) throws RestrictedInfoException {
        if(id.equalsIgnoreCase("abc")){
            throw new RestrictedInfoException();
        }
        return userService.getById(id);

    }





//    @GetMapping("/user")
//    public User getUser() {
//
//       return userService.getUser();
//    }
//
//
//
//
//    @GetMapping("/allUsers")
//    public List<User> getAllUser() {
//
//        return userService.getAllUser();
//    }
//
//    @GetMapping("/user/{userId}")
//    public User getUserById(@PathVariable("userId") int userId){
//
//        return userService.getUserById(userId);
//    }
//
//
//    @PutMapping("/user1/{userId}")
//    public User updateUser(@PathVariable("userId") int userId,@RequestBody User user){
//
//        return userService.updateUserById(userId,user);
//    }
//
//
//    @DeleteMapping("/user2")
//    public User deleteUser(@RequestParam(name = "userId") int userId){
//
//        return userService.deleteUser(userId);
//    }
//




}
