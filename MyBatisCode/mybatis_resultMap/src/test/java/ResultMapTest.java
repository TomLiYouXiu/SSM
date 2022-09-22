import com.liyouxiu.mybatis.mapper.EmpMapper;
import com.liyouxiu.mybatis.pojo.Emp;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author liyouxiu
 * @date 2022/9/22 20:52
 */
public class ResultMapTest {

    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getsqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(2);
        System.out.println(emp);

    }
}
