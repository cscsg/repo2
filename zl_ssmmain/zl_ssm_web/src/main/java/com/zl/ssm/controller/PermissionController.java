package com.zl.ssm.controller;


import com.zl.ssm.dao.Permission;
import com.zl.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList=iPermissionService.findAll();
        mv.addObject("permissionlist",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }
}
