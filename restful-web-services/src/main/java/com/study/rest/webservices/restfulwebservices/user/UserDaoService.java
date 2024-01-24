package com.study.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {


    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount,"Mireya", LocalDate.now().minusYears(1)));
        users.add(new User(++usersCount,"Shweta", LocalDate.now().minusYears(1)));
        users.add(new User(++usersCount,"AnupKs", LocalDate.now().minusYears(1)));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserDaoService.users = users;
    }

    public List<User> findAll() {
        return users;
    }

    public User find(int id) {
        for (int i=0; i < users.size(); i++) {
            if (id == users.get(i).getId())
                return users.get(i);
        }
        return null;
    }

    public User saveUser(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void delete(int id){
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                index = i;
                break;
            }
        }
        users.remove(index);

    }
}
