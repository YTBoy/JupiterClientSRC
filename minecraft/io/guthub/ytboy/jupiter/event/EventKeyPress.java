package io.guthub.ytboy.jupiter.event;

import com.darkmagician6.eventapi.events.Event;

public class EventKeyPress implements Event{
	int key;
	public EventKeyPress(int key) {
		this.key = key;
	}
	public int getKey() {
		return key;
	}
}
