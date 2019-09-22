package com.paic.service.impl;

import com.paic.dao.UserDao;
import com.paic.model.MyResult;
import com.paic.model.UserModel;
import com.paic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登录
     * @param userModel
     * @return
     */
    @Override
    public MyResult login(UserModel userModel) {
        UserModel model = new UserModel();
        List<UserModel> list = new ArrayList<>();
        MyResult result = new MyResult();
        model = userDao.login(userModel);
        if(model !=null){
            result.setCode(200);
            result.setMsg("登录成功！");
            list.add(model);
            result.setList(list);
        }else{
            result.setCode(401);
            result.setMsg("该用户不存在,请先注册！");
        }
        return result;
    }

    /**
     * 新增用户
     * @param userModel
     * @return
     */
    @Override
    public MyResult insert(UserModel userModel) {
        //返回消息
        MyResult result = new MyResult();
        //根据用户名查询是否有用户已存在
        UserModel model = userDao.queryUserByUserName(userModel);
        if(model !=null){ //新增的用户已存在
            result.setCode(401);
            result.setMsg("该用户已存在，请重新输入！");
        }else{//不存在,新增到数据表
            userDao.insert(userModel);
            result.setCode(200);
            result.setMsg("新增用户成功！");
        }
        return null;
    }
}
