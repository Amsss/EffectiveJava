package com.controlframework;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-24 18:03
 */
public class EventSet {
    private AbstractEvent[] events = new AbstractEvent[100];
    private int index = 0;
    private int next = 0;

    public void add(AbstractEvent e) {
        if (index >= events.length) {
            return; // (In real life, throw exception)
        }
        events[index++] = e;
    }

    public AbstractEvent getNext() {
        boolean looped = false;
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

    public void removeCurrent() {
        events[next] = null;
    }
}
