package com.collection;

import java.util.*;

/**
 * @description: 能查出除我们的进程自己需要负责的之外的、对容器的其他任何修改。若探测到有其他方面也准备修改容器，
 * 便会立即产生一个ConcurrentModificationException（并发修改异常）。我们将这一机制称为“立即失败”
 * ——它并不用更复杂的算法在“以后”侦测问题，而是“立即”产生异常。
 * @author: zhuzz
 * @date: 2019-04-29 9:57
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>(16));
        List<String> list = Collections.synchronizedList(new ArrayList<String>(16));
        Set<String> s = Collections.synchronizedSet(new HashSet<String>(16));
        Map<String, Object> m = Collections.synchronizedMap(new HashMap<String, Object>(16));
    }
}