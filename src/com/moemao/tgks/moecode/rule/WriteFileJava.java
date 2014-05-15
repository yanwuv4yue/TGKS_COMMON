package com.moemao.tgks.moecode.rule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.moemao.tgks.moecode.entity.Field;
import com.moemao.tgks.moecode.entity.Module;
import com.moemao.tgks.moecode.main.WriteFile;
import com.moemao.tgks.moecode.tool.Util;

public class WriteFileJava extends WriteFile
{
    private String lower = "";
    private String upper = "";
    
    public void write(Module module) throws IOException
    {
        //lower = Util.firstLowerCase(module.getModuleName());
        //upper = Util.firstUpperCase(module .getModuleName());
        lower = Util.firstLowerCaseUTF8(module.getModuleName());
        upper = Util.firstUpperCaseUTF8(module .getModuleName());
        
        writeEvt(module);
        writeReq(module);
        writeAction(module);
        writeSpring(module);
        writeServiceImpl(module);
        writeDao(module);
        //writeDaoImpl(module);
    }

    public void writeEvt(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        try
        {
            File path = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "entity\\");
            File file = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "entity\\"
                    + upper + "Evt" + ".java");

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

            List<Field> list = module.getFieldList();

            writeOn("package " + module.getPackagePach() + ".entity" + ";");
            newLine();
            write("public class " + module.getModuleName() + "Evt");
            write("{");
            
            for (Field field : list)
            {
                comment(field.getFieldComment());
                write("private " + field.getFieldType() + " " + field.getFieldName() + ";");
                newLine();
            }

            for (Field field : list)
            {
                comment("@return 返回 " + field.getFieldName());
                write("public " + field.getFieldType() + " get"
                        + Util.firstUpperCase(field.getFieldName())
                        + "()");
                write("{");
                write("    return " + field.getFieldName() + ";");
                write("}");
                newLine();

                comment("@param 对" + field.getFieldName() + "进行赋值");
                write("public void set"
                        + Util.firstUpperCase(field.getFieldName()) + "("
                        + field.getFieldType() + " " + field.getFieldName()
                        + ")");
                write("{");
                write("    this." + field.getFieldName() + " = "
                        + field.getFieldName() + ";");
                write("}");
                newLine();
            }

            write("}");
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

    public void writeReq(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        try
        {
            File path = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "entity\\");
            File file = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "entity\\"
                    + upper + "Req" + ".java");

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

            writeOn("package " + module.getPackagePach() + ".entity" + ";");
            newLine();
            write("public class " + module.getModuleName() + "Req extends " + module.getModuleName() + "Evt");
            write("{");
            
            newLine();
            
            comment("排序字段");
            write("private String sortSql;");
            
            newLine();
            
            comment("@return 返回 排序字段");
            write("public String getSortSql()");
            write("{");
            write("    return this.sortSql;");
            write("}");
            newLine();

            comment("@param 对排序字段进行赋值");
            write("public void setSortSql(String sortSql)");
            write("{");
            write("    this.sortSql = sortSql;");
            write("}");
            newLine();
            write("}");
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

