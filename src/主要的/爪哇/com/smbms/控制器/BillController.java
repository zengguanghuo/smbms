package com.smbms.controller;

import com.smbms.Service.BillService;
import com.smbms.Service.ProviderService;
import com.smbms.eneity.Bill;
import com.smbms.eneity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Controller
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    ProviderService providerService;
    //模糊查询
    @RequestMapping("bill.do")
    public String se(Model model,String queryProductName,Integer queryProviderId,Integer queryIsPayment){
        List<Bill> select = billService.select(queryProductName,queryProviderId,queryIsPayment);
        model.addAttribute("billList",select);
        System.out.println(queryProviderId);
        model.addAttribute("queryProductName",queryProductName);
        model.addAttribute("queryProviderId",queryProviderId);
        model.addAttribute("queryIsPayment",queryIsPayment);

        return "billlist";
    }
    //查询
    @RequestMapping("billse.do")
    public String sa(Model model, HttpSession session){
        List<Provider> providerList = providerService.select();
        List<Bill> getbise = billService.getbise();
        model.addAttribute("billList",getbise);
        session.setAttribute("providerList",providerList);
        return "billlist";
    }

    //模糊查询666
    @RequestMapping("billvi.do")
    public String ck(Model model,Integer bid){
        System.out.println(bid);
        Bill bill = billService.getbyID(bid);
        model.addAttribute("bill",bill);
        return "billview";
    }

    //删除订单
    @RequestMapping("dele.do")
    @ResponseBody()
    public  String de(Integer id){
        System.out.println(id);
        int delect = billService.delect(id);
        System.out.println(delect);
        if(delect>0){
            return "true";
        }else {
            return "false";
        }
    }



    //转发添加订单
    @RequestMapping("bia.do")
    public String bia(HttpSession session){

        List<Provider> providerList = providerService.select();
        session.setAttribute("providerList",providerList);
        return "billadd";
    }
    //检测用户编码是否重复
@RequestMapping("setcode.do")
    @ResponseBody()
    public String getbillCode(HttpServletRequest request){
        String billCode = request.getParameter("billCode");
    Bill bill = billService.getlCode(billCode);
    if(bill==null){
            return "true";
        }else{
            return "false";
        }

    }

//    //添加订单
    @RequestMapping("billtj.do")
@ResponseBody()
    public String add(Bill bill){
       bill.setCreationDate(new Date());
        int count = billService.add(bill);
        System.out.println("订单添加"+count);
         if(count>0){
             return "true";
         }else {
             return "false";
         }
    }
}
