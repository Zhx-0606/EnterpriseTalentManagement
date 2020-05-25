package cn.shiro;

import cn.dao.ShiroUserMapper;
import cn.entity.ShiroUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthenticatingRealm {

    @Autowired
    private ShiroUserMapper shiroUserMapper;
    /**
     *  登录的验证实现方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名称
        UsernamePasswordToken token2 = (UsernamePasswordToken) token;
        String username = token2.getUsername();
        ShiroUser user = shiroUserMapper.getUserByUsername(username);
        if(user == null) {
            //用户名不存在抛出异常
            System.out.println("认证：当前登录的用户不存在");

        }
        /*if(user.getStatus() == 0) {
            throw new UnknownAccountException("用户名已被禁用，请联系系统管理员！");
        }*/

        /**
         * principals: 可以使用户名，或d登录用户的对象
         * hashedCredentials: 从数据库中获取的密码
         * credentialsSalt：密码加密的盐值
         * RealmName:  类名（ShiroRealm）
         */
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), null, getName());
        return info; //框架完成验证
    }

}