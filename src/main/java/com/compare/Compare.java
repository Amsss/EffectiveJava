package com.compare;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 19:59
 */
public interface Compare {
    boolean lessThan(Object lhs, Object rhs);
    boolean lessThanOrEqual(Object lhs, Object rhs);
}
