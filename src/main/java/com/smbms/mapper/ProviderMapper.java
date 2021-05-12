package com.smbms.mapper;

import com.smbms.eneity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {


    List<Provider> select();

     int add(Provider provider);

    Provider getbyid(Integer id);

    int delect(Integer id);

    //模糊查询

    List<Provider> mohu(@Param("proCode") String proCode, @Param("proName") String proName );

}
