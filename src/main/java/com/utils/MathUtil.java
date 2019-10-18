package com.utils;

import java.math.BigDecimal;

/**
 * @description: ROUND_UP：非0时，舍弃小数后（整数部分）加1，比如12.49结果为13，-12.49结果为 -13
 * ROUND_DOWN：直接舍弃小数
 * ROUND_CEILING：如果 BigDecimal 是正的，则做 ROUND_UP 操作；如果为负，则做 ROUND_DOWN 操作 （一句话：取附近较大的整数）
 * ROUND_FLOOR: 如果 BigDecimal 是正的，则做 ROUND_DOWN 操作；如果为负，则做 ROUND_UP 操作（一句话：取附近较小的整数）
 * ROUND_HALF_UP：四舍五入（取更近的整数）
 * ROUND_HALF_DOWN：跟ROUND_HALF_UP 差别仅在于0.5时会向下取整
 * ROUND_HALF_EVEN：取最近的偶数
 * ROUND_UNNECESSARY：不需要取整，如果存在小数位，就抛ArithmeticException 异常
 * @author: zhuzz
 * @date: 2019-06-25 10:04
 */
public class MathUtil {

    private MathUtil() {
    }

    public static void main(String[] args) {
        double a = 0.3;
        double b = 0.1;
        System.out.println(a - b);
        // 这种失去了精度
        BigDecimal bb = new BigDecimal(a);
        // 先转成String再进行转换
        BigDecimal cc = BigDecimal.valueOf(a);
        //BigDecimal bb = BigDecimal.valueOf(a);
        System.out.println(bb);
        System.out.println(cc);
        BigDecimal xx = BigDecimal.valueOf(99.99);
        long x = xx.setScale(0, BigDecimal.ROUND_UP).longValue();
        System.out.println(x);
    }
}
