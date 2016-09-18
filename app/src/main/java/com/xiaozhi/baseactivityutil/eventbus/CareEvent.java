package com.xiaozhi.baseactivityutil.eventbus;

public class CareEvent {

	public int what;
	public Object paramObj;

	public CareEvent(int what, Object paraObject) {
		this.what = what;
		this.paramObj = paraObject;
	}
}
