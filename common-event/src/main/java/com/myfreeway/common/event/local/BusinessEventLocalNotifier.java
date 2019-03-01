package com.myfreeway.common.event.local;

import com.myfreeway.common.event.BusinessEventNotifier;

public abstract class BusinessEventLocalNotifier<T> implements BusinessEventNotifier<T> {

	public abstract void addBusinsessObserver(BusinessObserver<T> businessObserver);

	public abstract void removeBusinsessObserver(BusinessObserver<T> businessObserver);

}
