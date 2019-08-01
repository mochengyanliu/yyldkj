package com.technology.university.service;

import java.util.Map;

public interface UserService {

    Map<String, Object> selectAllUser(String name,Integer pageNumber, Integer currentPage);
}
