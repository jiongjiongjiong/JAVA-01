package com.zc.week01;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> xlass = new HelloClassLoader().findClass("Hello.xlass");
            Object instance = xlass.newInstance();
            Method method = xlass.getDeclaredMethod("hello");
            method.invoke(instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream(name);
        assert resource != null;
        byte[] result = null;
        try( ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            int i ;
            while ((i = resource.read()) != -1){
                byteArrayOutputStream.write((byte)(255-i));
            }
            result = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert result != null;
        return defineClass(name.substring(0,name.indexOf(".")),result,0, result.length);
    }
}
