package cn.mzayy.blog.Service;


import cn.mzayy.blog.Mapper.BlogDemo;

import cn.mzayy.blog.ServiceAPI.BlogService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(version="1.0.0")
public class BlogServiceImpl implements BlogService {

    @Override
    public String AddNote(String note) {


        return null;
    }
}
