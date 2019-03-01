package com.myfreeway.common.event;

import java.util.EventObject;

/**
 * 业务事件对象
 * 
 * @author jiangguifan
 *
 * @param <T>
 */
public class BusinessEvent<T> extends EventObject {
	private static final long serialVersionUID = 1L;
	private String type;
	private T data;

	public BusinessEvent(Object source) {
		super(source);
	}

	public BusinessEvent(Object source, String type, T data) {
		super(source);
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BusinessEvent [type=" + type + ", data=" + data + "]";
	}

}
