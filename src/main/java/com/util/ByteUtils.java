package com.util;

/**
 * @Description: Bytes数组处理工具类
 * @author: zhuzz
 * @date: 2018-06-20 16:17
 */
public class ByteUtils {

    private ByteUtils() {

    }

    /**
     * int转字节数组(低字节在前，高字节在后的byte数组)
     * int型32位byte型8位
     * 例如：int类型：97
     * 则二进制表示为：00000000 00000000 00000000 01100001
     * b[0] = 11111111(0xff) & 01100001
     * b[1] = 11111111(0xff) & (n >> 8)00000000
     * b[2] = 11111111(0xff) & (n >> 16)00000000
     * b[3] = 11111111(0xff) & (n >> 24)00000000
     *
     * @param paramInt
     * @return
     */
    public static byte[] intToBytes(int paramInt) {
        return new byte[]{
                (byte) (paramInt & 0xFF),
                (byte) (paramInt >> 8 & 0xFF),
                (byte) (paramInt >> 16 & 0xFF),
                (byte) (paramInt >> 24 & 0xFF)};
    }

    public static byte[] intToBytes1(int paramInt) {
        return new byte[]{
                (byte) (paramInt),
                (byte) (paramInt >> 8),
                (byte) (paramInt >> 16 ),
                (byte) (paramInt >> 24 )};
    }

    /**
     * int转字节数组(低字节在前，高字节在后的byte数组)
     * int型32位byte型8位
     * 例如：int类型：97
     * 则二进制表示为：00000000 00000000 00000000 01100001
     * b[0] = 11111111(0xff) & 01100001
     * b[1] = 11111111(0xff) & (n >> 8)00000000
     * b[2] = 11111111(0xff) & (n >> 16)00000000
     * b[3] = 11111111(0xff) & (n >> 24)00000000
     *
     * @param paramInt
     * @return
     */
    public static byte[] bytesToInt(int paramInt) {
        return new byte[]{
                (byte) (paramInt & 0xFF),
                (byte) (paramInt >> 8 & 0xFF),
                (byte) (paramInt >> 16 & 0xFF),
                (byte) (paramInt >> 24 & 0xFF)};
    }

    /**
     * 拼接字节到字节数组中
     *
     * @param paramArrayOfByte 原始字节数组
     * @param paramByte        要拼接的字节
     * @return 拼接后的数组
     */
    public static byte[] MergerArray(byte[] paramArrayOfByte, byte paramByte) {
        byte[] arrayOfByte = new byte[paramArrayOfByte.length + 1];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        arrayOfByte[paramArrayOfByte.length] = paramByte;
        return arrayOfByte;
    }

    /**
     * 两个字节数组拼接
     *
     * @param paramArrayOfByte1 字节数组1
     * @param paramArrayOfByte2 字节数组2
     * @return 拼接后的数组
     */
    public static byte[] MergerArray(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
        return arrayOfByte;
    }

