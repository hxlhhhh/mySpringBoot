package com.lxh.depc;

import com.lxh.depc.entity.Configuration1;
import com.lxh.depc.entity.Configuration2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*

@Configuration标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
@Configuation等价于<Beans></Beans>
@Bean等价于<Bean></Bean>

*/
@Configuration
public class TestConfiguration {
    @Bean
    public Configuration1 getConfiguration1 (){
        return new Configuration1();
    }
    @Bean
    public Configuration2 getConfiguration2(){
        return new Configuration2();
    }
}
