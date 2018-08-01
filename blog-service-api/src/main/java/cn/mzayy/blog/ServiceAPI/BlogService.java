package cn.mzayy.blog.ServiceAPI;

import cn.mzayy.blog.pojo.Blog;

import java.util.List;
import java.util.Map;


public interface BlogService {
    public String AddNote(Blog blog);
    public Map<Integer, Object> findFenlei();
    public List<Blog> findNoteDir(int id);
    public String findNote(int id);
    public void deleteNote(int id);
    public void addFenlei(String fenleiName);
    public void deleteFenlei(int id);
}
