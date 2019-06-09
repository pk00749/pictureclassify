package com.warcraftyork.pictureclassify.core;

import com.warcraftyork.pictureclassify.bean.DBInfo;
import com.warcraftyork.pictureclassify.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
public class HelloWorldApplication {
    @RequestMapping(value = "/sayHello")
    @ResponseBody
    public String sayHello(String name){
        SqlSessionFactory factory = DbUtils.obtionSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        DBInfo info = testMapper.getDBInfo();
        try {
            System.out.println(info.getHost() + " " + info.getDb() + " " + info.getUser());
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return "Hello, " + info.getHost() + " " + info.getDb() + " " + info.getUser();
    }

    public static void main(String[] args){
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
