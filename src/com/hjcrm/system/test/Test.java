package com.hjcrm.system.test;

import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.*;
import com.hjcrm.system.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
        /*InterUserService service = context.getBean("userService",InterUserService.class);
        User user = service.queryUserInfoByEmail("123@qq.com");
        System.out.println("user:"+user);
        if(user==null){
            System.out.println("账号不存在");
            return;
        }
        if(service.queryPasswordIsExis(new User(user.getUserid(),"123"))==null){
            System.out.println("密码不正确");
            return;
        }
        System.out.println("user:"+"登陆成功");*/
       /* List<Menu> list = service.queryMenuByRoleId("35");
        System.out.println("size:"+list.size());
        for (Menu m:list
             ) {
            System.out.println(m+",");
        }*/
        /*InterDeptService deptService = context.getBean("deptService",InterDeptService.class);
        List<Dept> list = deptService.queryAllDept();
        for (Dept d:list
             ) {
            System.out.println("部门："+d);

        }
        List<Role> rolelist = deptService.queryRoleByDeptId("15");
        for (Role r:rolelist
                ) {
            System.out.println("部门下的角色："+r);
        }*/
        /*InterRoleService roleService = context.getBean("roleService",InterRoleService.class);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(0);
        pageBean.setPageSize(5);
        List<Role> list = roleService.queryAllRole(pageBean);
        for (Role r: list
             ) {
            System.out.println("角色信息："+r);
        }*/
        /*InterDeptService deptService = context.getBean("deptService",InterDeptService.class);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(0);
        pageBean.setPageSize(5);
        List<Dept> list = deptService.queryAllDeptPage(pageBean);
        for (Dept d:list
             ) {
            System.out.println(d);
        }*/
        /*InterCourseService courseService = context.getBean("courseService",InterCourseService.class);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(0);
        pageBean.setPageSize(5);
        List<Course> list = courseService.queryCourse(pageBean);
        System.out.println(list.size());
        for (Course c: list
             ) {
            System.out.println("角色信息："+c);
        }*/
/*        InterSubjectService subjectService = context.getBean("subjectService",InterSubjectService.class);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(0);
        pageBean.setPageSize(5);
        List<Subject> list = subjectService.querySubject(pageBean);
        System.out.println(list.size());
        for (Subject s: list
                ) {
            System.out.println("角色信息："+s);
        }*/
        /*InterPatterTypeService patterTypeService = context.getBean("patterTypeService",InterPatterTypeService.class);
        List<PatterType> list = patterTypeService.queryPattertype();
        String json = PageBean.jsonToPage(list,null);
        System.out.println(json);*/
        /*InterPatterService patterService = context.getBean("patterService",InterPatterService.class);
        Patter patter = new Patter();
        patter.setUserid(1);
        List<Patter> list = patterService.queryPatter(patter);
        String json = PageBean.jsonToPage(list,null);
        System.out.println(json);*/

        /*InterResourceService resourceService = context.getBean("resourceService",InterResourceService.class);
        Resource resource = new Resource();
        resource.setCurrentPage(0);
        resource.setPageSize(5);
        List<Resource> list = resourceService.queryResource(map);
        System.out.println(list.size());
        for (Resource r: list
                ) {
            System.out.println("角色信息："+r);
        }*/
    }
}
