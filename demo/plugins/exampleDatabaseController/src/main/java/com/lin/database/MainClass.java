package com.lin.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lin.constants.BlockConstant;
import com.lin.database.req.ComplexJoinQueryReq;
import com.lin.database.req.DeleteReq;
import com.lin.database.req.DirectSqlReq;
import com.lin.database.req.SaveReq;
import com.lin.database.req.SelectOneReq;
import com.lin.database.req.SelectReq;
import com.lin.database.req.StatReq;
import com.lin.database.req.UpdateReq;
import com.lin.database.resp.ComplexJoinQueryResp;
import com.lin.database.resp.DeleteResp;
import com.lin.database.resp.DirectSqlResp;
import com.lin.database.resp.SaveResp;
import com.lin.database.resp.SelectOneResp;
import com.lin.database.resp.SelectResp;
import com.lin.database.resp.StatResp;
import com.lin.database.resp.UpdateResp;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.InitParam;
import com.lin.interfacePackage.Annotation.ParamType;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotationClass;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;

@com.lin.interfacePackage.Annotation.PluginAnnotation(name = "测试数据库", introduce = "没什么好说的", belongType = 1)
public class MainClass extends AbstractVariableParamPlugin {

	@InitParam
	Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@PluginMethodAnnotation(name = "更新数据")
	public boolean update(UpdateReq req, UpdateResp resp) throws SQLException {

		if (req.getTableName() == null)
			return false;
		Integer id = Integer.parseInt(String.valueOf(req.getMap().get("id")));
		req.getMap().remove("id");

		PreparedStatement pre = conn.prepareStatement(getUpdateSQL(req.getTableName(), req.getMap()));
		int keyPosition = 1;
		for (Object key : req.getMap().keySet()) {
			pre.setObject(keyPosition, req.getMap().get(key));
			keyPosition++;
		}
		pre.setInt(keyPosition, id);
		return pre.execute();
	}

	@PluginMethodAnnotation(name = "删除数据")
	public boolean delete(DeleteReq req, DeleteResp resp) throws SQLException {

		if (req.getTableName() == null)
			return false;
		PreparedStatement pre = conn.prepareStatement(getDeleteSQL(req.getTableName(), req.getMap()));
		int keyPosition = 1;
		if (req.getMap() != null && req.getMap().size() > 0) {
			for (Object key : req.getMap().keySet()) {
				try {
					String str = (String) req.getMap().get(key);
					JSONArray tempArray = JSON.parseArray(str);
					continue;
				} catch (Exception e) {
					pre.setObject(keyPosition, req.getMap().get(key));
				}
				keyPosition++;
			}
		}
		return pre.execute();
	}

