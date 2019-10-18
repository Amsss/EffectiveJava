package com.method;

import com.annotation.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-06-12 16:16
 */
public class MethodTest {

    /**
     * 一个完整方法包含的属性有： 方法上使用的注解、方法的修饰符、方法上定义的泛型参数、方法的返回值、方法名称、方法参数(泛型、注解)、方法抛出的异常
     */
    @MyAnnotation
    private <T> boolean add(@MyAnnotation List<T> list, T... params) throws RuntimeException, Exception {
        if (null == list) {
            throw new RuntimeException("list = null");
        }
        if (null == params) {
            return false;
        }
        // 将参数添加到List集合中
        if (null != params) {
            for (T t : params) {
                list.add(t);
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // 获取Method
        MethodTest obj = new MethodTest();
        Class<? extends MethodTest> clazz = obj.getClass();

        Method method = clazz.getDeclaredMethod("add", List.class,
                Object[].class);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        //获取方法基本信息
        getMethodInfo(method);

        // 调用方法
        List<String> arrayList = new ArrayList<String>();
        method.invoke(obj, arrayList, new String[]{"1", "2"});
        //[1,2]
        System.out.println(arrayList);

        //方法定义所在的类
        Class<?> declaringClass = method.getDeclaringClass();

        // 如果此方法是 bridge 方法，则返回 true；
        boolean bridge = method.isBridge();
        //如果该方法是public非抽象非静态，且定义在接口中，则返回true
        boolean default1 = method.isDefault(); //false
        //如果此方法为复合方法，则返回 true；
        boolean synthetic = method.isSynthetic();//false
        // 如果将此方法的参数带有可变参数，则返回 true
        boolean varArgs = method.isVarArgs(); //true


    }

    private static void getMethodInfo(Method method) {
        // 1、获取方法上的注解
        boolean annotationPresent = method
                .isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent) {
            MyAnnotation myAnnotation = method
                    .getDeclaredAnnotation(MyAnnotation.class);
        }
        // 2、方法的修饰符
        int modifiers = method.getModifiers();
        String modify = Modifier.toString(modifiers);// private
        // 3、方法上定义的泛型参数
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();// [T]
        // 4、方法的返回值
        Class<?> returnType = method.getReturnType();// boolean
        Type genericReturnType = method.getGenericReturnType();// boolean
        // 5、方法名称
        String name = method.getName();
        // 6、方法参数
        int parameterCount = method.getParameterCount();// 参数个数 2
        // 方法参数——泛型
        Class<?>[] parameterTypes = method.getParameterTypes();
        // 打印 [interface java.utils.list, class [Ljava.lang.Object;]
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        // 打印 [java.utils.list<T>, T[]]
        for (Type type : genericParameterTypes) {
            if (type instanceof ParameterizedType) { // 参数类型
                System.out.println("ParameterizedType类型：" + type);
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType
                        .getActualTypeArguments();
                System.out.println("实际参数为："
                        + Arrays.toString(actualTypeArguments));
                for (Type actualType : actualTypeArguments) {
                    if (actualType instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) actualTypeArguments[0];
                        System.out.println("实际参数为WildcardType类型："
                                + wildcardType.getUpperBounds());
                    } else if (actualType instanceof Class) {
                        System.out.println("实际参数为Class类型：" + actualType);
                    }
                }

            } else if (type instanceof GenericArrayType) { // 泛型数组类型 T[]
                GenericArrayType genericArrayType = (GenericArrayType) type;
                System.out.println("GenericArrayType类型："
                        + genericArrayType.getGenericComponentType());//T
            } else if (type instanceof TypeVariable) { // 泛型变量
                System.out.println("TypeVariable类型：" + type);
            } else if (type instanceof Class) { //
                System.out.println("Class类型：" + type);
            }
        }
        /*
         * 方法有2个参数，第一个参数list为ParameterizedType，实际参数为T，
         * 第二个参数为GenericArrayType泛型数组类型T[],数组元素类型为T
         */

        //方法参数——注解   第一个参数使用了注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation myAnnotation = parameterAnnotations[0][0];
        //打印 @reflect.MyAnnotation(intValue=0)


        // 7、方法抛出的异常
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        // 打印 [class java.lang.RuntimeException, class java.lang.Exception]
        Type[] genericExceptionTypes = method.getGenericExceptionTypes();
        // 打印 [class java.lang.RuntimeException, class java.lang.Exception]

    }
}
