package com.smbms.Service;

import com.smbms.eneity.Role;
import com.smbms.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceimpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> select() {
        return roleMapper.select();
    }
}
