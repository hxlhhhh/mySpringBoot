package com.example.demo;

import com.lxh.DemoApplication;
import com.lxh.depc.entity.Configuration1;
import com.lxh.properties.MyProperties1;
import com.lxh.properties.MyProperties2;
import com.lxh.util.JedisPoolUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
    /*测试redis*/
    @Test
    public void TestRedis(){
        Jedis jedis = null;
        String value = null;
        long queryStartTime = 0; // 查询的开始时间
        long queryEndTime = 0; // 查询的终止时间
        try {
            queryStartTime = System.currentTimeMillis();// redis 查询开始时间
            jedis = JedisPoolUtil.getJedis();// 获取redis的链接
            value = jedis.get("name");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            queryEndTime = System.currentTimeMillis(); // redis 查询结束时间
            System.out.println(" redis query times=" + (queryEndTime - queryStartTime));
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    /*测试日志*/
    @Test
    public void TestLogger() {
        Logger logger =  LoggerFactory.getLogger(getClass()); //声明日志记录器
        logger.trace("这是trace日志");    //跟踪器日志
        logger.debug("这是debug日志");  //调试日志
        logger.info("这是info日志");    //自定义日志
        logger.warn("这是warn日志");    //警告日志
        logger.error("这是error日志");  //错误日志
    }
    /*测试configuration*/
    @Autowired
    private Configuration1 configuration1;
    @Test
    public void TestConfiguration(){
        System.out.println("================================");
        System.out.println(configuration1);
        System.out.println("================================");
    }

    /*测试自定义属性Properties*/
    @Autowired
    private MyProperties1 myProperties1;
    @Test
    public void TestProperties1(){
        System.out.println("================================");
        System.out.println(myProperties1);
        myProperties1.toString();
        System.out.println("================================");
    }

    /*测试自定义文件Properties*/
    @Autowired
    private MyProperties2 myProperties2;
    @Test
    public void TestProperties2(){
        System.out.println("================================");
        System.out.println(myProperties2);
        myProperties2.toString();
        System.out.println("================================");
    }

}



