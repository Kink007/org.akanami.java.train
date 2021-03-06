package org.akanami.data.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.akanami.data.mybatis.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {

    @Autowired
    PersonMapper personMapper;

    @Test
    public void getPersonById() {
        Person person = this.personMapper.getPersonById(1);
        Assert.assertNotNull(person);
    }

    @Test
    public void getPersonByName() {
        Person person = this.personMapper.getPersonByName("admin");
        Assert.assertNotNull(person);
    }

    @Test
    public void getAll() {
        ArrayList<Person> persons = this.personMapper.getAll();
        Assert.assertNotNull(persons);
        Assert.assertTrue(persons.size() > 0);
    }

    @Test
    public void selectByPage() {
        PageHelper.startPage(1, 10);
        ArrayList<Person> persons = this.personMapper.selectByPage();
        PageInfo<Person> pageInfo = new PageInfo<>(persons);

        Assert.assertNotNull(pageInfo);
        Assert.assertEquals(1, pageInfo.getPages());
    }
}