    public void writeRes(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        try
        {
            File path = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\" + "entity\\");
            File file = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\" + "entity\\"
                    + upper + "Res"
                    + ".java");

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

            List<Field> list = new ArrayList<Field>();

            Field tempField = new Field();
            tempField.setFieldName(lower + "List");
            tempField.setFieldType("List<" + module.getModuleName() + "Evt>");
            tempField.setFieldComment("查询结果集");
            list.add(tempField);

            writeOn("package " + module.getPackagePach() + ".entity" + ";");
            newLine();

            write("import java.util.ArrayList;");
            write("import java.util.List;");
            newLine();

            write("public class " + module.getModuleName() + "Res");
            write("{");
            
            for (Field field: list)
            {
                comment(field.getFieldComment());
                write("private " + field.getFieldType() + " "
                        + field.getFieldName() + ";");
                newLine();
            }

            for (Field field: list)
            {
                comment("@return 返回 " + field.getFieldName());
                write("public " + field.getFieldType() + " get"
                        + Util.firstUpperCase(field.getFieldName())
                        + "()");
                write("{");
                write("    return " + field.getFieldName() + ";");
                write("}");
                newLine();

                comment("@param 对" + field.getFieldName() + "进行赋值");
                write("public void set"
                        + Util.firstUpperCase(field.getFieldName()) + "("
                        + field.getFieldType() + " " + field.getFieldName()
                        + ")");
                write("{");
                write("    this." + field.getFieldName() + " = "
                        + field.getFieldName() + ";");
                write("}");
                newLine();
            }

            write("}");
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

    public void writeAction(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        String moduleTag = module.getModuleTag().toLowerCase();
        String moduleService = moduleTag + "_" + lower + "Service";
        String moduleServiceType = upper + "Service";
        String moduleList = "list"; //lower + "List";
        String moduleListType = "List<" + module.getModuleName() + "Evt" + ">";
        //String moduleRes = lower + "Res";
        //String moduleResType = upper + "Res";
        String moduleEvt = lower + "Evt";
        String moduleEvtType = upper + "Evt";
        String moduleReq = lower + "Req";
        String moduleReqType = upper + "Req";
        String moduleId = ((Field) module.getFieldList().get(0)).getFieldName();
        String moduleIds = ((Field) module.getFieldList().get(0)).getFieldName() + "s";
        
        try
        {
            File path = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\" + "action\\");
            File file = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\" + "action\\"
                    + upper
                    + "Action" + ".java");

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

            List<Field> list = new ArrayList<Field>();

            Field tempField = new Field();
            tempField.setFieldName(moduleService);
            tempField.setFieldType(moduleServiceType);
            tempField.setFieldComment(module.getModuleName() + "业务接口");
            list.add(tempField);

            tempField = new Field();
            tempField.setFieldName(moduleList);
            tempField.setFieldType(moduleListType);
            tempField.setFieldComment("查询结果集");
            list.add(tempField);

            /*
            tempField = new Field();
            tempField.setFieldName(moduleRes);
            tempField.setFieldType(moduleResType);
            tempField.setFieldComment(module.getModuleName() + "Res对象");
            list.add(tempField);
            */

            tempField = new Field();
            tempField.setFieldName(moduleEvt);
            tempField.setFieldType(moduleEvtType);
            tempField.setFieldComment(module.getModuleName() + "Evt对象");
            list.add(tempField);

            tempField = new Field();
            tempField.setFieldName(moduleReq);
            tempField.setFieldType(moduleReqType);
            tempField.setFieldComment(module.getModuleName() + "查询条件封装对象");
            list.add(tempField);
            
            /*
            list.add((Field) module.getFieldList().get(0));

            tempField = new Field();
            tempField.setFieldName(((Field) module.getFieldList().get(0)).getFieldName() + "s");
            tempField.setFieldType(((Field) module.getFieldList().get(0)).getFieldType() + "[]");
            tempField.setFieldComment(((Field) module.getFieldList().get(0)).getFieldComment());
            list.add(tempField);
            */
            
            writeOn("package " + module.getPackagePach() + ".action" + ";");
            newLine();

            write("import java.util.ArrayList;");
            write("import java.util.List;");
            newLine();
            
            write("import org.apache.commons.logging.Log;");
            write("import org.apache.commons.logging.LogFactory;");
            
            newLine();

            //write("import " + module.getPackagePach() + ".entity" + "." + moduleResType + ";");
            write("import " + module.getPackagePach() + ".entity" + "." + moduleEvtType + ";");
            write("import " + module.getPackagePach() + ".entity" + "." + moduleReqType + ";");
            write("import " + module.getPackagePach() + ".service" + "." + moduleServiceType + ";");
            write("import com.moemao.tgks.common.core.action.TGKSAction;");
            newLine();
            
            write("import com.moemao.tgks.common.tool.CommonConstant;");
            write("import com.moemao.tgks.common.tool.CommonUtil;");
            write("import com.moemao.tgks.common.tool.StringUtil;");
            newLine();

            write("public class " + module.getModuleName() + "Action extends TGKSAction");
            write("{");
            newLine();
            
            write("private static Log logger = LogFactory.getLog(" + upper + "Action.class);");
            newLine();
            
            writeVar(list);
            
            write("public String " + lower + "Manager()");
            write("{");

            write("return SUCCESS;");
            write("}");
            newLine();

            write("public String query" + upper + "()");
            write("{");
            write(moduleList + " = " + moduleService + ".query" + upper + "(" + moduleReq + ");");
            write("return SUCCESS;");
            write("}");
            newLine();

            write("public String edit" + upper + "Page" + "()");
            write("{");
            write("String " + moduleId + " = this.getRequest().getParameter(\"" + moduleId + "\");");
            write("if (!CommonUtil.isEmpty(" + moduleId + "))");
            write("{");
            write(moduleEvt + " = " + moduleService + ".query" + upper + "ById(" + moduleId + ");");
            write("}");
            write("return SUCCESS;");
            write("}");
            newLine();

            write("public String edit" + upper + "()");
            write("{");
            write("CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, \"" + upper + "Action.update" + upper + "\");");
            write("int result = 0;");
            write("if (CommonUtil.isEmpty(" + moduleEvt + ".get" + Util.firstUpperCase(moduleId) + "()))");
            write("{");
            write("result = " +moduleService + ".add" + upper + "(" + moduleEvt + ");");
            write("}");
            write("else");
            write("{");
            write("result = " +moduleService + ".update" + upper + "(" + moduleEvt + ");");
            write("}");
            write("CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));");
            write("CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, \"" + upper + "Action.update" + upper + "\");");
            write("return SUCCESS;");
            write("}");
            newLine();

            write("public String delete" + upper + "()");
            write("{");
            write("CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, \"" + upper + "Action.delete" + upper + "\");");
            write("String " + moduleIds + " = this.getRequest().getParameter(\"" + moduleIds + "\");");
            write("int result = " +moduleService + ".delete" + upper + "(CommonUtil.stringToList(" + moduleIds + "));");
            write("CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));");
            write("CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, \"" + upper + "Action.delete" + upper + "\");");
            write("return SUCCESS;");
            write("}");
            newLine();

            writeGetSet(list);

            write("}");
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

        String moduleEvt = lower + "Evt";
        String moduleEvtType = upper + "Evt";
        String moduleReq = lower + "Req";
        String moduleReqType = upper + "Req";
        String moduleId = ((Field) module.getFieldList().get(0)).getFieldName();
        String moduleIds = ((Field) module.getFieldList().get(0)).getFieldName() + "s";
        try
        {
            File path = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "service\\");
            File file = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "service\\"
                    + upper + "Service" + ".java");

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

            writeOn("package " + module.getPackagePach() + ".service" + ";");
            newLine();

            write("import " + module.getPackagePach() + ".entity" + "." + moduleEvtType + ";");
            write("import " + module.getPackagePach() + ".entity" + "." + moduleReqType + ";");
            newLine();

            write("public interface " + module.getModuleName() + "Service");
            write("{");

            write("public List<" + moduleEvtType + "> query" + upper + "(" + moduleReqType + " " + moduleReq + ");");
            newLine();

            write("public " + moduleEvtType + " " + "query" + upper + "ById" + "(String " + moduleId + ");");
            newLine();

            write("public int add" + upper + "(" + moduleEvtType + " " + moduleEvt + ");");
            newLine();

            write("public int update" + upper + "(" + moduleEvtType + " " + moduleEvt + ");");
            newLine();

            write("public int delete" + upper + "(List<String> " + moduleIds + ");");
            newLine();

            write("}");
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

    public void writeServiceImpl(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }
        
        String moduleList = lower + "List";
        String moduleDao = module.getModuleTag() + "_" + lower + "Dao";
        String moduleDaoType = upper + "Dao";
        String moduleServiceType = upper + "Service";
        String moduleEvt = lower + "Evt";
        String moduleEvtType = upper + "Evt";
        String moduleReq = lower + "Req";
        String moduleReqType = upper + "Req";
        String moduleId = ((Field) module.getFieldList().get(0)).getFieldName();
        String moduleIds = ((Field) module.getFieldList().get(0)).getFieldName() + "s";
        String moduleTag = module.getModuleTag();
        
        try
        {
            File path = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "service\\impl\\");
            File file = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\"
                    + "service\\impl\\" + upper + "ServiceImpl" + ".java");

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

