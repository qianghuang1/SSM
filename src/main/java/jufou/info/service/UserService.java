package jufou.info.service;

import jufou.info.impl.UserServiceImpl;
import jufou.info.mapper.UserMapper;
import jufou.info.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by HQ on 10/18/16.
 */
@Component
@Scope(scopeName="singleton")
public class UserService implements UserServiceImpl {
    @Resource(name="sqlSession")
    private SqlSession sqlSession;
    public UserService(){

    }
    public String getUserNickname() throws Exception {
        throw new Exception();
    }
    public void test(){
//        System.out.println("running");
//        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
//        System.out.println("hahhahaha "+mapper.findById(1));
//        mapper.setUserName("1111",1);
//        int z=Integer.parseInt("AA");
//        keepWriting();
//        keepReading();
    }
    @Transactional(isolation =  Isolation.READ_COMMITTED,rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void keepWriting(){
        final UserMapper mapper= sqlSession.getMapper(UserMapper.class);
        Runnable runnable=new Runnable() {
            public void run() {
                while(true){
                    synchronized (this){
                        String newName=RandomStringUtils.randomAlphabetic(4);
                        mapper.setUserName(newName,1);
                        System.out.println("change new Name: "+newName);
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();

    }

    public void keepReading(){
        final UserMapper mapper= sqlSession.getMapper(UserMapper.class);
        Runnable runnable=new Runnable() {
            public void run() {
                while (true){
                    synchronized (this){
                        System.out.println("read name:  "+mapper.findById(1).getName());
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
