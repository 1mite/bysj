/**
 * Created by mite on 2015/5/11.
 */
package com.bishe.service;

import com.bishe.service.impl.RunCode;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.*;

public class RunJavaImpl implements RunCode {
    private String result = "out.txt";

    @Override
    public String runCode(String code) {
        //重定向
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        StringWriter writer = new StringWriter();// �ڴ��ַ��������
        PrintWriter out = new PrintWriter(writer);
        out.println(code);
        out.flush();
        out.close();
        //
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        JavaFileObject fileObject = new JavaStringObject("Hello", writer.toString());
        StringWriter errors = new StringWriter();
        JavaCompiler.CompilationTask task = javaCompiler.getTask(errors, null, null,
                Arrays.asList("-d", "./tmp"), null, Arrays.asList(fileObject));
        boolean success = task.call();
        if (!success) {
            return errors.toString();
        } else {
            //���÷���������е�main()����
            // Class class1=Class.forName("com.flyoung.hello.Hello");
            //Class class1=ClassLoader.getSystemClassLoader().loadClass("com.flyoung.hello.Hello");
            URL[] urls = new URL[0];
            try {
                urls = new URL[]{new URL("file:" + "./tmp/")};
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class class1 = null;
            try {
                class1 = classLoader.loadClass("Hello");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Method method = null;
            try {
                method = class1.getDeclaredMethod("main", String[].class);
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            String[] args1 = {null};
            try {
                method.invoke(class1.newInstance(), args1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            return readFile(result);
        }
    }
    private String  readFile(String filePath){
        File file = new File(filePath);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int fileLen = (int)file.length();
        char[] chars = new char[fileLen];
        try {
            reader.read(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String txt = String.valueOf(chars);
        return  txt;
    }
    public class JavaStringObject extends SimpleJavaFileObject {
        private String code;

        public JavaStringObject(String name, String code) {
            super(URI.create(name + ".java"), Kind.SOURCE);
            this.code = code;
        }
        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return code;
        }
    }

}
