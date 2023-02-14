package ru.vixoma.assistant.sqllib.utils;

import java.util.HashMap;
import java.util.Set;

public class UpdateValue {

	public HashMap<String, String> data;

	public UpdateValue(final String key, final String value) {
		data = new HashMap<>();
		data.put(key, value);
	}

	public void add(final String val1, final String val2) {
		this.data.put(val1, val2);
	}

	public Set<String> getKeys() {
		return this.data.keySet();
	}

	public String get(final String key) {
		return this.data.get(key);
	}
}
