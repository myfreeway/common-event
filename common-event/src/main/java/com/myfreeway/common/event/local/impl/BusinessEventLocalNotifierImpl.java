package com.myfreeway.common.event.local.impl;

import com.myfreeway.common.event.BusinessEvent;
import com.myfreeway.common.event.exception.BusinessEventException;
import com.myfreeway.common.event.local.BusinessEventLocalNotifier;
import com.myfreeway.common.event.local.BusinessObservable;
import com.myfreeway.common.event.local.BusinessObserver;

public class BusinessEventLocalNotifierImpl<T> extends BusinessEventLocalNotifier<T> {

	private BusinessObservable<T> businessObservable = new BusinessObservable<T>();

	public void addBusinsessObserver(BusinessObserver<T> businessObserver) {
		businessObservable.addObserver(businessObserver);
	}

	public void removeBusinsessObserver(BusinessObserver<T> businessObserver) {
		businessObservable.deleteObserver(businessObserver);
	}

	@Override
	public void sendEvent(BusinessEvent<T> event) throws BusinessEventException {
		businessObservable.notify(event);
	}
}
