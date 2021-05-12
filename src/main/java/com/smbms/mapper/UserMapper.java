package com.smbms.mapper;

import com.smbms.eneity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> select();
    User seuser(@Param("names") String userCode,@Param("pwd") String userPassword);
    int update(User user);

    int add(User user);

    User getUserCode(String userCode);

   List<User> mohuser(@Param("userName") String userName,@Param("userRole") Integer userRole);

   int updateuser(@Param("userPassword") String userPassword,@Param("id") Integer id );

   User getbyid(@Param("uid") Integer id);

   int userUpate(User user);
}
