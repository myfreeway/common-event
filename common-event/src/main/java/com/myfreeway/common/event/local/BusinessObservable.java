package com.myfreeway.common.event.local;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myfreeway.common.event.BusinessEvent;

public class BusinessObservable<T> extends Observable {
	private static Logger logger = LoggerFactory.getLogger(BusinessObservable.class);

	public void notify(BusinessEvent<T> event) {
		logger.info("begin notify observer");
		super.setChanged();
		super.notifyObservers(event);
		logger.info("end notify observer");
	}

}
