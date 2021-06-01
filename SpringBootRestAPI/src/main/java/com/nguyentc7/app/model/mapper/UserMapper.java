package com.nguyentc7.app.model.mapper;

import com.nguyentc7.app.entity.User;
import com.nguyentc7.app.model.dto.UserDto;

public class UserMapper
{
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        tmp.setEmail(user.getEmail());
        return tmp;
    }
}
