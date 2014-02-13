package com.moemao.tgks.moecode.main;

import java.io.IOException;

public class Create
{
    public static void main(String[] args) throws IOException
    {
        String url = "D:\\rule.txt";
        CodeProduct cp = new CodeProduct();
        cp.readFile(url);
        cp.writeFile();
        System.out.println("create success!");
    }
}
