package com.moemao.tgks.moecode.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.moemao.tgks.moecode.entity.Module;

public abstract class WriteFile
{
    public FileWriter fileWriter;

    public BufferedWriter bufferedWriter;

    public FileOutputStream fos;

    public Writer writer;

    public void writeOn(String str) throws IOException
    {
        this.bufferedWriter.write(str);
    }

    public void write(String str) throws IOException
    {
        newLine();
        this.bufferedWriter.write(str);
    }

    public void newLine() throws IOException
    {
        this.bufferedWriter.newLine();
    }

    public void close() throws IOException
    {
        this.fileWriter.flush();
        this.bufferedWriter.flush();
        this.fileWriter.close();
        this.bufferedWriter.close();
    }

    public void comment(String str) throws IOException
    {
    }

    public abstract void write(Module paramModule) throws IOException;

    public FileWriter getFileWriter()
    {
        return this.fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter)
    {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufferedWriter()
    {
        return this.bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter)
    {
        this.bufferedWriter = bufferedWriter;
    }

    public FileOutputStream getFos()
    {
        return this.fos;
    }

    public void setFos(FileOutputStream fos)
    {
        this.fos = fos;
    }

    public Writer getWriter()
    {
        return this.writer;
    }

    public void setWriter(Writer writer)
    {
        this.writer = writer;
    }
}