            List<Field> list = new ArrayList<Field>();

            Field tempField = new Field();
            tempField.setFieldName(moduleDao);
            tempField.setFieldType(moduleDaoType);
            tempField.setFieldComment(module.getModuleName() + "Dao");
            list.add(tempField);

            writeOn("package " + module.getPackagePach() + ".service.impl"+ ";");
            newLine();

            write("import " + module.getPackagePach() + ".entity" + "."+ moduleEvtType + ";");
            write("import " + module.getPackagePach() + ".entity" + "."+ moduleReqType + ";");
            write("import " + module.getPackagePach() + ".dao" + "." + moduleDaoType + ";");
            write("import " + module.getPackagePach() + ".service" + "." + moduleServiceType + ";");
            newLine();

            write("public class " + module.getModuleName() + "ServiceImpl" + " implements " + module.getModuleName() + "Service");
            write("{");

            writeVar(list);

            write("public List<" + moduleEvtType + "> query" + upper + "("
                    + moduleReqType + " " + moduleReq + ")");
            write("{");
            write("if (CommonUtil.isEmpty(" + moduleReq + ".getSortSql()))");
            write("{");
            write(moduleReq + ".setSortSql(\" t." + moduleId.toUpperCase() + " DESC\");");
            write("}");
            write("return " + moduleDao + "." + moduleTag + "_query"
                    + upper + "("
                    + moduleReq + ");");
            write("}");
            newLine();

