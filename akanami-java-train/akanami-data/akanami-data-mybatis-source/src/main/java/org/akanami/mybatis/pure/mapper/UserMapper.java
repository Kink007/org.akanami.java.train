package org.akanami.mybatis.pure.mapper;

import org.akanami.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserById(Long id);

    int updateUser(User user);
}
