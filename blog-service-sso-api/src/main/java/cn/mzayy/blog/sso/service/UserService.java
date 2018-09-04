package cn.mzayy.blog.sso.service;

public interface UserService {
    public void register();
    public void deleteUser();
    public void modifyUser();
    public void login(String user,String password);
}
