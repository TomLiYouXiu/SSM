import com.liyouxiu.mybatis.mapper.CacheMapper;
import com.liyouxiu.mybatis.pojo.Emp;
import com.liyouxiu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author liyouxiu
 * @date 2022/9/25 21:19
 */
public class CacheMapperTest {

    @Test
    public void testGetEmpById(){
        SqlSession sqlSession1 = SqlSessionUtil.getsqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);
        SqlSession sqlSession2 = SqlSessionUtil.getsqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp3);
    }
}
