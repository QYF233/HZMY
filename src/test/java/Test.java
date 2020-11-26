import cn.edu.hzvtc.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    public UserMapper userMapper;

    @org.junit.Test
    public void test() {
        userMapper.selectAll();
    }
}
