package com.bulider;

/**
 * @description: 人员类
 * @author: zhuzz
 * @date: 2019/1/3 15:33
 */
public class Person {
    private final String name;
    private final String sex;
    private final int high;
    private final int weight;

    private Person(PersonBuilder bd) {
        //验证builder参数
        if (bd.name == null || "".endsWith(bd.name)) {
            throw new IllegalStateException("builder参数异常");
        }
        name = bd.name;
        sex = bd.sex;
        high = 0;
        weight = 0;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + ", high=" + high
                + ", weight=" + weight + "]";
    }

    public static class PersonBuilder implements Builder<Person> {
        private final String name;
        private final String sex;
        private int x = 0;
        private int y = 0;
        private int z = 0;

        public PersonBuilder(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public PersonBuilder nameX(int x) {
            if (x == 0) {
                throw new IllegalArgumentException("传入参数无效");
            }
            this.x = x;
            return this;
        }

        public PersonBuilder nameY(int y) {
            this.y = y;
            return this;
        }

        public PersonBuilder nameZ(int z) {

            this.z = z;
            return this;
        }

        @Override
        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person a = new PersonBuilder("朱泽沼", "男").nameX(1).nameY(2).nameZ(3).build();
        System.out.println(a);
    }
}
