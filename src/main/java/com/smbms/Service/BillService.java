package com.smbms.Service;

import com.smbms.eneity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> select(String productName,Integer providerId,Integer isPayment);

    List<Bill> getbise();

    Bill getbyID(Integer id);

    int delect(Integer id);

    //添加
    int add(Bill bill);

    //查询订单编码是否重复
    Bill getlCode(String billCode);


}
