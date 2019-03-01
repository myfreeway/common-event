package com.myfreeway.common.event;

import java.util.HashSet;
import java.util.Set;

/**
 * 人性化增强。抽象的业务事件处理器。目的是提前实现focuses的get/set，每个handler都要实现，区别只有handle方法不同。
 * 
 * @author jiangguifan
 *
 * @param <T>
 */
public abstract class AbstractBusinessEventHandler<T> implements BusinessEventHandler<T> {

	private Set<String> focuses = new HashSet<>();

	@Override
	public Set<String> getFocuses() {
		return focuses;
	}

	public void setFocuses(Set<String> focuses) {
		this.focuses = focuses;
	}

	/**
	 * 人性化增强。方便spring注入，通过字符串的方式
	 * 
	 * @param focus
	 */
	public void setFocus(String focus) {
		if (focus == null || focus.trim().equals("")) {
			return;
		}
		String[] arr = focus.trim().split(",");
		for (int i = 0; i < arr.length; i++) {
			this.focuses.add(arr[i].trim());
		}
	}
}
