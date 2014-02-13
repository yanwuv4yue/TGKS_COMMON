package com.moemao.tgks.common.core.sql;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory
{
    // 这里的源路径没有意义
    private String resource = "com/moemao/sql/SqlMapper.xml";
    
    private SqlSessionFactory sqlSessionFactory = null;
    
    private static SessionFactory sessionFactory = new SessionFactory();
    
    private SessionFactory()
    {
        try
        {
            Reader reader = Resources.getResourceAsReader(this.resource);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException e)
        {
            System.out.println("SessionFactory IOException:" + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getInstance()
    {
        return sessionFactory;
    }
    
    public SqlSessionFactory getSqlSessionFactory()
    {
        return this.sqlSessionFactory;
    }
}
