package com.lxh.dao;

import com.lxh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
@Mapper
public interface UserMapperPageHelper extends BaseMapper<User> {

    int countByUsername(String username);
}
