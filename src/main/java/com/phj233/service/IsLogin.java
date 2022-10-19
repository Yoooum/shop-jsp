/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.phj233.service;

import com.phj233.pojo.User;

/**
 * @projectName: JSPproject
 * @package: com.phj233.service
 * @className: IsLogin
 * @author: phj233
 * @date: 2022/10/16 13:20
 * @version: 1.0
 */

public interface IsLogin {
    Boolean adminLogin(String name,String passwd);

    Boolean userLogin(String name, String passwd);

    User getUser(String info);
}