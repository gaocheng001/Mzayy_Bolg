package cn.mzayy.blog.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Blog implements Serializable {
    private int id;
    private String title;
    private String note;
    private String describe;
    private String writer;
    public void a(){
        int a3;
        System.out.println("abclkj");
    }
}