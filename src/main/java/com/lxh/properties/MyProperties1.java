package com.lxh.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/*加入到容器*/
@Component
/*加载文件resources下的properties下的my2*/
@PropertySource("classpath:properties/my2.properties")
/*可以把同类的配置信息自动封装成实体类*/
@ConfigurationProperties(prefix = "my2")
public class MyProperties1 {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyProperties1{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
