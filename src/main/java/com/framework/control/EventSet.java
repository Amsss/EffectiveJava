package com.framework.control;

/**
 * @description: 事件SET
 * @author: zhuzz
 * @date: 2019-04-24 18:03
 */
public class EventSet {
    /**
     * 构建一个数组为100的事件数组
     */
    private AbstractEvent[] events = new AbstractEvent[100];
    /**
     * 下标
     */
    private int index = 0;
    /**
     * 下一个下标
     */
    private int next = 0;

    /**
     * 添加事件
     *
     * @param e
     */
    public void add(AbstractEvent e) {
        if (index >= events.length) {
            // 抛出异常，事件空间满了
            return;
        }
        // 设置事件
        events[index++] = e;
    }

    /**
     * 获取下一个事件
     *
     * @return
     */
    public AbstractEvent getNext() {
        boolean looped = false;
        // 0
        int start = next;
        do {
            next = (next + 1) % events.length;
            // See if it has looped to the beginning:
            if (start == next) {
                looped = true;
            }
            // If it loops past start, the list
            // is empty:
            if ((next == (start + 1) % events.length) && looped) {
                return null;
            }
        } while (events[next] == null);
        return events[next];
    }

    /**
     * 移除事件
     */
    public void removeCurrent() {
        events[next] = null;
    }
}
