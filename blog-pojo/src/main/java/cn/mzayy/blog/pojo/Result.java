package cn.mzayy.blog.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Result<T> implements Serializable {
    public List<T> list=new ArrayList<>();
}
