package ru.vixoma.assistant.sqllib.utils;

import lombok.Getter;
import lombok.Setter;

public class Select {

	@Getter
	@Setter
	public String table;
	@Setter
	public String columns;
	@Getter
	@Setter
	public String filter;

	public Select() {
		this.table = "";
		this.columns = "";
		this.filter = "";
	}

	public Select(final String table, final String columns, final String filter) {
		this.table = table;
		this.columns = columns;
		this.filter = filter;
	}

	public String getColumns() {
		if (this.columns == null) {
			return "*";
		}
		return this.columns;
	}
}