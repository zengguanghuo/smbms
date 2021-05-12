package com.smbms.controller;

import com.smbms.Service.ProviderService;
import com.smbms.Service.RoleService;
import com.smbms.eneity.Provider;
import com.smbms.eneity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    ProviderService providerService;

    //查询
    @RequestMapping("/provider.do")
    public String se(Model model){
        List<Provider> providers = providerService.select();
        model.addAttribute("providers",providers);
        return "providerlist";
    }

    //添加
    @RequestMapping("/proadd.do")
    public  String ad(HttpServletRequest request, Model model){
        String proCode = request.getParameter("proCode");
        String proName = request.getParameter("proName");
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");
        Date creationDate=new Date();
        System.out.println(proName);
        int add = providerService.add(new Provider(proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,creationDate));
        System.out.println(add);
        if(add>0){
            return "redirect:provider.do";
        }
 return null;
    }

    //根据id查询
@RequestMapping("/abc.do")
    public String getbyid(Integer id,Model model){
    System.out.println(id);
    Provider getbyid = providerService.getbyid(id);
    model.addAttribute("der",getbyid);
        return "Provider/get3";
    }

    //删除
    @RequestMapping("/dl.do")
    public String dl(Integer id){
        System.out.println(id);
        providerService.delect(id);
        return "redirect:prose.do";
    }



    //转到添加页面
    @RequestMapping("/proddd.do")
    public String tj(){

        return "provideradd";
    }

    //模糊查询
    @RequestMapping("prose.do")
    public String mohu(Model model,String queryProCode,String queryProName){
        List<Provider> mohu = providerService.mohu(queryProCode, queryProName);
        model.addAttribute("providers",mohu);
        model.addAttribute("queryProCode",queryProCode);
        model.addAttribute("queryProName",queryProName);
        return "providerlist";
    }

    //查看供应商
    @RequestMapping("lookpr.do")
    public String lookpro(Model model,Integer lid){
        Provider provider = providerService.getbyid(lid);
        model.addAttribute("provider",provider);
        return "providerview";
    }

//    //删除供应商
  @RequestMapping("prdele.do")
  @ResponseBody()
    public String dele(Integer id){
      int i = providerService.delect(id);
      if(i>0){
          return "true";
      }else {
          return "false";
      }
  }
}
