package org.akanami.mybatis.pure;

import org.akanami.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Demo01 {
//    public static void main(String[] args) {
//        String resource = "mybatis/demo01/configuration.xml";
//        Reader reader;
//
//        try {
//            reader = Resources.getResourceAsReader(resource);
//
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//
//            User user = (User)sqlSession.selectOne("org.akanami.mybatis.pure.mapper.UserMapper.getUserById", Long.valueOf(1L));
//            System.out.println("user:" + user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        String resource = "mybatis/demo01/configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = new User();
            user.setId(1L);
            user.setName("admin1");

            int update = sqlSession.update("org.akanami.mybatis.pure.mapper.UserMapper.updateUser", user);
            System.out.println("update:" + update);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
