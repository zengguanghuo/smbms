package com.smbms.Service;

import com.smbms.eneity.User;
import com.smbms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService{
@Autowired
    UserMapper userMapper;
    @Override
    public List<User> select() {
        return userMapper.select();
    }

    @Override
    public User seuser(String userCode, String userPassword) {
        return userMapper.seuser(userCode,userPassword);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User getUserCode(String userCode) {
        return userMapper.getUserCode(userCode);
    }

    @Override
    public List<User> mohuser(String userName, Integer userRole) {
        return userMapper.mohuser(userName,userRole);
    }

    @Override
    public int updateuser(String userPassword, Integer id) {
        return userMapper.updateuser(userPassword,id);
    }

    @Override
    public User getbyid(Integer id) {
        return userMapper.getbyid(id);
    }

    @Override
    public int userUpate(User user) {
        return userMapper.userUpate(user);
    }
}
