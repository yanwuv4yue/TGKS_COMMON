package com.moemao.tgks.common.core.sql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class SqlSessionServiceTemplate
{
    private SqlSessionFactory sessionFactory = SessionFactory.getInstance().getSqlSessionFactory();
    
    public SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(this.sessionFactory);
}
