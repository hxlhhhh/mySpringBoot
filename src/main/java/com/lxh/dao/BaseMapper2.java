package com.lxh.dao;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

@RegisterMapper
public interface BaseMapper2<T> {
    @SelectProvider(
        type = BaseSelectProvider2.class,
        method = "selectOne2"
    )
    T selectOne22(T var1);
}