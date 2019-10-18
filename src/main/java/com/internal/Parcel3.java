package com.internal;

/**
 * @description: 内部类规则
 * @author: zhuzz
 * @date: 2019-04-23 10:13
 */
public class Parcel3 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination
            implements Destination {
        private String label;

        protected PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination dest(String s) {
        return new PDestination(s);
    }

    public Contents cont() {
        return new PContents();
    }
}

class Test {
    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Contents c = p.cont();
        Destination d = p.dest("Tanzania");
        // Illegal -- can't access private class:
        // Parcel3.PContents b = p.new PContents();
        Parcel3.PDestination pDestination = p.new PDestination("111");
        System.out.println(pDestination.readLabel());
    }
}
