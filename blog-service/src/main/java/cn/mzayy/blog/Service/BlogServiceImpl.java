package cn.mzayy.blog.Service;




import cn.mzayy.blog.Mapper.BlogMapper;
import cn.mzayy.blog.ServiceAPI.BlogService;
import cn.mzayy.blog.pojo.Blog;
import cn.mzayy.blog.pojo.Fenlei;
import cn.mzayy.bolg.redis.service.JedisClient;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.csource.fastdfs.StorageClient;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service(version="1.0.0")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Reference(version = "1.0.0")
    private JedisClient jedisClient;
    @Override
    public String AddNote(Blog blog) {
        System.out.println(jedisClient);
        blogMapper.AddNote(blog);

        return "bb";
    }

    @Override
    public Map<Integer, Object> findFenlei() {
        List<Fenlei> list=blogMapper.findFenlei();
        Map<Integer,Object> fenleis=new HashMap();
        for(Fenlei f:list){
            fenleis.put(f.getId(),f.getBlogDir());
        }
        Object obj = null;
        for (Entry<Integer, Object> entry : fenleis.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        //默认笔记列表key为1011
        List<Blog> list1=findNoteDir((int)obj);

        fenleis.put(1011,list1);
        return fenleis;
    }
    public List<Blog> findNoteDir(int id){
        List<Blog> list=blogMapper.findNoteDir(id);
        return  list;
    }
    public String findNote(int id){
        System.out.println("001..");
        String note=blogMapper.findNote(id);
        System.out.println(note);
        return  note;
    }

    @Override
    public void deleteNote(int id) {
        blogMapper.deleteNote(id);
    }

    @Override
    public void addFenlei(String fenleiName) {
        blogMapper.addFenlei(fenleiName);
    }

    @Override
    public void deleteFenlei(int id) {
        blogMapper.deleteFenlei(id);
    }
    public void fileUpload(){

    }
}
