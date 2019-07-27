函数式接口
====
函数式接口（functional interface 也叫功能性接口）简单来说，函数式接口是只包含一个方法的接口。
比如Java标准库中的java.lang.Runnable和java.util.Comparator都是典型的函数式接口。
java 8提供 @FunctionalInterface作为注解,这个注解是非必须的，只要接口符合函数式接口的标准（即只包含一个方法的接口），
虚拟机会自动判断，但 最好在接口上使用注解@FunctionalInterface进行声明，以免团队的其他人员错误地往接口中添加新的方法。