    /**
     * 字节数组拆分
     *
     * @param paramArrayOfByte 原始数组
     * @param paramInt1        起始下标
     * @param paramInt2        要截取的长度
     * @return 处理后的数组
     */
    public static byte[] SubArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        byte[] arrayOfByte = new byte[paramInt2];
        int i = 0;
        while (true) {
            if (i >= paramInt2) {
                return arrayOfByte;
            }
            arrayOfByte[i] = paramArrayOfByte[(i + paramInt1)];
            i += 1;
        }
    }

    /**
     * int数组转byte数组
     *
     * @param paramArrayOfInt int数组
     * @return 转换后的byte数组
     */
    public static byte[] intsToBytes(int[] paramArrayOfInt) {
        byte[] arrayOfByte = new byte[paramArrayOfInt.length];
        int i = 0;
        while (true) {
            if (i >= paramArrayOfInt.length) {
                return arrayOfByte;
            }
            arrayOfByte[i] = (byte) paramArrayOfInt[i];
            i += 1;
        }
    }

    /**
     * 字符串转byte数组
     *
     * @param paramString 字符串
     * @param paramInt    字符串数组长度
     * @return 转换后的数组
     */
    public static byte[] stringToBytes(String paramString, int paramInt) {
        while (true) {
            if (paramString.getBytes().length >= paramInt) {
                return paramString.getBytes();
            }
            paramString = paramString + " ";
        }
    }

    /**
     * 基本数据类型：
     * byte：Java中最小的数据类型，在内存中占8位(bit)，即1个字节，取值范围-128~127，默认值0
     * short：短整型，在内存中占16位，即2个字节，取值范围-32768~32717，默认值0
     * int：整型，用于存储整数，在内在中占32位，即4个字节，取值范围-2147483648~2147483647，默认值0
     * long：长整型，在内存中占64位，即8个字节-2^63~2^63-1，默认值0L
     * float：浮点型，在内存中占32位，即4个字节，用于存储带小数点的数字（与double的区别在于float类型有效小数点只有6~7位），默认值0
     * double：双精度浮点型，用于存储带有小数点的数字，在内存中占64位，即8个字节，默认值0
     * char：字符型，用于存储单个字符，占16位，即2个字节，取值范围0~65535，默认值为空 Unicode字符由16位组成，因此，有(65535)个不同的字符可用
     * boolean：布尔类型，占1个字节，用于判断真或假（仅有两个值，即true、false），默认值false
     *
     * Java数据类型在内存中的存储
     * 1）基本数据类型的存储原理：所有的简单数据类型不存在“引用”的概念，基本数据类型都是直接存储在内存中的内存栈上的，数据本身的值就是存储在栈空间里面，而Java语言里面八种数据类型是这种存储模型；
     * 2）引用类型的存储原理:引用类型继承于Object类（也是引用类型）都是按照Java里面存储对象的内存模型来进行数据存储的，使用Java内存堆和内存栈来进行这种类型的数据存储，简单地讲，“引用”是存储在有序的内存栈上的，而对象本身的值存储在内存堆上的；
     *
     *
     * 十进制定点常量：如123、-456、0。
     * 八进制定点常量：以0前导，形式为0dd...d。如0123表示十进制数83，-011表示十进制数-9。
     * 十六进制定点常量：以0x或0X开头，如0x123表示十进制数291，-0X12表示十进制数-18。
     *
     * Java变量命名规则：
     * 1：必须以字母、下划线“_”、或“$”符号开头
     * 2：可以包括数字、区分大小写
     * 3：不能使用Java语言的关键字，例如int、class、public等

     * Java中的六种运算符：
     * ·   算术运算符
     * ·   赋值运算符
     * ·   关系运算符
     * ·   逻辑运算符
     * ·   位运算符
     * ·    三元运算符

     * 算术运算符：
     * +：加法运算，求操作数的和
     * -：减法运算，求操作数的差
     * *：乘法运算，求操作数的乘积
     * /：除法运算，求操作数的商
     * %：求余运算，求操作数相除的余数
     * ++：自增，操作数自加1
     * --：自减，操作数自减1

     * 赋值运算符：
     * =：将右边的值赋给左边，例：int a = 1;
     * +=：左右两边的和相加赋给左边，例：int a = 1; a+=2;结果a的值为3
     * -=：左边减去右边的差赋给左边，例：int a =5;a-=2;结果a的值为3
     * *=：两边数值相乘的值赋给左边，例：int a = 2;a*=2;结果a的值为4
     * /=：左边除以右边的值赋给左边，例：int a = 6;a/=2;结果a的值为3
     * %=：左边除以右边的余数赋给左边，例：int a =7;a%=2;结果a的值为1

     * 关系运算符
     * >：大于，例：int a = 1;int b = 2;System.out.print(a > b);其结果为false
     * <：小于,例：int a = 1;int b = 2;System.out.print(a < b);其结果为true
     * >=：大于等于,例：int a = 1;int b = 2;System.out.print(a >= b);其结果为false
     * <=：小于等于,例：int a = 1;int b = 2;System.out.print(a <= b);其结果为true
     * ==：等于,例：int a = 1;int b = 2;System.out.print(a == b);其结果为false
     * !=：不等于,例：int a = 1;int b = 2;System.out.print(a != b);其结果为true
     * 其结果都是boolean类型，即要么是true要么是false
     *
     * 逻辑运算符
     * &&：与、并且(短路)，   两个条件同时为真时，结果为真
     * ||：或、或者(短路)，   两个条件有一个为真时，结果即为真
     * !：非，(!+条件)  条件为真时，结果为假
     *
     * Java中的数据类型转换
     * 1：自动数据类型转换（放大转换）
     * 满足自动数据类型转换条件：
     * 1）两种类型要兼容：如数值类型（整型和浮点型）
     * 2）目标类型大于源类型：例如int型数据可以自动转换为double类型
     *
     * 2：强制数据类型转换（缩小转换）
     * 在变量前加上括号，在括号中指定要强制转换的类型
     * 例：double a = 40.9;
     * int b= (int)a;
     * 注：强制转换会损失数值精度，例如double类型变量a，经强制转换为int类型后值变为40
     */

    //111111111111111111111111111111111111111111111111111111111111111
    //1111111111111111111111111111111
    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(9223372036854775807L));
        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println();
        byte[] a = ByteUtils.intToBytes1(1111);
        System.out.println(a);
    }
}
