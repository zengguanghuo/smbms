package com.smbms.Service;

import com.smbms.eneity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<User> select();
    User seuser(String userCode, String userPassword);
    int update(User user);

    int add(User user);

    User getUserCode(String userCode);

    List<User> mohuser(String userName,Integer userRole);

    int updateuser(String userPassword,Integer id );

    User getbyid(Integer id);

    int userUpate(User user);
}
