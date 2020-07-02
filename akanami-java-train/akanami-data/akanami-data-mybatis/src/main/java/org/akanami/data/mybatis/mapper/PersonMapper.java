package org.akanami.data.mybatis.mapper;

import org.akanami.data.mybatis.model.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PersonMapper {
    Person getPersonById(Integer id);

    Person getPersonByName(String name);

    ArrayList<Person> getAll();

    ArrayList<Person> selectByPage();
}
