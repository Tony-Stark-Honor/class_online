package com.jtc.ykt.vod.controller;

import com.jtc.ykt.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 小天
 * @Date: 2023/8/24 - 08 - 24 - 13:57
 * @Decsription: com.jtc.ykt.vod.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
@Api("用户操作")
public class LoginController {
    /**
     * 登录
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result login(){
        Map<String,Object> map = new HashMap<>();
        map.put("token","admin");
        return Result.ok(map);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("info")
    public Result info(){
        Map<String,Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }
    /**
     * 退出
     */
    @ApiOperation("用户退出登录")
    @PostMapping("logout")
    public Result logout(){
        return Result.ok(null);
    }
}
