package com.paic.dao;

import com.paic.model.UserModel;
import org.apache.catalina.User;

public interface UserDao {
    /**
     * 登录
     * @param userModel
     * @return
     */
    UserModel login(UserModel userModel);

    /**
     * 根据用户查询新增用户名已存在
     * @param userModel
     * @return
     */
    UserModel queryUserByUserName(UserModel userModel);

    /**
     * 新增用户
     * @param userModel
     */
    void insert(UserModel userModel);
}