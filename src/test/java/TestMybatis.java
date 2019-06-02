import com.warcraftyork.pictureclassify.bean.DBInfo;
import com.warcraftyork.pictureclassify.core.MybstisSqlSessionFactory;
import com.warcraftyork.pictureclassify.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestMybatis {
    public static void main(String[] args) {
        addTest();
    }

    /*
     * 添加Catagory
     */
    static void addTest() {
        SqlSessionFactory factory = MybstisSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        TestMapper catagoryOperation = sqlSession.getMapper(TestMapper.class);
        catagoryOperation.getDBInfo();

        sqlSession.commit();
            System.out.println("添加成功");

       sqlSession.close();
    }

}
