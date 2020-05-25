import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class ShiroDemo1 {


    public static void main(String[] args) {

        IniRealm iniRealm=new IniRealm("classpath:shiro.ini");

        //构建SecurityManage环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
       //当前用户
        Subject user = SecurityUtils.getSubject();

        //通过UsernamePasswordToken来模拟html/jsp传递过来的用户名与密码
        UsernamePasswordToken token=new UsernamePasswordToken("admin","1234");
        user.login(token);
        System.out.println("isAuthenticated："+user.isAuthenticated());

        user.checkRole("sa");
        user.checkPermission("user:update");
    }
}
