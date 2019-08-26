package com.lxh.dao;

import com.lxh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapperPageHelper extends BaseMapper2<User> {

    int countByUsername(String username);
}
