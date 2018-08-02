package cn.mzayy.blog.Mapper;

public interface UserMapper {
    public void register(String userName,String password);
    public void deleteUser(int id);
    public void modifyUser(int id);
    public void login(String userName,String password);
}
