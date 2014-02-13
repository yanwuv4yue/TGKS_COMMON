package com.moemao.tgks.moecode.rule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.moemao.tgks.moecode.entity.Field;
import com.moemao.tgks.moecode.entity.Module;
import com.moemao.tgks.moecode.tool.Util;

public class WriteFileXml extends WriteFileJava
{
    private String lower = "";
    private String upper = "";
    
    public void write(Module module) throws IOException
    {
        //lower = Util.firstLowerCase(module.getModuleName());
        //upper = Util.firstUpperCase(module .getModuleName());
        lower = Util.firstLowerCaseUTF8(module.getModuleName());
        upper = Util.firstUpperCaseUTF8(module .getModuleName());
        
        writeMyBatis(module);
        writeWeb(module);
        writeSpring(module);
        writeSql(module);
        writeSqlMapper(module);
    }
    
    public void writeMyBatis(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }
        
        try
        {
            File path = new File("D:\\moecode\\xml\\");
            File file = new File("D:\\moecode\\xml\\myBatis-config.xml");

            if (!(path.exists()))
            {
                path.mkdirs();
            }

            if (!(file.exists()))
            {
                file.createNewFile();
            }

            this.fileWriter = new FileWriter(file);
            this.bufferedWriter = new BufferedWriter(this.fileWriter);

            this.bufferedWriter.write("<!-- " + module.getModuleTag().toLowerCase() + "_" + module.getModuleName().toLowerCase() + " -->");
            write("<typeAlias alias=\"" + upper + "Evt\" type=\"" + module.getPackagePach() + ".entity." + upper + "Evt\" />");
            write("<typeAlias alias=\"" + upper + "Req\" type=\"" + module.getPackagePach() + ".entity." + upper + "Req\" />");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public void writeWeb(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        String classPath = module.getPackagePach() + ".action." + upper + "Action";
        String tag = module.getModuleTag().toLowerCase();
        try
        {
            File path = new File("D:\\moecode\\xml\\");
            File file = new File("D:\\moecode\\xml\\" + tag + ".web.xml");

            if (!(path.exists()))
            {
                path.mkdirs();
            }

            if (!(file.exists()))
            {
                file.createNewFile();
            }

            this.fileWriter = new FileWriter(file);
            this.bufferedWriter = new BufferedWriter(this.fileWriter);

            this.bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            write("<!DOCTYPE struts PUBLIC ");
            write("    \"-//Apache Software Foundation//DTD Struts Configuration 2.1//EN\" ");
            write("    \"http://struts.apache.org/dtds/struts-2.1.dtd\">");
            
            write("<struts>");
            write("  <package namespace=\"/" + tag + "\" name=\"" + tag + "\" extends=\"struts-default\">");

            newLine();

            write("    <!-- " + tag + "_" + lower.toLowerCase() + " -->");
            write("    <action name=\"" + lower + "Manager\" class=\"" + classPath + "\" method=\"" + lower + "Manager\">");
            write("        <result name=\"success\">/WEB-INF/jsp/" + tag + "/" + lower.toLowerCase() + "/" + lower + "Manager.jsp</result>");
            write("        <result name=\"error\">/WEB-INF/jsp/common/error.jsp</result>");
            write("    </action>");
            newLine();
            write("    <action name=\"query" + upper + "\" class=\"" + classPath + "\" method=\"query" + upper + "\">");
            write("        <result name=\"success\">/WEB-INF/jsp/" + tag + "/" + lower.toLowerCase() + "/" + lower + "List.jsp</result>");
            write("        <result name=\"error\">/WEB-INF/jsp/common/error.jsp</result>");
            write("    </action>");
            newLine();
            write("    <action name=\"edit" + upper + "Page\" class=\"" + classPath + "\" method=\"edit" + upper + "Page\">");
            write("        <result name=\"success\">/WEB-INF/jsp/" + tag + "/" + lower.toLowerCase() + "/" + lower + "Edit.jsp</result>");
            write("        <result name=\"error\">/WEB-INF/jsp/common/error.jsp</result>");
            write("    </action>");
            newLine();
            write("    <action name=\"edit" + upper + "\" class=\"" + classPath + "\" method=\"edit" + upper + "\">");
            write("        <result name=\"success\">/WEB-INF/jsp/common/success.jsp</result>");
            write("        <result name=\"error\">/WEB-INF/jsp/common/error.jsp</result>");
            write("    </action>");
            newLine();
            write("    <action name=\"delete" + upper + "\" class=\"" + classPath + "\" method=\"delete" + upper + "\">");
            write("        <result name=\"success\">/WEB-INF/jsp/common/success.jsp</result>");
            write("        <result name=\"error\">/WEB-INF/jsp/common/error.jsp</result>");
            write("    </action>");

            newLine();

            write("  </package>");
            write("</struts>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public void writeSpring(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        String tag = module.getModuleTag().toLowerCase();
        String classPathAction = module.getPackagePach() + ".action." + upper + "Action";
        String classPathServiceImpl = module.getPackagePach() + ".service.impl." + upper + "ServiceImpl";
        String classPathDao = module.getPackagePach() + ".dao." + upper + "Dao";
        try
        {
            File path = new File("D:\\moecode\\xml\\");
            File file = new File("D:\\moecode\\xml\\" + module.getModuleTag().toLowerCase() + ".spring.xml");

            if (!(path.exists()))
            {
                path.mkdirs();
            }

            if (!(file.exists()))
            {
                file.createNewFile();
            }

            this.fileWriter = new FileWriter(file);
            this.bufferedWriter = new BufferedWriter(this.fileWriter);

            this.bufferedWriter
                    .write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

            write("<beans xmlns=\"http://www.springframework.org/schema/beans\"");
            write(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
            write(" xmlns:p=\"http://www.springframework.org/schema/p\" ");
            write(" xmlns:context=\"http://www.springframework.org/schema/context\" ");
            write(" xmlns:jee=\"http://www.springframework.org/schema/jee\" ");
            write(" xmlns:tx=\"http://www.springframework.org/schema/tx\" ");
            write(" xsi:schemaLocation=\"");
            write(" http://www.springframework.org/schema/beans ");
            write(" http://www.springframework.org/schema/beans/spring-beans-3.0.xsd");
            write(" http://www.springframework.org/schema/context ");
            write(" http://www.springframework.org/schema/context/spring-context-3.0.xsd");
            write(" http://www.springframework.org/schema/jee ");
            write(" http://www.springframework.org/schema/jee/spring-jee-3.0.xsd");
            write(" http://www.springframework.org/schema/tx ");
            write(" http://www.springframework.org/schema/tx/spring-tx-3.0.xsd\">");

            newLine();

            write("  <!-- " + module.getModuleName().toLowerCase() + "_dao 配置 -->");
            write("  <bean id=\"" + tag + "_" + lower + "Dao\" class=\"org.mybatis.spring.mapper.MapperFactoryBean\">");
            write("    <property name=\"mapperInterface\" value=\"" + classPathDao + "\" />");
            write("    <property name=\"sqlSessionFactory\" ref=\"sqlSessionFactory\" />");
            write("  </bean>");
            write("  <!-- " + module.getModuleName().toLowerCase() + "_service 配置 -->");
            write("  <bean id=\"" + tag + "_" + lower + "Service\" class=\"" + classPathServiceImpl + "\">");
            write("    <property name=\"" + tag + "_" + lower + "Dao\" ref=\"" + tag + "_" + lower + "Dao\" />");
            write("  </bean>");
            write("  <!-- " + module.getModuleName().toLowerCase() + "_action 配置 -->");
            write("  <bean id=\"" + tag + "_" + lower + "Action\" class=\"" + classPathAction + "\">");
            write("    <property name=\"" + tag + "_" + lower + "Service\" ref=\"" + tag + "_" + lower + "Service\" />");
            write("  </bean>");
            
            newLine();

            write("</beans>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public void writeSql(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }
        
        String tag = module.getModuleTag().toLowerCase();
        String classPathDao = module.getPackagePach() + ".dao." + upper + "Dao";
        String tableName = "t_tgks_" + tag + "_" + module.getModuleName().toLowerCase();
        
        String allTFields = "";
        String allFields = "";
        String allSharpFields = "";
        for (Field field : module.getFieldList())
        {
            allTFields += "t." + field.getFieldName().toLowerCase() + ", ";
            allFields += field.getFieldName().toLowerCase() + ", ";
            allSharpFields += "#{" + field.getFieldName() + "}, ";
        }
        allTFields = allTFields.trim();
        allTFields = allTFields.substring(0, allTFields.length() - 1);
        allFields = allFields.trim();
        allFields = allFields.substring(0, allFields.length() - 1);
        allSharpFields = allSharpFields.trim();
        allSharpFields = allSharpFields.substring(0, allSharpFields.length() - 1);

        try
        {
            File path = new File("D:\\moecode\\xml\\");
            File file = new File("D:\\moecode\\xml\\" + tag + "_" + lower.toLowerCase() + ".sql.xml");

            if (!(path.exists()))
            {
                path.mkdirs();
            }

            if (!(file.exists()))
            {
                file.createNewFile();
            }

            this.fileWriter = new FileWriter(file);
            this.bufferedWriter = new BufferedWriter(this.fileWriter);

            this.bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            write("<!DOCTYPE mapper PUBLIC ");
            write("  \"-//mybatis.org//DTD Mapper 3.0//EN\" ");
            write("  \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
            
            write("<mapper namespace=\"" + classPathDao + "\">");

            write("<select id=\"" + tag + "_query" + upper + "\" parameterType=\"" + upper + "Req\" resultType=\"" + upper + "Evt\" resultMap=\"" + upper + "EvtMap\">");
            write("        <![CDATA[  ");
            write("            SELECT " + allTFields + " FROM " + tableName + " t");
            write("        ]]>");
            write("        <where>");
            write("                1=1");
            for (Field f : module.getFieldList())
            {
                write("            <if test=\"" + f.getFieldName() + " !=null and " + f.getFieldName() + " !='' \">");
                write("                AND t." + f.getFieldName().toUpperCase() + " = #{" + f.getFieldName() + "}");
                write("            </if>");
            }
            write("        </where>");
            write("        <if test=\"sortSql !=null and sortSql !='' \">");
            write("            ORDER BY ${sortSql}");
            write("        </if>");
            write("</select>");

            newLine();
            
            write("<insert id=\"" + tag + "_add" + upper + "\" parameterType=\"" + upper + "Evt\">");
            write("        <![CDATA[  ");
            write("            INSERT INTO " + tableName + " (" + allFields + ") ");
            write("            VALUES (" + allSharpFields + ") ");
            write("        ]]>");
            write("</insert>");
            
            newLine();
            
            write("<update id=\"" + tag + "_update" + upper + "\" parameterType=\"" + upper + "Evt\">");
            write("        <![CDATA[  ");
            write("            UPDATE " + tableName + " SET ");
            for (int i = 2; i <= module.getFieldList().size(); i++)
            {
                Field field = module.getFieldList().get(i-1);
                if (i < module.getFieldList().size())
                {
                    write("                       " + field.getFieldName().toLowerCase() + " = #{" + field.getFieldName() + "},");
                }
                else
                {
                    write("                       " + field.getFieldName().toLowerCase() + " = #{" + field.getFieldName() + "}");
                }
            }
            write("             WHERE ID = #{id}");
            write("        ]]>");
            write("</update>");
            
            newLine();
            
            write("<delete id=\"" + tag + "_delete" + upper + "\" parameterType=\"list\">");
            write("        <![CDATA[  ");
            write("            DELETE FROM " + tableName + " WHERE id IN");
            write("        ]]>");
            write("        <foreach collection=\"list\" item=\"ids\"  open=\"(\" separator=\",\" close=\")\">");
            write("            #{ids}");
            write("        </foreach>");
            write("</delete>");
            
            write("</mapper>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
    }
    
    public void writeSqlMapper(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }
        
        String tag = module.getModuleTag().toLowerCase();
        String classPathDao = module.getPackagePach() + ".dao." + upper + "Dao";

        try
        {
            File path = new File("D:\\moecode\\xml\\");
            File file = new File("D:\\moecode\\xml\\" + tag + "_" + lower.toLowerCase() + ".mapper.xml");

            if (!(path.exists()))
            {
                path.mkdirs();
            }

            if (!(file.exists()))
            {
                file.createNewFile();
            }

            this.fileWriter = new FileWriter(file);
            this.bufferedWriter = new BufferedWriter(this.fileWriter);

            this.bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            write("<!DOCTYPE mapper PUBLIC ");
            write("  \"-//mybatis.org//DTD Mapper 3.0//EN\" ");
            write("  \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
            
            write("<mapper namespace=\"" + classPathDao + "\">");
            write("    <resultMap id=\"" + upper + "EvtMap\" type=\"" + upper + "Evt\">");
            for (Field field : module.getFieldList())
            {
                if ("id".equals(field.getFieldName()))
                {
                    write("        <id property=\"" + field.getFieldName() + "\" column=\"" + field.getFieldName().toUpperCase() + "\" />");
                }
                else
                {
                    write("        <result property=\"" + field.getFieldName() + "\" column=\"" + field.getFieldName().toUpperCase() + "\" />");
                }
            }
            write("    </resultMap>");
            write("</mapper>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
    }

    public void writeXXX(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        try
        {
            File path = new File("D:\\moecode\\xml\\");
            File file = new File("D:\\moecode\\xml\\dms."
                    + module.getModuleName().toLowerCase() + ".web" + ".xml");

            if (!(path.exists()))
            {
                path.mkdirs();
            }

            if (!(file.exists()))
            {
                file.createNewFile();
            }

            this.fileWriter = new FileWriter(file);
            this.bufferedWriter = new BufferedWriter(this.fileWriter);

            this.bufferedWriter.write("<");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close();
        }
    }
}
