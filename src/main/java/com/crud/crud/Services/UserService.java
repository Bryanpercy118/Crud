package com.crud.crud.Services;

import com.crud.crud.Models.UserModel;
import com.crud.crud.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    IUserRepository userRepository;
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getId(Long id){
        return userRepository.findById(id);
    }
    public UserModel updateUser(UserModel request,Long id){
        UserModel user = userRepository.findById(id).get();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        return user;
    }
    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
