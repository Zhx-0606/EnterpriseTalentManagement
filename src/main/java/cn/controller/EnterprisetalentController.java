package cn.controller;

import cn.entity.Department;
import cn.entity.Enterprisetalent;
import cn.entity.ShiroUser;
import cn.service.DepartmentService;
import cn.service.EnterprisetalentService;
import cn.service.ShiroUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("enter")
public class EnterprisetalentController {

    @Autowired
    private EnterprisetalentService enterprisetalentService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ShiroUserService shiroUserService;

    @RequestMapping("/login")
    public String login(ShiroUser shiroUser){
        /*shiroUserService.getUserByUsername(shiroUser.getUsername());*/
        //获取主体
        Subject subject= SecurityUtils.getSubject();
        try {
            //调用安全认证框架的登录方法
            subject.login(new UsernamePasswordToken(shiroUser.getUsername(),shiroUser.getPassword()));
        } catch (AuthenticationException e) {
            return "ShiroUser";
        }
        return "login";
    }
    @RequestMapping("/enterpriseTalent")
    public String enterpriseTalent(@RequestParam(name = "departmentId",required = false)Integer departmentId,
                                   @RequestParam(name = "pageIndex",required = true,defaultValue = "1")Integer pageIndex,
                                   Model model){
        PageHelper.startPage(pageIndex,1);
        List<Enterprisetalent> enterprisetalents=enterprisetalentService.SelectEnterprisetalent(departmentId,null);
        PageInfo<Enterprisetalent> pageInfo=new PageInfo<>(enterprisetalents);

        model.addAttribute("pageInfo",pageInfo);

        List<Department> departmentList=departmentService.SelDepartment();
        model.addAttribute("departmentList",departmentList);
        return "enterpriseTalent";
    }
    /*进入增加页面*/
    @RequestMapping("/department")
    public String department(Model model){
        List<Department> departmentList=departmentService.SelDepartment();
        model.addAttribute("departmentList",departmentList);
        return "department";
    }
    /*增加操作*/
    @RequestMapping("/insertDepartment")
    public String insertDepartment(Enterprisetalent enterprisetalent){
        boolean isOk=enterprisetalentService.InsertEnterprisetalent(enterprisetalent);
        if (isOk){
            return "redirect:/enter/enterpriseTalent";
        }else{
            return "redirect:/enter/department";
        }
    }
    /*进入修改页面*/
    @RequestMapping("/UpDepartment/{id}")
    public String UpDepartment(@PathVariable("id")Integer id,Model model){
        List<Department> departmentList=departmentService.SelDepartment();
        List<Enterprisetalent> enterprisetalents=enterprisetalentService.SelectEnterprisetalent(null,id);
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("enterprisetalents",enterprisetalents);
        return "UpDepartment";
    }
    /*修改操作*/
    @RequestMapping("/UpdateDepartment")
    public String UpdateDepartment(Enterprisetalent enterprisetalent){
        boolean isOk=enterprisetalentService.UpdateEnterprisetalent(enterprisetalent);
        if (isOk){
            return "redirect:/enter/enterpriseTalent";
        }else{
            return "redirect:/enter/UpDepartment";
        }
    }
    /*删除*/
    @RequestMapping("/DelEnterprisetalent")
    @ResponseBody
    public String DelEnterprisetalent(@RequestParam(name = "id",required = true)Integer id){
        boolean isOk=enterprisetalentService.DeleteEnterprisetalent(id);
        if (isOk){
            return "true";
        }else{
            return "false";
        }
    }
}
