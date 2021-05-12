package com.smbms.Service;

import com.smbms.eneity.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> select();

    Provider getbyid(Integer id);

    int add(Provider provider);

    int delect(Integer id);

    List<Provider> mohu(String proCode,String proName );
}
