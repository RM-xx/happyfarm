package cn.itcast.user.controller;

import cn.itcast.user.pojo.Admin;
import cn.itcast.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 返回主界面视图
     * @param modelMap
     * @return
     */
    @GetMapping("admin")
    @ResponseBody
    public String admin(ModelMap modelMap) {

        return "admin";

    }


    /**
     * 根据id查找用户，这是个测试方法。
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public Admin queryAdminById(@PathVariable("id")int id) {
        Admin admin = adminService.queryAdminById(id);
        System.out.println(admin.toString());
        return admin;
    }


}
