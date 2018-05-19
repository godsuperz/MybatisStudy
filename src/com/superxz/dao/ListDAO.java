package com.superxz.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.superxz.bean.Message;
import com.superxz.db.DBAccess;

/**
 * @author SuperXZ
 *
 */
public class ListDAO {

	
	/**
	 * @description 获取消息列表
	 * @param command
	 * @param description
	 * @return messageList
	 */
	public List<Message> getMessageList(String command, String description) {
		List<Message> messageList = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			// 通过sqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
		
		return messageList;
	}
	
	
	/**
	 * @description 删除单条消息
	 * @param id
	 */
	public int deleteMessage(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			result = sqlSession.delete("Message.deleteMessage", id);
			sqlSession.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
		return result;
	}
	
	/**
	 * @description 批量删除消息
	 * @param idList
	 * @return
	 */
	public int deleteMessages(List<Integer> idList) {
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			result = sqlSession.delete("Message.deleteMessages", idList);
			sqlSession.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
		return result;
	}
	
	public void addMessage(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.selectList("Message.addMessage",message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}

	/*
	 * public List<Message> getMessageList(String command, String description){
	 * List<Message> messageList = new ArrayList<Message>(); try { // 加载驱动
	 * Class.forName("com.mysql.jdbc.Driver"); // 建立连接对象 Connection conn =
	 * DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message",
	 * "root", "root"); // 需要用于查询的sql StringBuilder sql = new
	 * StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1"
	 * ); // sql参数集合 List<String> paramList = new ArrayList<String>(); // 判断用户输入
	 * if(command !=null && !"".equals(command.trim())) {
	 * sql.append(" and COMMAND= ? ");
	 * 
	 * paramList.add(command); } if(description !=null &&
	 * !"".equals(description.trim())) {
	 * sql.append(" and DESCRIPTION like '%' ? '%' ");
	 * 
	 * paramList.add(description); } // 建立sql预处理对象 PreparedStatement statement =
	 * conn.prepareStatement(sql.toString()); // 拼接sql for (int i = 0;i <
	 * paramList.size();i++) { statement.setString(i+1, paramList.get(i)); } //
	 * 获取结果集 ResultSet rs = statement.executeQuery(); while(rs.next()) { Message
	 * message = new Message(); messageList.add(message);
	 * message.setId(rs.getInt("ID")); message.setCommand(rs.getString("COMMAND"));
	 * message.setDescription(rs.getString("DESCRIPTION"));
	 * message.setContent(rs.getString("CONTENT")); } } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * return messageList; }
	 */
}
