package com.backauth.aplicacion;

import com.backauth.core.UserRepository;
import com.backauth.core.dominio.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceUser {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int userId)
    {
        return userRepository.getUser(userId);
    }

    public User save(User user)
    {
        return (User) userRepository.save(user);
    }

    public boolean delete(int userId)
    {
        return getUser(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
