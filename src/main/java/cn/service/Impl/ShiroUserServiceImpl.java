package cn.service.Impl;

import cn.dao.ShiroUserMapper;
import cn.entity.ShiroUser;
import cn.service.ShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ShiroUserService")
public class ShiroUserServiceImpl implements ShiroUserService {

    @Autowired
    private ShiroUserMapper shiroUserMapper;

    @Override
    public ShiroUser getUserByUsername(String username) {
        return shiroUserMapper.getUserByUsername(username);
    }
}
