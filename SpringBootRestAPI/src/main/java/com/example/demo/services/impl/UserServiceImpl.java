package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.item.DuplicateRecordException;
import com.example.demo.exception.item.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.request.CreateUserReq;
import com.example.demo.request.UpdateUserReq;
import com.example.demo.services.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    private static ArrayList<User> users = new ArrayList<>();
    static {
//        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com","0987654321","avatar.img","123"));
//        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com","0123456789","avatar1.img","123"));
//        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com","0987564664","avatar3.img","123"));
//        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com","0874845455","avatar9.img","123"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> tmp = new ArrayList<>();
        for(User user : users){
            tmp.add(UserMapper.toUserDto(user));
        }
        return tmp;
    }

    @Override
    public UserDto getUserById(Long id) {
        for(User user : users){
            if(user.getId()==id)
                return UserMapper.toUserDto(user);
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public List<UserDto> searchUserByName(String name) {
        List<UserDto> tmp = new ArrayList<>();
        for(User user : users){
            if(user.getName().contains(name))
                tmp.add(UserMapper.toUserDto(user));
        }
        return tmp;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        for(User user: users){
            if(user.getEmail().equals(req.getEmail())){
                throw new DuplicateRecordException("Email is duplicate");
            }
        }

        User user = new User();
        user.setId(users.size()+1);
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        //Ma hoa password
        user.setPassword(BCrypt.hashpw(req.getPassword(),BCrypt.gensalt(12)));
        users.add(user);

        return UserMapper.toUserDto(user);
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
        for(User user: users){
            if(user.getId() == id){
                this.isCheckDuplicateEmailUser(userReq.getEmail(), users);
                user.setName(userReq.getName());
                user.setEmail(userReq.getEmail());
                user.setPassword(userReq.getPassword());
                user.setPhone(userReq.getPhone());
                user.setAvatar(userReq.getAvatar());
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("Not found UserId: " + id);
    }

    @Override
    public boolean deleteUser(Long id) {
        for(User user: users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        throw new NotFoundException("Not found User");
    }


}
