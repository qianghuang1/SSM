package jufou.info.mapper;

import jufou.info.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by HQ on 10/24/16.
 */
public interface UserMapper {
    @Select("select * from user where uid=#{id}")
    public User findById(int id);
    @Update("update user set name = #{name} where uid = #{id}")
    public void setUserName(@Param(value="name") String name,@Param(value = "id")int id);
}
