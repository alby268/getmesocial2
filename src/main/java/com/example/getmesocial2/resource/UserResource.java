package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }


    @GetMapping
    public List<User> getAllUser() {

        return userService.getAllUser();
    }


    @PutMapping
    public User updateUser(@RequestBody User user){

        return userService.updateUserById(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userId") String userId){

         userService.deleteUser(userId);
    }

    @GetMapping("/find")
    public List<User> getById(@RequestParam(name = "id") String id){

      return  userService.getById(id);

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
