package com.ss.lms.app;

import java.util.function.Consumer;

class Menu {

	private final String action;
	private final Consumer<String> consumer;

	Menu(String action, Consumer<String> consumer) {
		this.action = action;
		this.consumer = consumer;
	}

	void execute() {
		this.consumer.accept(action);
	}
}