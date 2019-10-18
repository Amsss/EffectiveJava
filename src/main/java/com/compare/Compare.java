package com.compare;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 19:59
 */
public interface Compare {
    /**
     * @param lhs
     * @param rhs
     * @return
     */
    boolean lessThan(Object lhs, Object rhs);

    /**
     * @param lhs
     * @param rhs
     * @return
     */
    boolean lessThanOrEqual(Object lhs, Object rhs);
}
