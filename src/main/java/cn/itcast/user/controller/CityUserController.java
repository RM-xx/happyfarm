package cn.itcast.user.controller;

import cn.itcast.user.pojo.CityUser;
import cn.itcast.user.service.CityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("index")
public class CityUserController {

    @Autowired
    private CityUserService cityUserService;


    /**
     * 返回登陆视图
     * @param
     * @return
     */
    @GetMapping("index")
//    @ResponseBody
    public String login(HttpServletResponse httpServletResponse) {
        return "signin";
    }


    /**
     *
     * @param code
     * @param password
     * @return
     */
    @GetMapping("check")
    public String check(String code, String password, HttpServletResponse httpServletResponse)  throws Exception {

        httpServletResponse.setContentType("text/html;charset=utf-8");
        CityUser cityUser = cityUserService.queryUserByCode(code);

        if (cityUser == null) {
            httpServletResponse.getWriter().write("<script>alert('用户不存在！');</script>");
            httpServletResponse.getWriter().flush();
        }
        Boolean flag = cityUser.getPassword().equals(password);
        if (flag) {
            ModelMap modelMap = new ModelMap();
            modelMap.addAttribute("user", cityUser);
            modelMap.addAttribute("name", "name");
            return index(cityUser, modelMap);
        } else {
            httpServletResponse.getWriter().write("<script>alert('密码输入错误！');</script>");
            httpServletResponse.getWriter().flush();
        }

        return login(httpServletResponse);
    }

    /**
     * 返回个人中心
     * @param
     * @return
     */
//    @GetMapping("info")
    public String index(CityUser cityUser, ModelMap modelmap) {
        return "index";
    }


    @GetMapping("registerView")
    public String registerView() {
        return "signup";
    }

    @GetMapping("register")
    public String register(HttpServletResponse httpServletResponse, CityUser cityUser, String password2) throws Exception {
        httpServletResponse.setContentType("text/html;charset=utf-8");

        if (cityUser.getPassword().equals(password2)) {
            if (cityUserService.insertCityUser(cityUser) == 1) {
                httpServletResponse.getWriter().write("<script>alert('注册成功，赶快登录吧！');</script>");
                httpServletResponse.getWriter().flush();
            }else {
                httpServletResponse.getWriter().write("<script>alert('注册失败，请重试！');</script>");
                httpServletResponse.getWriter().flush();
                return registerView();
            }
        } else {
            httpServletResponse.getWriter().write("<script>alert('两次密码不一致！');</script>");
            httpServletResponse.getWriter().flush();
            return registerView();
        }

        return login(httpServletResponse);
    }


}
