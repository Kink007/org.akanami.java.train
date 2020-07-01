package org.akanami.data.mybatis.mapper;

import org.akanami.data.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    @Select(" select * from t_sys_user where id = #{id} ")
    User getUserById(Integer id);

    @Select(" select * from t_sys_user where name = #{name} ")
    User getUserByName(String name);

    @Select(" select * from t_sys_user ")
    ArrayList<User> getAll();

    @Insert({" insert into t_sys_user (name, birth) values (#{name}, #{birth}) " })
    void add(User user);
//
//    User update(User user);
//
//    User delete(User user);
}
