package ru.vixoma.assistant.sqllib.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Update {

	public String table;
	public UpdateValue value;
	public String filter;

	public Update() {
		this.table = "";
		this.value = null;
		this.filter = "";
	}

	public Update(final String table, final UpdateValue value, final String filter) {
		this.table = table;
		this.value = value;
		this.filter = filter;
	}
}