package com.smbms.Service;

import com.smbms.eneity.Bill;
import com.smbms.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillServiceimpl implements BillService{
@Autowired
    BillMapper billMapper;

    @Override
    public List<Bill> select(String productName, Integer providerId, Integer isPayment) {
        return billMapper.select(productName,providerId,isPayment);
    }

    @Override
    public List<Bill> getbise() {
        return billMapper.getbise();
    }

    @Override
    public Bill getbyID(Integer id) {
        return billMapper.getbyID(id);
    }

    @Override
    public int delect(Integer id) {
        return billMapper.delect(id);
    }

    @Override
    public int add(Bill bill) {
        return billMapper.add(bill);
    }

    @Override
    public Bill getlCode(String billCode) {
        return billMapper.getlCode(billCode);
    }

}
