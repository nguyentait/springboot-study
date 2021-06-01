package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.item.DuplicateRecordException;
import com.example.demo.exception.item.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserReq;
import com.example.demo.request.UpdateUserReq;
import com.example.demo.services.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
//    private static ArrayList<User> users = new ArrayList<>();
    static {
//        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com","0987654321","avatar.img","123"));
//        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com","0123456789","avatar1.img","123"));
//        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com","0987564664","avatar3.img","123"));
//        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com","0874845455","avatar9.img","123"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> tmp = new ArrayList<>();
        for(User user : users){
            tmp.add(UserMapper.toUserDto(user));
        }
        return tmp;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user =
                userRepository.findById(id);

        if(user.isEmpty()){
            throw new NotFoundException("No user found");
        }
        return UserMapper.toUserDto(user.get());
    }

    @Override
    public List<UserDto> searchUserByName(String name) {
//        userRepository.findbyName();
//        List<UserDto> tmp = new ArrayList<>();
//        for(User user : users){
//            if(user.getName().contains(name))
//                tmp.add(UserMapper.toUserDto(user));
//        }
//        return tmp;
        return null;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        Optional<User> userTemp = userRepository.findByEmail(req.getEmail());
        if(userTemp.isEmpty()){
            User user = new User();
            user.setName(req.getName());
            user.setEmail(req.getEmail());
            user.setPhone(req.getPhone());
            //Ma hoa password
            user.setPassword(BCrypt.hashpw(req.getPassword(),BCrypt.gensalt(12)));
            userRepository.save(user);

            return UserMapper.toUserDto(user);
        }else{
            throw new DuplicateRecordException("Email is duplicate");
        }

    }
    public void isCheckDuplicateEmailUser(String email, List<User> users){
        for(User user: users){
            if(user.getEmail().equals(email)){
                throw new DuplicateRecordException("Email is duplicate");
            }
        }
    }
    @Override
    public UserDto updateUser(UpdateUserReq userReq, Long id) {
//        Optional<User>user = userRepository.findByEmail(userReq.getEmail());
        Optional<User>userUpdate = userRepository.findById(id);
        if(!userUpdate.isEmpty()){
            User u = userUpdate.get();
            u.setEmail(userReq.getEmail());
            u.setName(userReq.getName());
            u.setPhone(userReq.getPhone());
            u.setAvatar(userReq.getAvatar());
            userRepository.save(u);
            return UserMapper.toUserDto(u);
        }else {
            throw new NotFoundException("Not found UserId: " + id);
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isEmpty()){
            userRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException("Not found User");
    }
}
