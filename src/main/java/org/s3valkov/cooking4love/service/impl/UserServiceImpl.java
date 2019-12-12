package org.s3valkov.cooking4love.service.impl;

import org.s3valkov.cooking4love.domain.models.service.UserServiceModel;
import org.s3valkov.cooking4love.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        return null;
    }

    @Override
    public UserServiceModel findUserByUserName(String username) {
        return null;
    }

    @Override
    public UserServiceModel findUserById(String id) {
        return null;
    }

    @Override
    public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
        return null;
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void makeAdmin(String id) {

    }

    @Override
    public void makeUser(String id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
