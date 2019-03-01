package com.myfreeway.common.event.local.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myfreeway.common.event.AbstractBusinessEventHandler;
import com.myfreeway.common.event.BusinessEvent;
import com.myfreeway.common.event.BusinessEventHandler;
import com.myfreeway.common.event.BusinessEventNotifier;
import com.myfreeway.common.event.BusinessEventSource;
import com.myfreeway.common.event.exception.BusinessEventException;
import com.myfreeway.common.event.local.BusinessEventLocalNotifier;
import com.myfreeway.common.event.local.BusinessObserver;

public class BusinessEventSourceTest<T> {
	private static Logger logger = LoggerFactory.getLogger(BusinessEventSourceTest.class);

	@Test
	public void fireEventTest1() {
		// 事件
		BusinessEvent<String> event = new BusinessEvent<>(this, "order_add", "i am order_add");
		BusinessEvent<String> eventOrderDelete = new BusinessEvent<>(this, "order_delete", "i am order_delete");

		// 事件源
		BusinessEventSource<String> eventSource = new BusinessEventSource<>();
		// 事件源组合通知器
		eventSource.setNotifier(getNotifierForTest1());

		try {
			// 事件源触发事件
			eventSource.fireEvent(event);
			eventSource.fireEvent(eventOrderDelete);
		} catch (BusinessEventException e) {
			e.printStackTrace();
		}
	}

	private BusinessEventNotifier<String> getNotifierForTest1() {
		// 本地通知器，组合了被观察者
		BusinessEventLocalNotifier<String> notifier = new BusinessEventLocalNotifierImpl<String>();

		// 通知器的被观察者 增加 观察者（引入事件处理器实现观察者的update监听方法）
		notifier.addBusinsessObserver(new BusinessObserver<String>(getHandlerForTest1()));
		notifier.addBusinsessObserver(new BusinessObserver<String>(getHandlerForTest1InnerImpl()));

		return (BusinessEventNotifier<String>) notifier;
	}

	private BusinessEventHandler<String> getHandlerForTest1() {
		Set<String> focuses = new HashSet<>();
		focuses.add("order_add");

		// 为什么叫处理器，是因为直接监听事件的是观察者
		BusinessEventHandler<String> handler = new AbstractBusinessEventHandler<String>() {

			@Override
			public void handle(BusinessEvent<String> event) throws BusinessEventException {
				logger.info("begin " + getName() + " event=" + event.toString());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("end " + getName() + " event=" + event.toString());
			}

			@Override
			public String getName() {
				return "demoHandler_1";
			}
		};
		((AbstractBusinessEventHandler<String>) handler).setFocuses(focuses);
		return handler;
	}

	private BusinessEventHandler<String> getHandlerForTest1InnerImpl() {
		Set<String> focuses = new HashSet<>();
		focuses.add("order_add");

		// 为什么叫处理器，是因为直接监听事件的是观察者
		BusinessEventHandler<String> handler = new AbstractBusinessEventHandler<String>() {

			@Override
			public void handle(BusinessEvent<String> event) throws BusinessEventException {
				logger.info("begin " + getName() + " event=" + event.toString());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("end " + getName() + " event=" + event.toString());
			}

			@Override
			public String getName() {
				return "demoHandler_2";
			}
		};
		((AbstractBusinessEventHandler<String>) handler).setFocuses(focuses);

		return handler;
	}
}
