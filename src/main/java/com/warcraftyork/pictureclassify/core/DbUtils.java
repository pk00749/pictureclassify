package com.warcraftyork.pictureclassify.core;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbUtils {
    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        if( sqlSessionFactory == null ) {
            synchronized (DbUtils.class) {
                if(sqlSessionFactory == null ) {
                    sqlSessionFactory = setSqlSessionFactory();
                }
            }
        }
        return sqlSessionFactory;
    }

    private static SqlSessionFactory setSqlSessionFactory()
    {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}
