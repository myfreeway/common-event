package com.myfreeway.common.event;

import java.util.EventListener;
import java.util.Set;

import com.myfreeway.common.event.exception.BusinessEventException;

/**
 * 业务事件处理器接口
 * 
 * @author jiangguifan
 *
 * @param <T>
 */
public interface BusinessEventHandler<T> extends EventListener {
	String getName();
	
	Set<String> getFocuses();

	void handle(BusinessEvent<T> event) throws BusinessEventException;
}
