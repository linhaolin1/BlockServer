package com.lin.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PluginMethodParamDao extends BaseDao {
	// @PostConstruct
	// private void init() {
	// try {
	// Connection conn = dataSource.getConnection();
	// PreparedStatement pre = conn.prepareStatement(
	// "create table if not exists PluginMethodParam( id INTEGER PRIMARY KEY
	// ASC,name TEXT,"
	// + "type INTEGER,position INTEGER,method INTEGER,displayName TEXT);");
	// pre.execute();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public PluginMethodParamEntity findById(int pluginMethodParam) {
	// // TODO Auto-generated method stub
	// try {
	// Connection conn = dataSource.getConnection();
	// PreparedStatement pre = conn.prepareStatement("select * from
	// PluginMethodParam where id= ? ");
	// pre.setInt(1, pluginMethodParam);
	// ResultSet rs = pre.executeQuery();
	// while (rs.next()) {
	// PluginMethodParamEntity p = new PluginMethodParamEntity();
	// p.setType(rs.getInt("type"));
	// p.setName(rs.getString("name"));
	// p.setMethod(rs.getInt("method"));
	// p.setPositon(rs.getInt("position"));
	// p.setDisplayName(rs.getString("displayName"));
	// p.setId(rs.getInt("id"));
	// return p;
	// }
	// return null;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public List<PluginMethodParamEntity> findByMethod(int method) {
	// try {
	// Connection conn = dataSource.getConnection();
	// PreparedStatement pre = conn.prepareStatement("select * from
	// PluginMethodParam where method= ? ");
	// pre.setInt(1, method);
	// ResultSet rs = pre.executeQuery();
	// List<PluginMethodParamEntity> list = new
	// ArrayList<PluginMethodParamEntity>();
	// while (rs.next()) {
	// PluginMethodParamEntity p = new PluginMethodParamEntity();
	// p.setType(rs.getInt("type"));
	// p.setName(rs.getString("name"));
	// p.setMethod(rs.getInt("method"));
	// p.setPositon(rs.getInt("position"));
	// p.setDisplayName(rs.getString("displayName"));
	// p.setId(rs.getInt("id"));
	// list.add(p);
	// }
	// return list;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public boolean insert(PluginMethodParamEntity entity) {
	// try {
	// Connection conn = dataSource.getConnection();
	// PreparedStatement pre = conn.prepareStatement("insert into PluginMethod
	// (name,type,method,positon,displayName)"
	// + " values(?,?,?,?,?)");
	// pre.setString(1, entity.getName());
	// pre.setInt(2, entity.getType());
	// pre.setInt(3, entity.getMethod());
	// pre.setInt(4, entity.getPositon());
	// pre.setString(5, entity.getDisplayName());
	// return pre.execute();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return false;
	// }
	//
	// public boolean update(PluginMethodParamEntity entity) {
	// try {
	// Connection conn = dataSource.getConnection();
	// PreparedStatement pre = conn
	// .prepareStatement("update PluginMethod set
	// name=?,type=?,method=?,positon=?,displayName=? where id=?");
	// pre.setString(1, entity.getName());
	// pre.setInt(2, entity.getType());
	// pre.setInt(3, entity.getMethod());
	// pre.setInt(4, entity.getPositon());
	// pre.setString(5, entity.getDisplayName());
	// pre.setInt(6, entity.getId());
	// return pre.execute();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return false;
	// }
	//
	// public boolean delete(PluginMethodParamEntity entity) {
	// try {
	// Connection conn = dataSource.getConnection();
	// PreparedStatement pre = conn.prepareStatement("delete from PluginMethod
	// where id=?");
	// pre.setInt(1, entity.getId());
	// return pre.execute();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return false;
	// }
	//
	// public void test() {
	//
	// }

}
