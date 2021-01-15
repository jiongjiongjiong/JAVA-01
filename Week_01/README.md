### 作业
2.（必做）自定义一个 `Classloader`，加载一个 `Hello.xlass` 文件，执行 `hello `方法，此文件内容是一个 `Hello.class` 文件所有字节（x=255-x）处理后的文件。文件群里提供。

```
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

```

3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

![](https://github.com/jiongjiongjiong/JAVA-01/blob/main/Week_01/Java内存模型.png?raw=true)

