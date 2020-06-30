package org.akanami.springboot.annotation.configuration.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "akanami.mocker")
public class MockConfigurationProperties {
    String name;
    Integer age;
    Date birth;
    ArrayList<String> tags;
    Map<String, String> maps;
    Map<String, String> maps2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Map<String, String> getMaps2() {
        return maps2;
    }

    public void setMaps2(Map<String, String> maps2) {
        this.maps2 = maps2;
    }
}
