package com.myfreeway.common.event;

import com.myfreeway.common.event.exception.BusinessEventException;

/**
 * 事件源，触发发送事件的主体。不直接用通知器触发，是因为事件源更好理解。
 * 
 * @author jiangguifan
 *
 */
public class BusinessEventSource<T> {

	/**
	 * 组合业务事件通知器，引入他的发送事件能力
	 */
	private BusinessEventNotifier<T> notifier;

	public void setNotifier(BusinessEventNotifier<T> notifier) {
		this.notifier = notifier;
	}

	/**
	 * 触发事件
	 * 
	 * @param event
	 * @throws BusinessEventException
	 */
	public void fireEvent(BusinessEvent<T> event) throws BusinessEventException {
		// 发送事件
		notifier.sendEvent(event);
	}

}
