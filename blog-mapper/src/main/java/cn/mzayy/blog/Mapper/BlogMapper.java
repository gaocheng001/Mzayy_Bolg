package cn.mzayy.blog.Mapper;

import cn.mzayy.blog.pojo.Blog;
import cn.mzayy.blog.pojo.Fenlei;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface BlogMapper {
    public void AddNote(Blog blog);
    public List<Fenlei> findFenlei();
    public List<Blog> findNoteDir(int id);
    public String  findNote(int id);
    public void deleteNote(int id);
    public void addFenlei(String fenleiName);
    public void deleteFenlei(int id);
}
