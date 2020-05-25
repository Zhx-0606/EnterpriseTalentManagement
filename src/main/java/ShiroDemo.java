import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

public class ShiroDemo {


    public static void main(String[] args) {
        SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();
        simpleAccountRealm.addAccount("admin","1234","sa","user");
        //构建SecurityManage环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
       // defaultSecurityManager.setRealm(simpleAccountRealm);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
       //当前用户
        Subject user = SecurityUtils.getSubject();

        //通过UsernamePasswordToken来模拟html/jsp传递过来的用户名与密码
        UsernamePasswordToken token=new UsernamePasswordToken("admin","1234");
        user.login(token);
        System.out.println("isAuthenticated："+user.isAuthenticated());
        user.checkRoles("sa","user");
//        user.logout();
//        System.out.println("isAuthenticated："+user.isAuthenticated());
        //通过shiro来判断用户是否登录成功：Ctrl+alt+t
        /*try {
            user.login(token);
            System.out.println("登录成功！！");
            user.logout();
        } catch (AuthenticationException e) {
            System.out.println("登录失败！！");
        }*/
    }
}
