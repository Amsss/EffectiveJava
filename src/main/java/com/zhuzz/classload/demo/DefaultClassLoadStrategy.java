package com.zhuzz.classload.demo;

public class DefaultClassLoadStrategy implements IClassLoadStrategy {
	public ClassLoader getClassLoader(final ClassLoadContext ctx) {
		final ClassLoader callerLoader = ctx.getCallerClass().getClassLoader();
		final ClassLoader contextLoader = Thread.currentThread()
				.getContextClassLoader();

		ClassLoader result;

		// 如果调用者加载器和上下文加载器是父子关系，则一直选择子加载器：

		if (isChild(contextLoader, callerLoader))
			result = callerLoader;
		else if (isChild(callerLoader, contextLoader))
			result = contextLoader;
		else {
			// else分支可以被合并到前一个，单独列出来是要强调在模棱两可的情况下：
			result = contextLoader;
		}

		final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();

		// 部署时作为启动类或启动扩展类的注意事项：
		if (isChild(result, systemLoader))
			result = systemLoader;

		return result;
	}

	private boolean isChild(ClassLoader contextLoader, ClassLoader callerLoader) {
		ClassLoader a = callerLoader.getParent();
		if (a.equals(contextLoader)) {
			return true;
		} else {
			return false;
		}
	}
} // 类定义结束
