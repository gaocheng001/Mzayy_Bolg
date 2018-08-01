package cn.mzayy.blog.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Blog implements Serializable {
    public int id;
    public String title;
    private String note;
    private int fenlei;
    private String describe;
    private String writer;
    private Date date=new Date(2018,3,1);
}