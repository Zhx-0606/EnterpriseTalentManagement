package cn.service;

import cn.entity.ShiroUser;

public interface ShiroUserService {
    ShiroUser getUserByUsername(String username);
}
