package com.system.managesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.system.managesystem.common.QueryPageParam;
import com.system.managesystem.common.Result;
import com.system.managesystem.pojo.User;
import com.system.managesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ManageSystem
 * @since 2023-09-16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    // add User
    @PostMapping("/add")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }

    // update User
    @PostMapping("/update")
    public boolean update(@RequestBody User user){
        return userService.updateById(user);
    }

    // add or update User
    @PostMapping("/addOrUpdate")
    public boolean addOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    // delete
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    // fuzzy search
    @PostMapping ("/search")
    public List<User> search(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,user.getName());
        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping ("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam queryPageParam){
//        System.out.println(queryPageParam);
//        System.out.println("num==="+queryPageParam.getPageNum());
//        System.out.println("size==="+queryPageParam.getPageSize());

        HashMap param=queryPageParam.getParam();
        String name=(String)param.get("name");
        System.out.println("name==="+name);
//        System.out.println("no==="+(String)param.get("no"));
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,name);

        IPage result= userService.page(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());
        return result.getRecords();
    }
    @PostMapping ("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam queryPageParam){

        HashMap param=queryPageParam.getParam();
        String name=(String)param.get("name");
        System.out.println("name==="+name);
//        System.out.println("no==="+(String)param.get("no"));
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,name);

//        IPage result= userService.pageC(page);
        IPage result= userService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());
        return result.getRecords();
    }

    @PostMapping ("/result")
    public Result returnResult(@RequestBody QueryPageParam queryPageParam){

        HashMap param=queryPageParam.getParam();
        String name=(String)param.get("name");
        System.out.println("name==="+name);
//        System.out.println("no==="+(String)param.get("no"));
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,name);

//        IPage result= userService.pageC(page);
        IPage result= userService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());
        return Result.succeed(result.getRecords(),result.getTotal());
    }
}