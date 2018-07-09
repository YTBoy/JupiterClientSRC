package io.github.ytboy.jupiter.event;

import com.darkmagician6.eventapi.events.Event;

public class Event3DRender implements Event {
	float pticks;

	public Event3DRender(float pticks) {
		this.pticks = pticks;
	}

	public float pticks() {
		return pticks;
	}
}
