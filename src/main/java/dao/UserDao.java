package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.UserVo;  

public class UserDao {
	private Connection conn = null;//定义数据库连接对象   
    private PreparedStatement pstmt = null;//定义数据库操作对象
    
    public UserDao(Connection conn){ 
        this.conn = conn;  
    }  
      
    public boolean findLogin(UserVo user) throws Exception {  
        boolean flag = false;  
        try {  
            String sql = "select user_name from users where user_name=? and password=?";  
            pstmt = conn.prepareStatement(sql);//实例化操作  
            pstmt.setString(1, user.getUser_name());  
            pstmt.setString(2, user.getPassword());  
            ResultSet rSet = pstmt.executeQuery();//取得结果   
            
            if(rSet.next()){  
                user.setUser_name(rSet.getString(1));//取得用户名  
                flag = true;        
            }  
  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            if(pstmt != null){  
                try {  
                    pstmt.close();  
                } catch (Exception e) {  
                    throw e;                  
	            }         
	        }  
        }  
        return flag;  
    }
    
    public boolean register(UserVo user) throws Exception {  
        boolean flag = false;  
        try {  
            boolean isExisting = this.isExisting(user);
            
        	System.out.println(isExisting);
            
            if(!isExisting) {
            	String sql = "insert into users (user_name, password) values(?, ?)";  
                pstmt = conn.prepareStatement(sql); 
                pstmt.setString(1, user.getUser_name());  
                pstmt.setString(2, user.getPassword());  
                pstmt.executeUpdate(); 
                flag = true;
            }
        } catch (Exception e) {  
            throw e;  
        }finally{  
            if(pstmt != null){  
                try {  
                    pstmt.close();  
                } catch (Exception e) {  
                    throw e;                  
	            }         
	        }  
        }  
        return flag;  
    }
    
    public boolean isExisting(UserVo user) throws Exception {  
        boolean flag = false;  
        try {  
		    	String sql = "select user_name from users where user_name=?";  
		        pstmt = conn.prepareStatement(sql);//实例化操作  
		        pstmt.setString(1, user.getUser_name());  
		        ResultSet rSet = pstmt.executeQuery();//取得结果   
		        
		        if(rSet.next()){  
		            user.setUser_name(rSet.getString(1));//取得用户名  
		            flag = true;        
		        }
        } catch (Exception e) {  
            throw e;  
        }finally{  
            if(pstmt != null){  
                try {  
                    pstmt.close();  
                } catch (Exception e) {  
                    throw e;                  
	            }         
	        }  
        }  
        return flag;  
    }
}