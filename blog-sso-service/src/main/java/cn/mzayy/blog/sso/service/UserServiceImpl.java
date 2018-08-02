package cn.mzayy.blog.sso.service;

import cn.mzayy.blog.Mapper.UserMapper;

import javax.annotation.Resource;

public class UserServiceImpl implements  UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void register() {
        userMapper.register("","s");
    }

    @Override
    public void deleteUser() {
        userMapper.deleteUser(1);
    }

    @Override
    public void modifyUser() {
        userMapper.modifyUser(1);
    }

    @Override
    public void login() {
        userMapper.login("","");
    }
}
