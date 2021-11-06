package com.example.getmesocial2.repository;

import com.example.getmesocial2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList();

    public User getUser() {

        User user = new User("albin","blueberry",26,"");
        return user;
    }

    public User saveUser(User user) {

        user.setUserId(userList.size()+1);

        userList.add(user);
        return user;

    }

    public List<User> getAllUser() {
        return userList;
    }

    public User getUserById(int userId) {
        for(User user:userList) {

            if(user.getUserId() == userId) {
                return user;
            }
        }

        return null;


    }

    public User updateUserById(int userId, User user) {

        for(User user1:userList) {

            if(user1.getUserId() == userId) {

                user1.setAddress(user.getAddress());
                user1.setName(user.getName());
                user1.setAge(user.getAge());
                return user1;
            }
        }

        return null;


    }

    public User deleteUser(int userId) {

        User deletedUser = null;
        for(User user1:userList) {

            if(user1.getUserId() == userId) {
                deletedUser = user1;
                userList.remove(user1);
                return deletedUser;
            }
        }

        return null;
    }
}
