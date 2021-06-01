package com.nguyentc7.app.services;

import com.nguyentc7.app.model.dto.UserDto;
import com.nguyentc7.app.request.CreateUserReq;
import com.nguyentc7.app.request.UpdateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserService {
    public List<UserDto> getListUser();
    public UserDto getUserById(Long id);
    public List<UserDto> searchUserByName(String name);
    public UserDto createUser(CreateUserReq userReq);
    public UserDto updateUser(UpdateUserReq userReq, Long id);
    public boolean deleteUser(Long id);
}
