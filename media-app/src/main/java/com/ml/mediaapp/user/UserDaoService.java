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
    private static int usersCount = 0; //This will auto increase the ids
    static{
        users.add(new User(++usersCount, "Abhishek", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Mokinder", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Bhavya", LocalDate.now().minusYears(34)));
        users.add(new User(++usersCount, "Praveen", LocalDate.now().minusYears(36)));
        users.add(new User(++usersCount, "Kushal", LocalDate.now().minusYears(32)));
        users.add(new User(++usersCount, "Aditya", LocalDate.now().minusYears(22)));
    }
    public List<User> findAll(){
        return users;
    }

    //public User save(User user) {

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

}
