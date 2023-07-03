package com.osiki.simpleFormWithMvc.service;

import com.osiki.simpleFormWithMvc.model.UserModel;
import com.osiki.simpleFormWithMvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserModel registerUser(String login, String password, String email){

        if (login == null || password == null) {
            return null;
        } else {
            UserModel userModel = new UserModel();

            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);

            return userRepository.save(userModel);
        }

    }

    public UserModel authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login, password).orElse(null);

    }
}
