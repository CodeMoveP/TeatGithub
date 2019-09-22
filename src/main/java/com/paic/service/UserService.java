package com.paic.service;

import com.paic.model.MyResult;
import com.paic.model.UserModel;
/**
 * 逻辑处理层接口
 */
public interface UserService {
    /**
     * 登录方法
     * （小技巧：快速删除一行代码：ctrl+X,去除多余包：Ctrl + Alt + O）
     */
    MyResult login(UserModel userModel);

    /**
     * 新增用户
     * @param userModel
     * @return
     */
    MyResult insert(UserModel userModel);
}
