package io.github.ytboy.jupiter.event;

import com.darkmagician6.eventapi.events.Event;

public class Event2DRender implements Event{
	public float pticks;
	
	public Event2DRender(float pticks) {
		this.pticks = pticks;
	}
}
