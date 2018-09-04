package cn.mzayy.blog.sso.service;

import cn.mzayy.blog.Mapper.UserMapper;
import cn.mzayy.blog.pojo.User;
import cn.mzayy.bolg.redis.service.JedisClient;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;


import javax.annotation.Resource;

import java.util.UUID;

@Service(version="1.0.0")
public class UserServiceImpl implements  UserService {
    @Reference(version = "1.0.2")
    private  JedisClient jedisClient;
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
    public void login(String user,String password) {
        //1.从数据检查密码是否正确,错误返回错误信息
        if(true){
            //2.清空session，新建用户session
            String key= "User_Session:"+UUID.randomUUID().toString().replaceAll("-","");
            User userPerson=new User();

            jedisClient.expire(key,100);
            //3.
        }else{

        }

    }
}
