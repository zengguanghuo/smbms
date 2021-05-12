package com.smbms.Service;

import com.smbms.eneity.Provider;
import com.smbms.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceimpl implements ProviderService{
@Autowired
    ProviderMapper providerMapper;
    @Override
    public List<Provider> select() {
        return providerMapper.select();
    }

    @Override
    public  Provider getbyid(Integer id) {
        return providerMapper.getbyid(id);
    }

    @Override
    public int add(Provider provider) {

        return providerMapper.add(provider);
    }

    @Override
    public int delect(Integer id) {
        return providerMapper.delect(id);
    }

    @Override
    public List<Provider> mohu(String proCode, String proName) {
        return providerMapper.mohu(proCode,proName);
    }
}
