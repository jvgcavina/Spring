package com.jvgcavina.RestfulAPINoDatabase.services;

import com.jvgcavina.RestfulAPINoDatabase.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private static final List<User> users = new ArrayList<User>();
    private static Long sequence = 1L;

    static {
        users.add(new User(sequence++, "Cavina"));
        users.add(new User(sequence++, "Caliani"));
    }

    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    public User findById(Long id) {
        for (User user : users) {
            if (user.getId() == (id)) {
                return user;
            }
        }

        return null;
    }

    public User create(User user) {
        user.setId(sequence++);
        users.add(user);

        return user;
    }

    public void update(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                users.set(users.indexOf(u), user);
            }
        }
    }

    public void deleteById(Long id) {
        User user = null;

        for (User u : users) {
            if (u.getId() == id) {
                user = u;
                break;
            }
        }

        if (null != user) {
            users.remove(user);
        }
    }
}