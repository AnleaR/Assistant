package ru.vixoma.assistant.sqllib.utils;

import java.util.HashMap;
import java.util.Set;

public class Row {

	public HashMap<String, Object> content;

	public Row() {
		this.content = new HashMap<>();
	}

	public void addcolumn(final String name, final Object content) {
		this.content.put(name, content);
	}

	public HashMap<String, Object> getColumns() {
		return this.content;
	}

	public Object get(final String key) {
		return this.content.get(key);
	}

	public Set<String> getKeys() {
		return this.content.keySet();
	}
}