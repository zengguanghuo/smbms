package com.smbms.mapper;

import com.smbms.eneity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    List<Bill> select(@Param("productName") String productName,
                      @Param("providerId") Integer providerId,
                      @Param("isPayment") Integer isPayment);

    List<Bill> getbise();

    Bill getbyID(Integer id);

    int delect(Integer id);

    //添加
    int add(Bill bill);

    //查询订单编码是否重复
    Bill getlCode(String billCode);
}
