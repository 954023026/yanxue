package com.ketai.safe.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.common.response.Result;
import com.ketai.safe.pojo.Administrator;
import com.ketai.safe.service.AdministratorService;
import com.ketai.safe.util.JwtUtil;
import com.ketai.safe.util.SHAUtils;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Api(tags = "系统用户管理")
@RestController
@RequestMapping("/safe/passport/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping(value = "dologin",consumes = "application/json")
    @ApiOperation(value = "用户登录")
    public Result login(@ApiParam(name = "Administrator", value = "管理员用户对象", required = true) @RequestBody Administrator administrator) {
        String accountName = administrator.getAccountName();
        if (StringUtils.isEmpty(accountName)) {
            return Result.error().message("用户名不能为空！");
        }
        System.out.println("开始登录");
        String password = SHAUtils.encodeData(administrator.getPassword());
        administrator.setPassword(password);
        Administrator admin = administratorService.findUserVoByUsernameAndPassword(administrator);
        if (admin == null) {
            return Result.error().message("帐号密码错误");
        }
        String token = JwtUtil.getToken(admin.getAccountName(), admin.getPeopleType());
        System.out.println("登录成功,返回token----》" + token);
        Map map = new HashMap();
        map.put("token", token);
        return Result.ok(map);
    }

    @PostMapping("userInfo")
    @ApiOperation(value = "获取用户信息")
    public Result userInfo(@ApiParam(name = "token", value = "令牌", required = true) @RequestParam String token) throws ServletException {
        Claims claims = JwtUtil.checkToken(token);
        String accountName = claims.getSubject();
        System.out.println("获取用户名---》" + accountName);
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>();
        Administrator account = administratorService.getOne(queryWrapper.eq("account_name", accountName));
        return Result.ok(account);
    }

    @PostMapping("logout")
    @ApiOperation(value = "用户登出")
    public Result logout(HttpServletRequest request) {
        //请求头中获取token
        String authHeader = request.getHeader("pin");
        if (authHeader == null) {
            ExceptionThrowOut.cast(ResultCodeEnum.USERUNLOGIN_ERROR);
        }
        //验证token
        Claims claims = JwtUtil.checkToken(authHeader);
        //删除用户退出
        claims.remove(claims.getSubject());
        return Result.ok();
    }

    public static void main(String[] args) {
        Claims claims = null;
        try {
            claims = JwtUtil.checkToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTExMSIsInJvbGVzIjoic3RyaW5nIiwiaWF0IjoxNTgwOTczMTYwLCJleHAiOjE1ODA5NzQ5NjB9.qyHgoBNV_pVB7qKy74J9_1XO7Dlci57GMnmUg85CZWs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("退出----->" + claims);
    }
}
