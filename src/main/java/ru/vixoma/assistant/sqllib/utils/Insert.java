package ru.vixoma.assistant.sqllib.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Insert {

	public String table;
	public String columns;
	public Object[] data;

	public Insert(final String table, final String columns, final Object... data) {
		this.table = table;
		this.columns = columns;
		this.data = data;
	}

	public Insert() {
		this.table = "";
		this.columns = "";
		this.data = null;
	}

	public void setData(final List<Object> data) {
		this.data = data.toArray();
	}
}
