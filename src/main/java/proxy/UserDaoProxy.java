package proxy;

import dao.UserDao;
import dbc.DatabaseConnection;
import vo.UserVo;

public class UserDaoProxy {
	private DatabaseConnection dbc = null; 
	private UserDao dao = null;
	
	public UserDaoProxy(){  
        try {  
            dbc = new DatabaseConnection(); 
            dao = new UserDao(dbc.getConnection());   
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

	public boolean findLogin(UserVo user) throws Exception {  
        boolean flag = false;  
        
        try {  
            flag = dao.findLogin(user); 
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }  
        
        return flag;  
    }  
	
	public boolean register(UserVo user) throws Exception {
        boolean flag = false;  
        
        try {  
            flag = dao.register(user); 
        } finally{  
            dbc.close();  
        }  
        
        return flag;  
	}
}
