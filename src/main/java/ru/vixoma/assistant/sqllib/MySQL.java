package ru.vixoma.assistant.sqllib;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.Setter;
import ru.vixoma.assistant.sqllib.utils.*;

import javax.sql.DataSource;
import java.sql.*;

@Setter
public class MySQL {
	public String host;
	public String user;
	public String password;
	public String database;
	public int port;
	public Connection connection;
	public boolean debug;

	public MySQL(final String host, final String user, final String pw, final String database) {
		this.port = 3306;
		this.debug = false;
		this.host = host;
		this.user = user;
		this.password = pw;
		this.database = database;
	}

	public boolean isDebug() {
		return this.debug;
	}

	public boolean connect() {
		try {
			final MysqlDataSource dataSource = new MysqlDataSource();
			if (dataSource instanceof DataSource && isDebug()) {
				System.out.println("MysqlDataSource implements the javax.sql.DataSource interface");
			}
			dataSource.setServerName(host);
			dataSource.setPort(port);
			dataSource.setDatabaseName(database);
			dataSource.setUser(user);
			dataSource.setPassword(password);
			dataSource.setAllowMultiQueries(true);
			connection = dataSource.getConnection();
			System.out.println("Connection established");
			return true;
		} catch (final SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean isConnected() {
		if (this.connection == null) {
			return false;
		}
		try {
			if (this.connection.isClosed()) {
				return false;
			}
		} catch (final SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean close() {
		try {
			this.connection.close();
			return true;
		} catch (final SQLException e) {
			return false;
		}
	}

	public boolean tableInsert(final String table, final String columns, final Object... data) {
		final StringBuilder sqldata = new StringBuilder();
		int i = 0;
		for (final Object value : data) {
			if (value instanceof String)
				sqldata.append("'").append(value).append("'");
			else
				sqldata.append(value);
			if (++i != data.length) {
				sqldata.append(", ");
			}
		}
		final String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + sqldata + ");";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (final SQLException e) {
			e.printStackTrace();
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (final SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean tableInsert(final Insert... builders) {
		final StringBuilder sql = new StringBuilder();
		for (final Insert builder : builders) {
			String sqldata = "";
			int i = 0;
			for (final Object data : builder.getData()) {
				sqldata = sqldata + "'" + data + "'";
				if (++i != builder.getData().length) {
					sqldata += ", ";
				}
			}
			sql.append("INSERT INTO ").append(builder.getTable()).append(" (").append(builder.getColumns()).append(") VALUES (").append(sqldata).append("); ");
		}
		Statement statement = null;
		try {
			statement = this.connection.createStatement();
			statement.execute(sql.toString());
		} catch (final SQLException e) {
			e.printStackTrace();
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean rowUpdate(final String table, final UpdateValue value, final String filter) {
		final StringBuilder change = new StringBuilder();
		int i = 0;
		for (final String key : value.getKeys()) {
			change.append(key).append(" = '").append(value.get(key)).append("'");
			if (++i != value.getKeys().size()) {
				change.append(", ");
			}
		}
		final String sql = "UPDATE " + table + " SET " + change + " WHERE " + filter + ";";
		Statement statement = null;
		try {
			statement = this.connection.createStatement();
			statement.execute(sql);
		} catch (final SQLException e) {
			e.printStackTrace();
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean rowUpdate(final Update... builders) {
		final StringBuilder sql = new StringBuilder();
		for (final Update u : builders) {
			final StringBuilder change = new StringBuilder();
			int i = 0;
			for (final String key : u.getValue().getKeys()) {
				change.append(key).append(" = '").append(u.getValue().get(key)).append("'");
				if (++i != u.getValue().getKeys().size()) {
					change.append(", ");
				}
			}
			sql.append("UPDATE ").append(u.getTable()).append(" SET ").append(change).append(" WHERE ").append(u.getFilter()).append("; ");
		}
		Statement statement = null;
		try {
			statement = this.connection.createStatement();
			statement.execute(sql.toString());
		} catch (final SQLException e) {
			e.printStackTrace();
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if (statement != null) {
				try {
					statement.close();
					return true;
				} catch (final SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return false;
	}

	public Result rowSelect(final String table, String columns, final String filter) {
		if (columns == null || columns.equals("")) {
			columns = "*";
		}
		String sql = "SELECT " + columns + " FROM " + table;
		if (filter != null && !filter.equals("")) {
			sql = sql + " WHERE " + filter;
		}
		sql += ";";
		try {
			final Statement statement = this.connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(sql);
			final ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			final Result result = new Result();
			while (resultSet.next()) {
				final Row row = new Row();
				int i = 1;
				boolean bound = true;
				while (bound) {
					try {
						row.addcolumn(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
					} catch (final SQLException e2) {
						bound = false;
					}
					++i;
				}
				result.addrow(row);
			}
			return result;
		} catch (final SQLException e) {
			e.printStackTrace();
			return new Result();
		}
	}

	public Result rowSelect(final Select s) {
		String sql = "";
		final String columns;
		if (s.getColumns() == null || s.getColumns().equals("")) {
			columns = "*";
		} else {
			columns = s.getColumns();
		}
		String lsql = "SELECT " + columns + " FROM " + s.getTable();
		if (s.getFilter() != null && !s.getFilter().equals("")) {
			lsql = lsql + " WHERE " + s.getFilter();
		}
		lsql += "; ";
		sql += lsql;
		try {
			final Statement statement = this.connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(sql);
			final ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			final Result result = new Result();
			while (resultSet.next()) {
				final Row row = new Row();
				int i = 1;
				boolean bound = true;
				while (bound) {
					try {
						row.addcolumn(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
					} catch (final SQLException e2) {
						bound = false;
					}
					++i;
				}
				result.addrow(row);
			}
			return result;
		} catch (final SQLException e) {
			e.printStackTrace();
			return new Result();
		}
	}

	public boolean custom(final String sql) {
		Statement statement = null;
		try {
			statement = this.connection.createStatement();
			statement.execute(sql);
		} catch (final SQLException e) {
			e.printStackTrace();
			try {
				statement.close();
				return true;
			} catch (final SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				statement.close();
				return true;
			} catch (final SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
}
