package com.technology.university.mapper;

import com.technology.university.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    int selectAllUserCount(@Param("name") String name);

    List<UserEntity> selectAllUser(@Param("name") String name, @Param("dbIndex") int dbIndex, @Param("dbNumber") int dbNumber);

}