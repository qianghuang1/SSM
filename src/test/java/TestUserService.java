import jufou.info.service.UserService;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by HQ on 10/18/16.
 */
public class TestUserService extends TestCase {
    private UserService userService;
    public void setUp() throws Exception{
        userService=new UserService();
    }
    public void tearDown() throws Exception{
        super.tearDown();
    }
    public void testGetUserNickname(){
        String name= null;
        try {
            name = userService.getUserNickname();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(name,"Hello");
    }
}
