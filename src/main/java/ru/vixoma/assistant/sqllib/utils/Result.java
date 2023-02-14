package ru.vixoma.assistant.sqllib.utils;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Result {

	@Getter
	public final List<Row> rows;

	public Result() {
		rows = new ArrayList<>();
	}

	public void addrow(final Row row) {
		rows.add(row);
	}
}