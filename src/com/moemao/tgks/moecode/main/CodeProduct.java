package com.moemao.tgks.moecode.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.moemao.tgks.common.tool.StringUtil;
import com.moemao.tgks.moecode.entity.Field;
import com.moemao.tgks.moecode.entity.Module;
import com.moemao.tgks.moecode.rule.WriteFileJava;
import com.moemao.tgks.moecode.rule.WriteFileXml;
import com.moemao.tgks.moecode.tool.TypeUtil;

public class CodeProduct
{
    private CodeProduct codeProduct;

    private Module module;

    private List<Field> fieldList;

    private List<Field> fieldQueryList;

    private int lineNum = 0;

    private FileReader fileReader;

    private BufferedReader bufferedReader;

    public CodeProduct getInstance()
    {
        if (this.codeProduct == null)
        {
            this.codeProduct = new CodeProduct();
        }

        return this.codeProduct;
    }

    public Module readFile(String fileUrl) throws IOException
    {
        this.fieldList = new ArrayList<Field>();
        this.fieldQueryList = new ArrayList<Field>();
        this.module = new Module();
        try
        {
            File file = new File(fileUrl);
            this.fileReader = new FileReader(file);
            this.bufferedReader = new BufferedReader(this.fileReader);

            String lineStr = this.bufferedReader.readLine();

            this.lineNum = 0;

            while (StringUtil.isNotEmpty(lineStr))
            {
                String[] strs;
                if (this.lineNum == 0)
                {
                    strs = lineStr.split(",");

                    if (strs.length > 0)
                    {
                        // 如果UTF-8格式发现模块名前面有个看不见的空格，试试去掉一位
                        this.module.setModuleName(strs[0].trim());
                    }

                    if (strs.length > 1)
                    {
                        this.module.setPackagePach(strs[1]);
                    }
                    
                    if (strs.length > 2)
                    {
                        this.module.setModuleTag(strs[2]);
                        
                        this.module.setModuleTableName("T_TGKS_" + strs[2].toUpperCase()
                                + strs[0].toUpperCase());
                    }

                    if (strs.length > 3)
                    {
                        this.module.setTableSpaceName(strs[3]);
                    }
                }
                else if (this.lineNum > 0)
                {
                    Field field = new Field();

                    strs = lineStr.split(",");

                    if (strs.length > 0)
                    {
                        field.setFieldName(strs[0].trim());
                    }

                    if (strs.length > 1)
                    {
                        field.setFieldType(TypeUtil.getFieldType(strs[1]
                                .trim()));
                        field.setFieldTableType(TypeUtil
                                .getFieldTableType(strs[1].trim()));
                        field.setFieldJdbcType(TypeUtil
                                .getFieldJdbcType(strs[1].trim()));
                    }

                    if (strs.length > 2)
                    {
                        field.setFieldLength(Integer.parseInt(strs[2].trim()));
                    }

                    if (strs.length > 3)
                    {
                        field.setFieldComment(strs[3].trim());
                    }

                    this.fieldList.add(field);
                }

                this.lineNum += 1;
                lineStr = this.bufferedReader.readLine();
            }

            this.module.setFieldList(this.fieldList);

            this.fieldQueryList.addAll(this.fieldList);

            Field tempField = new Field();
            tempField.setFieldName("beginRowNum");
            tempField.setFieldType("int");
            tempField.setFieldComment("起始页码");
            this.fieldQueryList.add(tempField);

            tempField = new Field();
            tempField.setFieldName("endRowNum");
            tempField.setFieldType("int");
            tempField.setFieldComment("结束页码");
            this.fieldQueryList.add(tempField);

            this.module.setFieldQueryList(this.fieldQueryList);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            this.fileReader.close();
            this.bufferedReader.close();
        }

        return this.module;
    }

    public void writeFile() throws IOException
    {
        WriteFile writeFile = new WriteFileJava();
        writeFile.write(this.module);

        writeFile = new WriteFileXml();
        writeFile.write(this.module);

        //writeFile = new WriteFileSql();
        //writeFile.write(this.module);

        //writeFile = new WriteFileJsp();
        //writeFile.write(this.module);
    }

    public CodeProduct getCodeProduct()
    {
        return this.codeProduct;
    }

    public void setCodeProduct(CodeProduct codeProduct)
    {
        this.codeProduct = codeProduct;
    }

    public Module getModule()
    {
        return this.module;
    }

    public void setModule(Module module)
    {
        this.module = module;
    }

    public List<Field> getFieldList()
    {
        return this.fieldList;
    }

    public void setFieldList(List<Field> fieldList)
    {
        this.fieldList = fieldList;
    }

    public int getLineNum()
    {
        return this.lineNum;
    }

    public void setLineNum(int lineNum)
    {
        this.lineNum = lineNum;
    }

    public FileReader getFileReader()
    {
        return this.fileReader;
    }

    public void setFileReader(FileReader fileReader)
    {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader()
    {
        return this.bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader)
    {
        this.bufferedReader = bufferedReader;
    }

    public List<Field> getFieldQueryList()
    {
        return this.fieldQueryList;
    }

    public void setFieldQueryList(List<Field> fieldQueryList)
    {
        this.fieldQueryList = fieldQueryList;
    }
}
