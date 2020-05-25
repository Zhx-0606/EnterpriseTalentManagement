import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class ShiroDemo2 {



    public static void main(String[] args) {

        JdbcRealm jdbcRealm=new JdbcRealm();
//        jdbcRealm.setDataSource();


        //构建SecurityManage环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();

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
