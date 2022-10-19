/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.phj233.control;

import com.alibaba.fastjson2.JSON;
import com.phj233.impl.IsLoginImpl;
import com.phj233.mybatis.mappers.UserMapper;
import com.phj233.pojo.User;
import com.phj233.service.IsLogin;
import com.phj233.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @projectName: JSPproject
 * @package: com.phj233.control
 * @className: UpdateServlet
 * @author: phj233
 * @date: 2022/10/19 17:47
 * @version: 1.0
 */
@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers"," Content-Type");
        String newName=request.getParameter("newName");
        String newEmail=request.getParameter("newEmail");
        String newPasswd=request.getParameter("newPasswd");
        int uid= Integer.parseInt(request.getParameter("uid"));
        String name=request.getParameter("user");
        String passwd=request.getParameter("passwd");
        boolean admin= Boolean.parseBoolean(request.getParameter("admin"));
        System.out.println(name+passwd+admin);
        PrintWriter out = response.getWriter();
        IsLogin login = new IsLoginImpl();
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        if (login.userLogin(name,passwd)){
            User user=new User(uid,newName,newPasswd,newEmail,admin);
            if (userMapper.updateUser(user)) out.print(JSON.toJSONString(userMapper.getUserById(uid)));
        }

    }
}
