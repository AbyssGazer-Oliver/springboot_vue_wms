package com.system.managesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
    public Result save(@RequestBody User user){
        return userService.save(user)?Result.succeed():Result.fail();
    }

    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no){
        List<User> list=userService.lambdaQuery().eq(User::getNo,no).list();
        return list.size()>0?Result.succeed(list):Result.fail();
    }

    // update User
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        return userService.updateById(user)?Result.succeed():Result.fail();
    }

    // add or update User
    @PostMapping("/addOrUpdate")
    public Result addOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user)?Result.succeed():Result.fail();
    }

    // delete
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return userService.removeById(id)?Result.succeed():Result.fail();
    }
    // fuzzy search
    @PostMapping ("/search")
    public Result search(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(user.getName())){
            lambdaQueryWrapper.like(User::getName,user.getName());
        }
        return Result.succeed(userService.list(lambdaQueryWrapper));
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
    public Result listPageC(@RequestBody QueryPageParam queryPageParam){

        HashMap param=queryPageParam.getParam();
        String name=(String)param.get("name");
        String sex=(String)param.get("sex");
        System.out.println("name==="+name);
//        System.out.println("no==="+(String)param.get("no"));
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(ObjectUtils.isNotNull(name)&&StringUtils.isNotBlank(name)&&!"null".equals(name)){
            lambdaQueryWrapper.like(User::getName,name);
        }
        if(ObjectUtils.isNotNull(sex)&&StringUtils.isNotBlank(sex)&&!"null".equals(sex)){
            lambdaQueryWrapper.eq(User::getSex,sex);
        }
//        IPage result= userService.pageC(page);
        IPage result= userService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());
        return Result.succeed(result.getRecords(),result.getTotal());
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
        if(ObjectUtils.isNotNull(name)&&StringUtils.isNotBlank(name)&&!"null".equals(name)){
            lambdaQueryWrapper.like(User::getName,name);
        }

//        IPage result= userService.pageC(page);
        IPage result= userService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());
        return Result.succeed(result.getRecords(),result.getTotal());
    }
}
