package com.lhao.bookdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhao.bookdb.bean.User;

/**
 *
 */
public interface UserService extends IService<User> {

    User check(String name, String pwd);
}
