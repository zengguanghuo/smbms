package com.smbms.controller;

import com.smbms.Service.RoleService;
import com.smbms.Service.UserService;
import com.smbms.eneity.Role;
import com.smbms.eneity.User;
import com.smbms.uiti.Constains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping("/user.do")
    public String getlist(Model model,HttpSession session){
        List<User> list = userService.select();
        model.addAttribute("userList",list);
        List<Role> select = roleService.select();
        session.setAttribute("roleList",select);
        return "userlist";
    }

    @RequestMapping("/oop.do")
    public String requestbody(@RequestBody String body){
        System.out.println("执行了....");
        System.out.println(body);
        return "User/user-view";
    }
    @RequestMapping("/login.do")
    public String logiu(String userCode, String userPassword, HttpSession session){
        User seuser = userService.seuser(userCode, userPassword);
        session.setAttribute("suser",seuser);
        if(seuser==null){

            return "redirect:/login.jsp";
        }else{
            session.setAttribute(Constains.USER_SESSION,seuser);
            return "frame";
        }

    }

    @RequestMapping("aaa.do")
    public String zf(){
        return "pwdmodify";
    }


    @RequestMapping("userpwdModify.do")
    public String pwdModify(String password2,HttpSession session){
        User user=(User) session.getAttribute(Constains.USER_SESSION);
        user.setUserPassword(password2);
        int count=userService.update(user);
        if(count>0){
            return "login.jsp";
        }else{
            return "usermodify";
        }
    }

    //转发到添加页面
    @RequestMapping("adduser.do")
    public String dsede(Model model){
        List<Role> roles = roleService.select();
        model.addAttribute("roles",roles);
        return "useradd";
    }

@RequestMapping("usercode.do")
@ResponseBody()
    //用户编码是否存在
    public String getUserCode(HttpServletRequest request){
    String userCode = request.getParameter("userCode");
    User us = userService.getUserCode(userCode);
    System.out.println(us);
        if(us==null){
            return "true";
        }else{
            return "false";
        }
    }

//@RequestMapping("usead.do")
//    public  String ad(HttpServletRequest request,@RequestParam(value = "idPicPath_1",required = false) MultipartFile file) throws IOException {
//        //获取项目实际路径
//    String realPath = request.getServletContext().getRealPath("/images");
//    file.transferTo(new File(realPath+File.separator+file.getOriginalFilename()));
//
//    String userCode = request.getParameter("userCode");
//    String userName = request.getParameter("userName");
//    String userPassword = request.getParameter("userPassword");
//    String gender = request.getParameter("gender");
//    String birthday=request.getParameter("birthday");
//    String phone = request.getParameter("phone");
//    String address = request.getParameter("address");
//    System.out.println(address);
//    String userRole = request.getParameter("userRole");
//    System.out.println(userRole);
//    System.out.println(Integer.valueOf(userRole));
//    User user =new User();
//    user.setUserCode(userCode);
//    user.setUserName(userName);
//    user.setUserPassword(userPassword);
//    user.setGender(Integer.valueOf(gender));
//    user.setBirthday(new Date());
//    user.setPhone(phone);
//    user.setAddress(address);
//    user.setUserRole(Integer.valueOf(userRole));
//    //赋值给user
//    user.setIdPicPath("/images"+file.getOriginalFilename());
//    user.setModifyDate(new Date());
//    int add = userService.add(user);
//        return "redirect:user.do";
//    }

//添加用户
    @RequestMapping("/useraddt.do")
public String add(HttpServletRequest request,User user,HttpSession session,
                  @RequestParam(value = "idPicPath_1",required = false) MultipartFile file) throws IOException {
        //获取项目实际路径
        String realPath = request.getServletContext().getRealPath("images/");
//        保存图片
        file.transferTo(new File(realPath+File.separator+file.getOriginalFilename()));
        user.setIdPicPath("images/"+file.getOriginalFilename());
        User loginUser = (User) session.getAttribute(Constains.USER_SESSION);
        user.setCreationDate(new Date());
        user.setCreatedBy(loginUser.getId());
        int add = userService.add(user);
    return "redirect:user.do";
}

    //模糊查询用户
    @RequestMapping("usermh.do")
    public String mohuers(Model model,String queryname,Integer queryUserRole){
        System.out.println(queryname);
        System.out.println(queryUserRole);
        List<User> mohuser = userService.mohuser(queryname, queryUserRole);
       model.addAttribute("userList",mohuser);
       model.addAttribute("queryUserName",queryname);
       model.addAttribute("queryUserRole",queryUserRole);
         return "userlist";
    }

    //判断两次密码是否一致
    @RequestMapping("/checkPwd.do")
    @ResponseBody
    public  String checkPwd(String oldpassword,HttpSession session){
        User user = (User) session.getAttribute(Constains.USER_SESSION);
        String userPassword = user.getUserPassword();
        if(userPassword.equals(oldpassword)){
            return "true";
        }else {
            return "false";
        }
    }

    //修改用户密码
    @RequestMapping("/updatepwd.do")
   public String updat(String newpassword,HttpSession session){
       User user = (User) session.getAttribute(Constains.USER_SESSION);
       Integer id = user.getId();
       System.out.println(newpassword);
       System.out.println(id);
       int count = userService.updateuser(newpassword, id);
       if(count>0){
           return "redirect:user.do";
       }else{
           return "pwdmodify";
       }
   }

   //查看用户界面
    @RequestMapping("chakan.do")
    public String chakan(Model model,Integer cid){
        User user = userService.getbyid(cid);
        model.addAttribute("user",user);
        return "userview";
    }
    //转发到修改用户信息界面
    @RequestMapping("up.do")
    public String up(Model model ,Integer cid){
        User user = userService.getbyid(cid);
        model.addAttribute("user",user);
        List<Role> roles = roleService.select();
        model.addAttribute("roleList",roles);
        return "usermodify";
    }
   //修改用户信息
    @RequestMapping("updateuser.do")
    @ResponseBody
    public String update(User user,HttpServletRequest request){
        String userName = request.getParameter("userName");
        System.out.println(userName);
        String rid = request.getParameter("rid");
        System.out.println(rid);
        int count = userService.update(user);
        System.out.println(count);
        if(count>0){
            return "true";
        }else {
            return "false";
        }
    }
    //分页

//    public String getList(String queryname,
//                          @RequestParam(defaultValue = "0") Integer queryUserRole,
//                          @RequestParam(defaultValue = "1") Integer currentPageNo,
//                          @RequestParam(defaultValue = "5") Integer pageSize,
//                          HttpSession session,Model model){
//        if(queryUserRole==0){
//            queryUserRole=null;
//        }
//        int currentPageNo2=0;
//        if(currentPageNo2>1){
//            currentPageNo2=(currentPageNo-1)*pageSize;
//        }
//        List<User> list = userService.select();
//        session.setAttribute("userList",list);
//        //1.查询总条数，计算总页数
//
//    }
}


