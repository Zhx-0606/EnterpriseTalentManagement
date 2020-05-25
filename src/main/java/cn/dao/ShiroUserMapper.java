package cn.dao;

import cn.entity.ShiroUser;

public interface ShiroUserMapper {
    ShiroUser getUserByUsername(String username);
}
