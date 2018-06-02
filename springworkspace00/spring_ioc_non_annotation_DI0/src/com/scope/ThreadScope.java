package com.scope;

/**
 * 1）Object get(String name, ObjectFactory<?> objectFactory)：用于从作用域中获取Bean，其中参数objectFactory是当在当前作用域没找到合适Bean时使用它创建一个新的Bean；

 2）void registerDestructionCallback(String name, Runnable callback)：用于注册销毁回调，如果想要销毁相应的对象则由Spring容器注册相应的销毁回调，而由自定义作用域选择是不是要销毁相应的对象；

 3）Object resolveContextualObject(String key)：用于解析相应的上下文数据，比如request作用域将返回request中的属性。

 4）String getConversationId()：作用域的会话标识，比如session作用域将是sessionId。
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ThreadScope implements Scope {
	private final ThreadLocal<Map<String, Object>> THREAD_SCOPE = new ThreadLocal<Map<String, Object>>() {
		protected Map<String, Object> initialValue() {
			// 用于存放线程相关Bean
			return new HashMap<String, Object>();
		};
	};

	// 来实现个简单的thread作用域，该作用域内创建的对象将绑定到ThreadLocal内
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		// 如果当前线程已经绑定了相应Bean，直接返回
		if (THREAD_SCOPE.get().containsKey(name)) {
			return THREAD_SCOPE.get().get(name);
		}
		// 使用objectFactory创建Bean并绑定到当前线程上
		THREAD_SCOPE.get().put(name, objectFactory.getObject());
		return THREAD_SCOPE.get().get(name);
	}

	@Override
	public Object remove(String name) {
		return THREAD_SCOPE.get().remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// 此处不实现就代表类似proytotype，容器返回给用户后就不管了
	}

	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

}
