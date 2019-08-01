package com.technology.university.service.impl;

import com.technology.university.entity.UserEntity;
import com.technology.university.mapper.UserEntityMapper;
import com.technology.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityMapper userEntityMapper;

    @Override
    public Map<String, Object> selectAllUser(String name,Integer pageNumber, Integer currentPage) {
        Map<String, Object> map = new HashMap<>();
        com.anji.plus.assessment.util.PageUtil pageUtil = new com.anji.plus.assessment.util.PageUtil();
        pageUtil.setPageNumber(pageNumber);
        pageUtil.setTotalNumber(userEntityMapper.selectAllUserCount(name));
        pageUtil.setCurrentPage(currentPage);
        List<UserEntity> userEntities = userEntityMapper.selectAllUser(name,pageUtil.getDbIndex(),pageUtil.getDbNumber());
        map.put("pageUtil", pageUtil);
        map.put("userEntities", userEntities);
        return map;
    }
}
