package com.myfreeway.common.event;

import com.myfreeway.common.event.exception.BusinessEventException;

public interface BusinessEventNotifier<T> {
	void sendEvent(BusinessEvent<T> event) throws BusinessEventException;
}