            write("public " + moduleEvtType + " " + "query"
                    + upper
                    + "ById" + "(String " + moduleId + ")");
            write("{");
            write(moduleReqType + " " + moduleReq + " = new "
                    + moduleReqType + "();");
            write(moduleReq
                    + "."
                    + "set"
                    + Util.firstUpperCase(moduleId) + "(" + moduleId + ");");
            write(moduleEvtType + " " + moduleEvt + " = null;");
            write("List<" + moduleEvtType + "> " + moduleList + " = " + moduleDao + "."
                    + moduleTag + "_query"
                    + upper + "("
                    + moduleReq + ");");
            write("if (!CommonUtil.isEmpty(" + moduleList + "))");
            write("{");
            write(moduleEvt + " = " + moduleList + ".get(0);");
            write("}");
            write("return " + moduleEvt + ";");
            write("}");
            newLine();

            write("public int add"
                    + upper + "("
                    + moduleEvtType + " " + moduleEvt + ")");
            write("{");
            write(moduleEvt + ".setId(" + Util.firstUpperCase(moduleTag) + "Util.createUniqueID());");
            write("return " + moduleDao + "." + moduleTag + "_add"
                    + upper + "("
                    + moduleEvt + ");");
            write("}");
            newLine();

            write("public int update"
                    + upper + "("
                    + moduleEvtType + " " + moduleEvt + ")");
            write("{");
            write("return " + moduleDao + "." + moduleTag + "_update"
                    + upper + "("
                    + moduleEvt + ");");
            write("}");
            newLine();

            write("public int delete"
                    + upper
                    + "(List<String> " + moduleIds + ")");
            write("{");
            write("return " + moduleDao + "." + moduleTag + "_delete"
                    + upper
                    + "(" + moduleIds + ");");
            write("}");
            newLine();

            writeGetSet(list);

            write("}");
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

