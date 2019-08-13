package com.lxh.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

public class JedisPoolUtil {
	protected static Logger logger = LogManager.getLogger(JedisPoolUtil.class);
	private static JedisPool jedisResourcePool = null;

	/**
	 * 静态代码初始化连接池
	 */
	static{
		try{
			Properties props = new Properties();
			props.load(JedisPoolUtil.class.getClassLoader().getResourceAsStream("application.properties"));
			props.load(JedisPoolUtil.class.getClassLoader().getResourceAsStream("config/redis.properties"));
			// 创建jedis池配置实例
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(Integer.valueOf(props.getProperty("jedis.pool.maxTotal")));
			config.setMaxIdle(Integer.valueOf(props.getProperty("jedis.pool.maxIdle")));
			config.setMaxWaitMillis(Long.valueOf(props.getProperty("jedis.pool.maxWait")));
			config.setTestOnBorrow(Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow")));
			config.setTestOnReturn(Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn")));
			jedisResourcePool = new JedisPool(config,props.getProperty("spring.jedis.host"),
					Integer.valueOf(props.getProperty("spring.jedis.port")));
		} catch (IOException e){
			e.printStackTrace();
			logger.error("Read properties error : " + e);
		}
	}
	/**
	 * 同步获取Jedis实例
	 *
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		Jedis jedis = null;
		try {
			if (jedisResourcePool != null) {
				jedis = jedisResourcePool.getResource();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Get jedis error : " + e);
		}
		return jedis;
	}

}