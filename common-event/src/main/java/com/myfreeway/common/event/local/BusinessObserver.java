package com.myfreeway.common.event.local;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myfreeway.common.event.BusinessEvent;
import com.myfreeway.common.event.BusinessEventHandler;
import com.myfreeway.common.event.exception.BusinessEventException;

/**
 * 业务事件观察者，此类的存在是为了让观察者模式完整
 * 
 * @author jiangguifan
 *
 * @param <T>
 */
public class BusinessObserver<T> implements Observer {
	private static Logger logger = LoggerFactory.getLogger(BusinessObserver.class);

	private BusinessEventHandler<T> handler;

	public BusinessObserver(BusinessEventHandler<T> handler) {
		this.handler = handler;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		logger.info("observer receive event");
		if (arg == null || !(arg instanceof BusinessEvent)) {
			logger.info("arg is null or is not BusinessEvent");
			return;
		}
		BusinessEvent<T> event = BusinessEvent.class.cast(arg);
		logger.info("event is [{}]", event.toString());
		if (handler.getFocuses().contains(event.getType())) {
			logger.info("success focus the event");
			try {
				handler.handle(event);
			} catch (BusinessEventException e) {
				logger.error("handle event err", e);
			}
		} else {
			logger.info("fail focus the event");
		}
	}

}
