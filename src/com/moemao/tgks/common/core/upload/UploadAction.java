package com.moemao.tgks.common.core.upload;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.moemao.tgks.common.core.action.TGKSAction;

public class UploadAction extends TGKSAction
{
	private static final long serialVersionUID = -4742151106080093662L;
	
	private String singleBasePath = "/upload/single/";
	
	private File single;
	private String singleFileName;
	private String singleContentType;
	private String singleUrl;
	
	public String uploadSingle() throws Exception
	{
		// 获取项目部署的路径
		String realPath = ServletActionContext.getServletContext().getRealPath(singleBasePath);
		// 生成新的文件名
		String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(singleFileName);// 获取文件的后缀名 aa.jpg --> jpg
		FileUtils.copyFile(single, new File(realPath + File.separator + newFileName));
		
		singleUrl = singleBasePath + newFileName;
		
		return SUCCESS;
	}
	
	public String uploadSinglePage() throws Exception
	{
		return SUCCESS;
	}

	public String getSingleBasePath()
    {
    	return singleBasePath;
    }

	public void setSingleBasePath(String singleBasePath)
    {
    	this.singleBasePath = singleBasePath;
    }

	public File getSingle()
    {
    	return single;
    }

	public void setSingle(File single)
    {
    	this.single = single;
    }

	public String getSingleFileName()
    {
    	return singleFileName;
    }

	public void setSingleFileName(String singleFileName)
    {
    	this.singleFileName = singleFileName;
    }

	public String getSingleContentType()
    {
    	return singleContentType;
    }

	public void setSingleContentType(String singleContentType)
    {
    	this.singleContentType = singleContentType;
    }

	public String getSingleUrl()
    {
    	return singleUrl;
    }

	public void setSingleUrl(String singleUrl)
    {
    	this.singleUrl = singleUrl;
    }

}