    public void writeDao(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        String moduleEvt = lower + "Evt";
        String moduleEvtType = upper + "Evt";
        String moduleReq = lower + "Req";
        String moduleReqType = upper + "Req";
        String moduleTag = module.getModuleTag().toLowerCase();
        
        try
        {
            File path = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "dao\\");
            File file = new File("D:\\moecode\\java\\" + module.getModuleName().toLowerCase() + "\\" + "dao\\"
                    + upper + "Dao" + ".java");

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

            writeOn("package " + module.getPackagePach() + ".dao" + ";");
            newLine();

            write("import java.util.List;");
            write("import org.springframework.dao.DataAccessException;");
            write("import com.moemao.tgks.common.core.dao.TGKSDao;");
            write("import " + module.getPackagePach() + ".entity" + "." + moduleEvtType + ";");
            write("import " + module.getPackagePach() + ".entity" + "." + moduleReqType + ";");
            
            newLine();

            write("public interface " + module.getModuleName() + "Dao extends TGKSDao");
            write("{");

            write("public List<" + moduleEvtType + "> " + moduleTag + "_query"
                    + upper + "("
                    + moduleReqType + " " + moduleReq + ") throws DataAccessException;");
            newLine();

            write("public int " + moduleTag + "_add"
                    + upper + "("
                    + moduleEvtType + " " + moduleEvt + ") throws DataAccessException;");
            newLine();

            write("public int " + moduleTag + "_update"
                    + upper + "("
                    + moduleEvtType + " " + moduleEvt + ") throws DataAccessException;");
            newLine();

            write("public int " + moduleTag + "_delete"
                    + upper + "(List<String> list) throws DataAccessException;");

            write("}");
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

    public void writeDaoImpl(Module module) throws IOException
    {
        if (Util.isEmpty(module))
        {
            return;
        }

        String moduleDaoType = upper + "Dao";
        String moduleList = lower + "List";
        String moduleListType = "List<" + module.getModuleName() + "Evt" + ">";
        String moduleRes = lower + "Res";
        String moduleResType = upper + "Res";
        String moduleEvt = lower + "Evt";
        String moduleEvtType = upper + "Evt";
        String moduleQueryEvt = lower + "QueryEvt";
        String moduleQueryEvtType = upper + "QueryEvt";
        String moduleId = ((Field) module.getFieldList().get(0)).getFieldName();
        String moduleSqlPre = "p_dms_" + module.getModuleName().toLowerCase();
        try
        {
            File path = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\"
                    + "dao\\impl\\");
            File file = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\"
                    + "dao\\impl\\"
                    + upper
                    + "DaoImpl" + ".java");

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

            writeOn("package " + module.getPackagePach() + ".dao.impl" + ";");
            newLine();

            write("import java.util.ArrayList;");
            write("import java.util.List;");
            newLine();

            write("import com.huawei.bme.commons.util.debug.DebugLog;");
            write("import com.huawei.bme.commons.util.debug.LogFactory;");
            write("import com.huawei.bme.das.CmdRequest;");
            write("import com.huawei.bme.das.DASCommand;");
            write("import com.huawei.bme.das.DASCommandFactory;");
            write("import com.huawei.bme.das.DataParam;");
            write("import com.huawei.bme.das.DataResult;");
            write("import com.huawei.bme.das.DataSet;");
            write("import com.huawei.bme.das.DataType;");
            write("import com.huawei.imp.commons.tool.Log;");
            write("import " + module.getPackagePach() + ".entity" + "."
                    + moduleResType + ";");
            write("import " + module.getPackagePach() + ".entity" + "."
                    + moduleEvtType + ";");
            write("import " + module.getPackagePach() + ".entity" + "."
                    + moduleQueryEvtType + ";");
            write("import " + module.getPackagePach() + ".dao" + "."
                    + moduleDaoType + ";");
            write("import com.huawei.imp.commons.exception.DBException;");
            newLine();

            write("public class " + module.getModuleName() + "DaoImpl"
                    + " implements " + module.getModuleName() + "Dao");
            write("{");

            comment("调测日志");
            write("private static DebugLog debugLog = LogFactory.getDebugLog("
                    + module.getModuleName() + "DaoImpl" + ".class);");
            newLine();

            write("public " + moduleResType + " " + "query"
                    + upper + "("
                    + moduleQueryEvtType + " " + moduleQueryEvt
                    + ") throws DBException");
            write("{");

            write(moduleResType + " " + moduleRes + " = new " + moduleResType
                    + "();");
            write(moduleEvtType + " " + moduleEvt + " = null;");
            write(moduleListType + " " + moduleList + " = null;");

            write("DASCommand dasCmd = DASCommandFactory.getDASCommand();");
            write("CmdRequest cmdRequest = new CmdRequest();");
            newLine();

            write("cmdRequest.setNamingLabel(\"" + moduleSqlPre + "_query\");");
            
            for (Field field : module.getFieldList())
            {
                write("cmdRequest.addDataParam(\"i_" + field.getFieldName()
                        + "\", DataType." + field.getFieldType().toUpperCase()
                        + ", " + moduleQueryEvt + ".get"
                        + Util.firstUpperCase(field.getFieldName())
                        + "(), DataParam.PARAM_TYPE_IN);");
            }

            write("cmdRequest.addDataParam(\"o_result\", DataType.INT, null, DataParam.PARAM_TYPE_OUT);");
            write("cmdRequest.addDataParam(\"cur_result\", DataType.CURSOR, null, DataParam.PARAM_TYPE_OUT);");
            newLine();

            write("DataResult dataResult = null;");
            write("int result = 0;");
            newLine();

            write("try");
            write("{");
            write("dataResult = dasCmd.execute(cmdRequest);");
            write("if (null != dataResult);");
            write("{");
            write("List<DataParam> params = dataResult.getOutParams();");
            write("if (null != params)");
            write("{");
            write("DataParam param = params.get(0);");
            write("result = param.getInt();");
            write("if (1 == result)");
            write("{");
            write(moduleRes + ".setResult(\"SUCCESS\");");
            write("}");
            write("}");
            write("DataSet sets = dataResult.getDataSet();");
            write("if (sets != null)");
            write("{");
            write(moduleList + " = new Array" + moduleListType + "();");
            write("while (sets.next())");
            write("{");
            write(moduleEvt + " = new " + moduleEvtType + "();");
            for (Field field : module.getFieldList())
            {
                write(moduleEvt + ".set"
                        + Util.firstUpperCase(field.getFieldName())
                        + "(sets.get"
                        + Util.firstUpperCase(field.getFieldType())
                        + "(\"" + field.getFieldName() + "\"));");
            }
            write(moduleList + ".add(" + moduleEvt + ");");
            write("}");
            write(moduleRes + ".setReturnObject(" + moduleList + ");");
            write(moduleRes + ".set" + Util.firstUpperCase(moduleList)
                    + "(" + moduleList + ");");
            write("}");
            write("}");
            write("}");
            write("catch (Exception e)");
            write("{");
            write(moduleRes + ".setResult(\"ERROR\");");
            write("Log.warn(\"error\", e);");
            write("throw new DBException(null);");
            write("}");
            write("finally");
            write("{");
            write("if (null != dataResult)");
            write("{");
            write("dataResult.close();");
            write("}");
            write("}");

            write("return " + moduleRes + ";");
            write("}");
            newLine();

            write("public Integer add"
                    + upper + "("
                    + moduleEvtType + " " + moduleEvt + ") throws DBException");
            write("{");
            write("DASCommand dasCmd = DASCommandFactory.getDASCommand();");
            write("CmdRequest cmdRequest = new CmdRequest();");
            newLine();

            write("cmdRequest.setNamingLabel(\"" + moduleSqlPre + "_add\");");

            for (Field field : module.getFieldList())
            {
                write("cmdRequest.addDataParam(\"i_" + field.getFieldName()
                        + "\", DataType." + field.getFieldType().toUpperCase()
                        + ", " + moduleEvt + ".get"
                        + Util.firstUpperCase(field.getFieldName())
                        + "(), DataParam.PARAM_TYPE_IN);");
            }

            write("cmdRequest.addDataParam(\"o_result\", DataType.INT, null, DataParam.PARAM_TYPE_OUT);");
            newLine();

            write("DataResult dataResult = null;");
            write("int result = 0;");
            newLine();

            write("try");
            write("{");
            write("dataResult = dasCmd.execute(cmdRequest);");
            write("if (null != dataResult);");
            write("{");
            write("List<DataParam> params = dataResult.getOutParams();");
            write("if (null != params)");
            write("{");
            write("DataParam param = params.get(0);");
            write("result = param.getInt();");
            write("}");
            write("}");
            write("}");
            write("catch (Exception e)");
            write("{");
            write("Log.warn(\"error\", e);");
            write("throw new DBException(null);");
            write("}");
            write("finally");
            write("{");
            write("if (null != dataResult)");
            write("{");
            write("dataResult.close();");
            write("}");
            write("}");

            write("return result;");
            write("}");
            newLine();

            write("public Integer update"
                    + upper + "("
                    + moduleEvtType + " " + moduleEvt + ") throws DBException");
            write("{");
            write("DASCommand dasCmd = DASCommandFactory.getDASCommand();");
            write("CmdRequest cmdRequest = new CmdRequest();");
            newLine();

            write("cmdRequest.setNamingLabel(\"" + moduleSqlPre + "_update\");");

            for (Field field : module.getFieldList())
            {
                write("cmdRequest.addDataParam(\"i_" + field.getFieldName()
                        + "\", DataType." + field.getFieldType().toUpperCase()
                        + ", " + moduleEvt + ".get"
                        + Util.firstUpperCase(field.getFieldName())
                        + "(), DataParam.PARAM_TYPE_IN);");
            }

            write("cmdRequest.addDataParam(\"o_result\", DataType.INT, null, DataParam.PARAM_TYPE_OUT);");
            newLine();

            write("DataResult dataResult = null;");
            write("int result = 0;");
            newLine();

            write("try");
            write("{");
            write("dataResult = dasCmd.execute(cmdRequest);");
            write("if (null != dataResult);");
            write("{");
            write("List<DataParam> params = dataResult.getOutParams();");
            write("if (null != params)");
            write("{");
            write("DataParam param = params.get(0);");
            write("result = param.getInt();");
            write("}");
            write("}");
            write("}");
            write("catch (Exception e)");
            write("{");
            write("Log.warn(\"error\", e);");
            write("throw new DBException(null);");
            write("}");
            write("finally");
            write("{");
            write("if (null != dataResult)");
            write("{");
            write("dataResult.close();");
            write("}");
            write("}");

            write("return result;");
            write("}");
            newLine();

            write("public Integer delete"
                    + upper + "("
                    + moduleQueryEvtType + " " + moduleQueryEvt
                    + ") throws DBException");
            write("{");
            write("DASCommand dasCmd = DASCommandFactory.getDASCommand();");
            write("CmdRequest cmdRequest = new CmdRequest();");
            newLine();

            write("cmdRequest.setNamingLabel(\"" + moduleSqlPre + "_delete\");");

            for (Field field : module.getFieldList())
            {
                write("cmdRequest.addDataParam(\"i_" + field.getFieldName()
                        + "\", DataType." + field.getFieldType().toUpperCase()
                        + ", " + moduleQueryEvt + ".get"
                        + Util.firstUpperCase(field.getFieldName())
                        + "(), DataParam.PARAM_TYPE_IN);");
            }

            write("cmdRequest.addDataParam(\"o_result\", DataType.INT, null, DataParam.PARAM_TYPE_OUT);");
            newLine();

            write("DataResult dataResult = null;");
            write("int result = 0;");
            newLine();

            write("try");
            write("{");
            write("dataResult = dasCmd.execute(cmdRequest);");
            write("if (null != dataResult);");
            write("{");
            write("List<DataParam> params = dataResult.getOutParams();");
            write("if (null != params)");
            write("{");
            write("DataParam param = params.get(0);");
            write("result = param.getInt();");
            write("}");
            write("}");
            write("}");
            write("catch (Exception e)");
            write("{");
            write("Log.warn(\"error\", e);");
            write("throw new DBException(null);");
            write("}");
            write("finally");
            write("{");
            write("if (null != dataResult)");
            write("{");
            write("dataResult.close();");
            write("}");
            write("}");

            write("return result;");
            write("}");
            newLine();

            write("public Integer delete"
                    + upper
                    + "ById" + "(String " + moduleId + ") throws DBException");
            write("{");
            write("DASCommand dasCmd = DASCommandFactory.getDASCommand();");
            write("CmdRequest cmdRequest = new CmdRequest();");
            newLine();

            write("cmdRequest.setNamingLabel(\"" + moduleSqlPre + "_delete\");");

            write("cmdRequest.addDataParam(\"i_"
                    + ((Field) module.getFieldList().get(0)).getFieldName()
                    + "\", DataType."
                    + ((Field) module.getFieldList().get(0)).getFieldType()
                            .toUpperCase()
                    + ", "
                    + Util.firstLowerCase(((Field) module.getFieldList()
                            .get(0)).getFieldName())
                    + ", DataParam.PARAM_TYPE_IN);");

            write("cmdRequest.addDataParam(\"o_result\", DataType.INT, null, DataParam.PARAM_TYPE_OUT);");
            newLine();

            write("DataResult dataResult = null;");
            write("int result = 0;");
            newLine();

            write("try");
            write("{");
            write("dataResult = dasCmd.execute(cmdRequest);");
            write("if (null != dataResult);");
            write("{");
            write("List<DataParam> params = dataResult.getOutParams();");
            write("if (null != params)");
            write("{");
            write("DataParam param = params.get(0);");
            write("result = param.getInt();");
            write("}");
            write("}");
            write("}");
            write("catch (Exception e)");
            write("{");
            write("Log.warn(\"error\", e);");
            write("throw new DBException(null);");
            write("}");
            write("finally");
            write("{");
            write("if (null != dataResult)");
            write("{");
            write("dataResult.close();");
            write("}");
            write("}");

            write("return result;");
            write("}");
            newLine();

            write("}");
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
            File path = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\" + "action\\");
            File file = new File("D:\\moecode\\java\\"
                    + module.getModuleName().toLowerCase() + "\\" + "action\\"
                    + upper
                    + "Action" + ".java");

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

            writeOn("package " + module.getPackagePach() + ".action" + ";");
            newLine();

            write("public class " + module.getModuleName() + "Action");
            write("{");

            write("}");
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

    public void comment(String str) throws IOException
    {
        write("/**");
        write(" * " + str);
        write(" */");
    }

    public void writeVar(List<Field> list) throws IOException
    {
        for (Field field : list)
        {
            comment(field.getFieldComment());
            write("private " + field.getFieldType() + " "
                    + field.getFieldName() + ";");
            newLine();
        }
    }

    public void writeGetSet(List<Field> list) throws IOException
    {
        for (Field field : list)
        {
            comment("@return 返回 " + field.getFieldName());
            write("public " + field.getFieldType() + " get"
                    + Util.firstUpperCase(field.getFieldName()) + "()");
            write("{");
            write("    return " + field.getFieldName() + ";");
            write("}");
            newLine();

            comment("@param 对" + field.getFieldName() + "进行赋值");
            write("public void set"
                    + Util.firstUpperCase(field.getFieldName()) + "("
                    + field.getFieldType() + " " + field.getFieldName() + ")");
            write("{");
            write("    this." + field.getFieldName() + " = "
                    + field.getFieldName() + ";");
            write("}");
            newLine();
        }
    }
}