	@PluginMethodAnnotation(name = "查询数据")
	public void select(SelectReq req, SelectResp resp) throws SQLException {
		if (req.getTableName() == null)
			return;

		PreparedStatement pre = conn.prepareStatement(
				getFindPropertySQL(req.getTableName(), req.getMap(), req.getLimitRow(), req.getPage(), req.getOrder()));
		int keyPosition = 1;
		if (req.getMap() != null && req.getMap().size() > 0) {
			for (Object key : req.getMap().keySet()) {
				try {
					String str = (String) req.getMap().get(key);
					JSONArray tempArray = JSON.parseArray(str);
					continue;
				} catch (Exception e) {
					pre.setObject(keyPosition, req.getMap().get(key));
				}

				keyPosition++;
			}
		}
		ResultSet rs = pre.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();

		List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				map.put(meta.getColumnLabel(i), rs.getObject(i));
			}
			ar.add(map);
		}
		resp.setResult(ar);

	}

	@PluginMethodAnnotation(name = "模糊查询")
	public void selectLike(SelectReq req, SelectResp resp) throws SQLException {
		if (req.getTableName() == null)
			return;

		PreparedStatement pre = conn.prepareStatement(
				getLikeropertySQL(req.getTableName(), req.getMap(), req.getLimitRow(), req.getPage(), req.getOrder()));
		int keyPosition = 1;
		if (req.getMap() != null && req.getMap().size() > 0) {
			for (Object key : req.getMap().keySet()) {
				try {
					String str = (String) req.getMap().get(key);
					JSONArray tempArray = JSON.parseArray(str);
					continue;
				} catch (Exception e) {
					pre.setObject(keyPosition, req.getMap().get(key));
				}
				System.out.println("key=" + key + " " + req.getMap().get(key));

				keyPosition++;
			}
		}
		ResultSet rs = pre.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();

		List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				map.put(meta.getColumnLabel(i), rs.getObject(i));
			}
			ar.add(map);
		}
		resp.setResult(ar);

	}

	@PluginMethodAnnotation(name = "唯一查询")
	public void selectOne(SelectOneReq req, SelectOneResp resp) throws SQLException {
		if (req.getTableName() == null)
			return;
		PreparedStatement pre = conn.prepareStatement(getFindOnePropertySQL(req.getTableName(), req.getMap()));
		int keyPosition = 1;
		if (req.getMap() != null && req.getMap().size() > 0) {
			for (Object key : req.getMap().keySet()) {
				try {
					String str = (String) req.getMap().get(key);
					JSONArray tempArray = JSON.parseArray(str);
					continue;
				} catch (Exception e) {
					pre.setObject(keyPosition, req.getMap().get(key));
				}

				keyPosition++;
			}
		}
		ResultSet rs = pre.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();

		List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				map.put(meta.getColumnLabel(i), rs.getObject(i));
			}
			resp.setObject(map);
			break;
		}

	}

	@PluginMethodAnnotation(name = "直接SQL")
	public void directSql(DirectSqlReq req, DirectSqlResp resp) throws SQLException {
		PreparedStatement pre = conn.prepareStatement(getDirectSQL(req.getSql(), req.getPage(), req.getLimitRow()));
		if (req.getMap() != null && req.getMap().size() > 0) {
			Set<String> keys = req.getMap().keySet();
			List<Integer> list = new ArrayList<Integer>();
			for (String s : keys) {
				list.add(Integer.parseInt(s));
			}
			Collections.sort(list);
			int keyPosition = 1;
			for (Integer i : list) {
				pre.setObject(keyPosition, req.getMap().get(String.valueOf(i)));
				keyPosition++;
			}
		}

		if (req.getSql().toLowerCase().startsWith("select")) {
			ResultSet rs = pre.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();

			List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					map.put(meta.getColumnLabel(i), rs.getObject(i));
				}
				ar.add(map);
			}
			resp.setResult(ar);
		} else {
			pre.execute();
		}
	}

	private String getDirectSQL(String origin, String page, String limitRow) {
		StringBuilder sql = new StringBuilder();
		sql.append(origin);

		String sqlServerType;
		try {
			sqlServerType = conn.getMetaData().getDatabaseProductName();

			switch (sqlServerType) {
			case "SQLite":
				appendPageSQLForMysql(sql, page, limitRow);
				break;
			case "MySQL":
				appendPageSQLForMysql(sql, page, limitRow);
				break;
			case "Microsoft SQL Server":
				appendPageSQLForMssql(sql, page, limitRow);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql.toString();

	}

	@PluginMethodAnnotation(name = "复杂模糊查询")
	public void complexJoinQuery(ComplexJoinQueryReq req, ComplexJoinQueryResp resp) throws SQLException {
		List<String> valueArray = new ArrayList<String>();
		System.out.println();
		PreparedStatement pre = conn.prepareStatement(getComplexJoinQuerySQL(req.getSql(), req.getKeyMap(),
				req.getValueMap(), valueArray, req.getOrder(), req.getPage(), req.getLimitRow()));
		if (valueArray.size() > 0) {
			int keyPosition = 1;
			for (String value : valueArray) {
				pre.setObject(keyPosition, value);
				keyPosition++;
			}
		}

		if (req.getSql().toLowerCase().startsWith("select")) {
			ResultSet rs = pre.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();

			List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					map.put(meta.getColumnLabel(i), rs.getObject(i));
				}
				ar.add(map);
			}
			resp.setResult(ar);
		} else {
			pre.execute();
		}
	}

	private String getComplexJoinQuerySQL(String origin, Map<String, Object> keyMap, Map<String, Object> valueMap,
			List<String> ar, String orderBy, String page, String pageSize) {
		StringBuilder sql = new StringBuilder();
		sql.append(origin);
		if (keyMap != null && keyMap.size() > 0) {
			sql.append(" where ");
			ar.addAll(whereLikeString(keyMap, valueMap, sql, orderBy, pageSize, page));
			
		}
		
		if (!StringUtils.isBlank(orderBy))
			sql.append(" order by " + orderBy);
		else {
		}

		String sqlServerType;
		try {
			sqlServerType = conn.getMetaData().getDatabaseProductName();

			switch (sqlServerType) {
			case "SQLite":
				appendPageSQLForMysql(sql, page, pageSize);
				break;
			case "MySQL":
				appendPageSQLForMysql(sql, page, pageSize);
				break;
			case "Microsoft SQL Server":
				appendPageSQLForMssql(sql, page, pageSize);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql.toString();
	}

	private List<String> whereLikeString(Map<String, Object> keyMap, Map<String, Object> valueMap, StringBuilder sql,
			String orderBy, String limitRow, String page) {
		// TODO Auto-generated method stub
		List<String> ar = new ArrayList<String>();

		for (String position : valueMap.keySet()) {
			String key = String.valueOf(keyMap.get("key " + position.replaceAll("([a-z]+[ ])([\\d])", "$2")));
			String value = String.valueOf(valueMap.get(position));
			if (StringUtils.isBlank(key) || StringUtils.isBlank(value))
				continue;

			String method = "";
			if (value.startsWith(">=")) {
				method = ">=";
				value = value.substring(2);

			} else if (value.startsWith("<=")) {
				method = "<=";
				value = value.substring(2);
			} else if (value.startsWith("<>")) {
				method = "!=";
				value = value.substring(2);
			} else if (value.startsWith(">")) {
				method = ">";
				value = value.substring(1);
			} else if (value.startsWith("<")) {
				method = "<";
				value = value.substring(1);
			} else if (value.startsWith("=")) {
				method = "=";
				value = value.substring(1);
			} else if (value.startsWith("like")) {
				method = "like";
				value = "%" + value.substring(4) + "%";
			} else if (value.startsWith("not like")) {
				method = "not like";
				value = "%" + value.substring(8) + "%";
			}

			if (StringUtils.isBlank(key) || StringUtils.isBlank(value) || value.equals("%%"))
				continue;

			ar.add(value);
			sql.append(String.valueOf(key) + " " + method + " ? and ");
		}
		
		if (ar.size() > 0)
			sql.setLength(sql.length() - 5);
		else {
			sql.setLength(sql.length() - 6);
		}

		

		return ar;
	}

	private String getFindOnePropertySQL(String tableName, Map map) throws SQLException {
		// TODO Auto-generated method stub
		return getFindPropertySQL(tableName, map, "1", null, null);
	}

	private String getSaveSQL(String tableName, Map<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into ");
		sb.append(tableName);
		sb.append(" (");
		for (Object key : map.keySet()) {
			sb.append(String.valueOf(key) + ",");
		}
		sb.setLength(sb.length() - 1);
		sb.append(") values(");
		for (int i = 0; i < map.size(); i++)
			sb.append("?,");

		sb.setLength(sb.length() - 1);
		sb.append(")");
		return sb.toString();
	}

	private String getUpdateSQL(String tableName, Map<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set ");
		for (Object key : map.keySet()) {
			sb.append(String.valueOf(key) + "=?,");
		}
		sb.setLength(sb.length() - 1);
		sb.append(" where id=?");
		return sb.toString();
	}

	private String getDeleteSQL(String tableName, Map<String, String> map) {
		StringBuilder sql = new StringBuilder();

		sql.append("delete from ");
		sql.append(tableName);
		if (map != null && map.size() > 0) {
			sql.append(" where ");
			for (Object key : map.keySet()) {
				String str = map.get(key);
				try {
					JSONArray array = JSON.parseArray(str);
					sql.append(String.valueOf(key) + " in (");
					if (array.size() > 0) {
						for (int i = 0; i < array.size(); i++) {
							sql.append(array.get(i) + ",");
						}
						sql.setLength(sql.length() - 1);
					}
					sql.append(") and ");
				} catch (Exception e) {
					sql.append(String.valueOf(key) + " = ? and ");
				}
			}
			sql.setLength(sql.length() - 5);
		}
		return sql.toString();
	}

	private String getFindPropertySQL(String tableName, Map<String, String> map, String limitRow, String page,
			String orderBy) throws SQLException {
		String sqlServerType = conn.getMetaData().getDatabaseProductName();

		switch (sqlServerType) {
		case "SQLite":
			return getFindPropertySQLForMysql(tableName, map, limitRow, page, orderBy);
		case "MySQL":
			return getFindPropertySQLForMysql(tableName, map, limitRow, page, orderBy);
		case "Microsoft SQL Server":
			return getFindPropertySQLForMsSql(tableName, map, limitRow, page, orderBy);
		}
		return "";

	}

	private String getLikeropertySQL(String tableName, Map<String, String> map, String limitRow, String page,
			String orderBy) throws SQLException {
		String sqlServerType = conn.getMetaData().getDatabaseProductName();

		switch (sqlServerType) {
		case "SQLite":
			return getLikePropertySQLForMysql(tableName, map, limitRow, page, orderBy);
		case "MySQL":
			return getLikePropertySQLForMysql(tableName, map, limitRow, page, orderBy);
		case "Microsoft SQL Server":
			return getLikePropertySQLForMsSql(tableName, map, limitRow, page, orderBy);
		}
		return "";
	}

	private void whereLikeString(Map<String, String> map, StringBuilder sql) {
		Map<String, String> tempMap = new HashMap<String, String>();
		tempMap.putAll(map);

		for (String key : tempMap.keySet()) {
			String str = tempMap.get(key);
			String method = "";
			if (str.startsWith(">=")) {
				method = ">=";
				map.put(key, str.substring(2));
			} else if (str.startsWith("<=")) {
				method = "<=";
				map.put(key, str.substring(2));
			} else if (str.startsWith("<>")) {
				method = "!=";
				map.put(key, str.substring(2));
			} else if (str.startsWith(">")) {
				method = ">";
				map.put(key, str.substring(1));
			} else if (str.startsWith("<")) {
				method = "<";
				map.put(key, str.substring(1));
			} else if (str.startsWith("=")) {
				method = "=";
				map.put(key, str.substring(1));
			} else if (str.startsWith("like")) {
				method = "like";
				map.put(key, "%" + str.substring(4) + "%");
			} else if (str.startsWith("not like")) {
				method = "not like";
				map.put(key, "%" + str.substring(8) + "%");
			}

			sql.append(String.valueOf(key) + " " + method + " ? and ");
		}
	}

	private String getLikePropertySQLForMsSql(String tableName, Map<String, String> map, String limitRow, String page,
			String orderBy) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append(" * from ");
		sql.append(tableName);
		if (map != null && map.size() > 0) {
			sql.append(" where ");
			whereLikeString(map, sql);
			sql.setLength(sql.length() - 5);
		}
		if (!StringUtils.isBlank(orderBy))
			sql.append(" order by " + orderBy);
		else {
			if (!StringUtils.isBlank(limitRow)) {
				String[] keys = map.keySet().toArray(new String[map.size()]);
				sql.append(" order by " + keys[0]);
			}
		}

		appendPageSQLForMssql(sql, page, limitRow);
		return sql.toString();
	}

	private String getLikePropertySQLForMysql(String tableName, Map<String, String> map, String limitRow, String page,
			String orderBy) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from ");
		sql.append(tableName);
		if (map != null && map.size() > 0) {
			sql.append(" where ");

			whereLikeString(map, sql);
			sql.setLength(sql.length() - 5);
		}
		if (!StringUtils.isBlank(orderBy))
			sql.append(" order by " + orderBy);

		appendPageSQLForMysql(sql, page, limitRow);
		System.out.println("mysql=" + sql.toString());
		return sql.toString();
	}

	private void appendPageSQLForMysql(StringBuilder sql, String page, String limitRow) {
		if (!StringUtils.isBlank(limitRow))
			sql.append(" limit " + limitRow);

		if (!StringUtils.isBlank(page) && !StringUtils.isBlank(limitRow)) {
			sql.append(" offset " + (Integer.parseInt(page) - 1) * Integer.parseInt(limitRow));
		}

	}

	private void appendPageSQLForMssql(StringBuilder sql, String page, String limitRow) {
		if (!StringUtils.isBlank(limitRow) && StringUtils.isBlank(page)) {
			page = "1";
		}

		if (!StringUtils.isBlank(page)) {
			sql.append(" offset " + (Integer.parseInt(page) - 1) * Integer.parseInt(limitRow) + " row");
		}

		if (!StringUtils.isBlank(limitRow))
			sql.append(" fetch next " + limitRow + " row only");
	}

	private String getFindPropertySQLForMsSql(String tableName, Map<String, String> map, String limitRow, String page,
			String orderBy) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append(" * from ");
		sql.append(tableName);
		if (map != null && map.size() > 0) {
			sql.append(" where ");
			for (Object key : map.keySet()) {
				String str = map.get(key);
				try {
					JSONArray array = JSON.parseArray(str);
					sql.append(String.valueOf(key) + " in ( ");
					if (array.size() > 0) {
						for (int i = 0; i < array.size(); i++) {
							sql.append(array.get(i) + ",");
						}
						sql.setLength(sql.length() - 1);
					}

					sql.append(") and ");

				} catch (Exception e) {
					sql.append(String.valueOf(key) + " = ? and ");
				}
			}
			sql.setLength(sql.length() - 5);
		}
		if (!StringUtils.isBlank(orderBy))
			sql.append(" order by " + orderBy);
		else {
			if (!StringUtils.isBlank(limitRow)) {
				String[] keys = map.keySet().toArray(new String[map.size()]);
				sql.append(" order by " + keys[0]);
			}
		}
		appendPageSQLForMssql(sql, page, limitRow);
		System.out.println("mssql=" + sql.toString());
		return sql.toString();
	}

	private String getFindPropertySQLForMysql(String tableName, Map<String, String> map, String limitRow, String page,
			String orderBy) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from ");
		sql.append(tableName);
		if (map != null && map.size() > 0) {
			sql.append(" where ");
			for (Object key : map.keySet()) {
				String str = map.get(key);
				try {
					JSONArray array = JSON.parseArray(str);
					sql.append(String.valueOf(key) + " in ( ");
					if (array.size() > 0) {
						for (int i = 0; i < array.size(); i++) {
							sql.append(array.get(i) + ",");
						}
						sql.setLength(sql.length() - 1);
					}

					sql.append(") and ");

				} catch (Exception e) {
					sql.append(String.valueOf(key) + " = ? and ");
				}
			}
			sql.setLength(sql.length() - 5);
		}
		if (!StringUtils.isBlank(orderBy))
			sql.append(" order by " + orderBy);

		appendPageSQLForMysql(sql, page, limitRow);

		return sql.toString();
	}

	public Integer getParamType(String type) {
		// TODO Auto-generated method stub
		switch (type) {
		case "INTEGER":
			return BlockConstant.param_type_number;
		case "TEXT":
			return BlockConstant.param_type_text;
		case "DATE":
			return BlockConstant.param_type_date;
		default:
			break;
		}
		return BlockConstant.param_type_invalid;
	}

	@Override
	public void getParams(VariableParamReq req, VariableParamResp resp) {
		// TODO Auto-generated method stub
		if (req.getMethodName() == null)
			return;

		switch (req.getMethodName()) {
		case "directSql":
			try {
				Integer count = Integer.parseInt(req.getMap().get("设置数量"));
				List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
				for (int i = 1; i <= count; i++) {
					PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(String.valueOf(i),
							ParamType.Optional, null, null, null, "map");
					list.add(clz);
				}
				resp.setInArgs(list);
				return;
			} catch (Exception e) {

			}
			break;
		case "complexJoinQuery":
			try {
				Integer count = Integer.parseInt(req.getMap().get("设置数量"));
				List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
				for (int i = 1; i <= count; i++) {
					PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(
							"key " + String.valueOf(i), ParamType.Optional, null, null, null, "keyMap");
					list.add(clz);
				}
				for (int i = 1; i <= count; i++) {
					PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(
							"value " + String.valueOf(i), ParamType.Optional, null, null, null, "valueMap");
					list.add(clz);
				}
				resp.setInArgs(list);
				return;
			} catch (Exception e) {

			}
			break;
		}

		List<PluginMethodParamAnnotationClass> list = getTaleInfo(req.getMap().get("表名"));

		switch (req.getMethodName()) {
		case "save":
			resp.setInArgs(list);
			break;
		case "update":
			resp.setInArgs(list);
			break;
		case "delete":
			resp.setInArgs(list);
			break;
		case "select":
			resp.setInArgs(list);
			break;
		case "stats":
			resp.setInArgs(list);
			break;
		case "selectOne":
			resp.setInArgs(list);
			break;
		case "selectLike":
			resp.setInArgs(list);
			break;
		default:
			break;
		}

	}

	private List<PluginMethodParamAnnotationClass> getTaleInfo(String tableName) {
		// TODO Auto-generated method stub

		try {
			String sqlServerType = conn.getMetaData().getDatabaseProductName();

			switch (sqlServerType) {
			case "SQLite":
				return getTableInfoSQLite(conn, tableName);
			case "MySQL":
				return getTableInfoMysql(conn, tableName);
			case "Microsoft SQL Server":
				return getTableInfoSqlserver(conn, tableName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<PluginMethodParamAnnotationClass> getTableInfoSqlserver(Connection conn2, String tableName) {
		// TODO Auto-generated method stub
		List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();

		if (StringUtils.isBlank(tableName)) {
			return list;
		}

		try {
			PreparedStatement pre = conn
					.prepareStatement(new StringBuilder("exec sp_columns ").append(tableName).append(";").toString());

			final ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(rs.getString("COLUMN_NAME"),
						ParamType.Optional, null, null, null, "map");
				list.add(clz);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	private List<PluginMethodParamAnnotationClass> getTableInfoMysql(Connection conn, String tableName) {
		// TODO Auto-generated method stub
		List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();

		if (StringUtils.isBlank(tableName)) {
			return list;
		}

		try {
			PreparedStatement pre = conn
					.prepareStatement(new StringBuilder("desc ").append(tableName).append(";").toString());

			final ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(rs.getString("Field"),
						ParamType.Optional, null, null, null, "map");
				list.add(clz);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	private List<PluginMethodParamAnnotationClass> getTableInfoSQLite(Connection conn, String tableName) {
		// TODO Auto-generated method stub
		List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
		if (StringUtils.isBlank(tableName)) {
			return list;
		}

		try {
			PreparedStatement pre = conn.prepareStatement(
					new StringBuilder("pragma table_info (\"").append(tableName).append("\");").toString());

			final ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(rs.getString(2),
						ParamType.Optional, null, null, null, "map");
				list.add(clz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@PluginMethodAnnotation(name = "保存数据")
	public void save(SaveReq req, SaveResp resp) throws SQLException {
		if (req.getTableName() == null)
			return;

		PreparedStatement pre = conn.prepareStatement(getSaveSQL(req.getTableName(), req.getMap()),
				Statement.RETURN_GENERATED_KEYS);
		int keyPosition = 1;
		for (Object key : req.getMap().keySet()) {
			pre.setObject(keyPosition, req.getMap().get(key));
			keyPosition++;
		}
		pre.execute();
		ResultSet rs = pre.getGeneratedKeys();
		int id = 0;// 保存生成的ID
		if (rs != null && rs.next()) {

			id = rs.getInt(1);
		}
		resp.setResult(String.valueOf(id));
	}

	@PluginMethodAnnotation(name = "统计数据")
	public void stats(StatReq req, StatResp resp) throws SQLException {
		if (req.getTableName() == null)
			return;
		PreparedStatement pre = conn.prepareStatement(getStatsSQL(req.getTableName(), req.getSelectColumns(),
				req.getMap(), req.getGroupColumn(), req.getOrderColumns(), req.getLimitRow()));

		int keyPosition = 1;
		if (req.getMap() != null && req.getMap().size() > 0)
			for (Object key : req.getMap().keySet()) {
				try {
					String str = (String) req.getMap().get(key);
					JSON.parseArray(str);
					continue;
				} catch (Exception e) {
					pre.setObject(keyPosition, req.getMap().get(key));
				}

				keyPosition++;

			}
		ResultSet rs = pre.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();

		List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				map.put(meta.getColumnLabel(i), rs.getObject(i));
			}
			ar.add(map);
		}
		resp.setResult(ar);
	}

	private String getStatsSQL(String tableName, String selectColumns, Map<String, String> map, String groupColumn,
			String orderColumns, String limitRow) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("select " + selectColumns);
		if (!StringUtils.isBlank(groupColumn))
			sql.append("," + groupColumn + " ");

		sql.append(" from ");
		sql.append(tableName);
		if (map != null && map.size() > 0) {
			sql.append(" where ");
			for (Object key : map.keySet()) {
				String str = map.get(key);
				try {
					JSONArray array = JSON.parseArray(str);
					sql.append(String.valueOf(key) + " in ( ");
					if (array.size() > 0) {
						for (int i = 0; i < array.size(); i++) {
							sql.append(array.get(i) + ",");
						}
						sql.setLength(sql.length() - 1);
					}

					sql.append(") and ");

				} catch (Exception e) {
					sql.append(String.valueOf(key) + " = ? and ");
				}
			}
			sql.setLength(sql.length() - 5);
		}
		if (!StringUtils.isBlank(groupColumn))
			sql.append(" group by " + groupColumn);

		if (!StringUtils.isBlank(orderColumns))
			sql.append(" order by " + orderColumns);

		if (!StringUtils.isBlank(limitRow))
			sql.append(" limit " + limitRow);

		return sql.toString();

	}

	// private void getSlowQuery() {
	//
	// try {
	// Connection conn = source.getConnection();
	// PreparedStatement pre = conn.prepareStatement("select * from slow_log");
	// int keyPosition = 1;
	// for (Object key : req.getMap().keySet()) {
	// pre.setObject(keyPosition, req.getMap().get(key));
	// keyPosition++;
	// }
	// pre.execute();
	// } catch (Exception e) {
	// e.printStackTrace();
	// return;
	// }
	// }
	
}
