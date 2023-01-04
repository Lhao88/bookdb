package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhao.bookdb.bean.User;
import com.lhao.bookdb.mapper.UserMapper;
import com.lhao.bookdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User check(String name, String pwd) {
        QueryWrapper queryWrapper = new QueryWrapper();
        HashMap<String, Object> map = new HashMap<>();
        map.put("u_name", name);
        map.put("pwd", pwd);
        queryWrapper.allEq(map);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public void updatePwdById(User user) {
        userMapper.updateById(user);
    }


}




