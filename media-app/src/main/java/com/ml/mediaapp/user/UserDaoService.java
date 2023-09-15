package com.ml.mediaapp.user;

import com.ml.mediaapp.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // JPA / Hibernate > Database
    //UserDaoService > static List

    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User(1, "Abhishek", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Mokinder", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Bhavya", LocalDate.now().minusYears(34)));
        users.add(new User(4, "Praveen", LocalDate.now().minusYears(36)));
        users.add(new User(5, "Kushal", LocalDate.now().minusYears(32)));
        users.add(new User(6, "Aditya", LocalDate.now().minusYears(22)));
    }
    public List<User> findAll(){
        return users;
    }

    //public User save(User user) {

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

}
