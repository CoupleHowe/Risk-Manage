package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.RiskVo;  

public class RiskDao {
	private Connection conn = null;  
    private PreparedStatement pstmt = null;
    
    public RiskDao(Connection conn){ 
        this.conn = conn;  
    }  
    
    public boolean add(RiskVo risk) throws Exception {  
        boolean flag = false;  
        try {    
        	String sql = "insert into risks (riskContent, possibility, effectLevel, thresholdValue, submitter, tracker, state, description) values(?, ?, ?, ?, ?, ?, ?, ?)";  
            pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, risk.getRiskContent());  
            pstmt.setString(2, risk.getPossibility());
            pstmt.setString(3, risk.getEffectLevel());
            pstmt.setString(4, risk.getThresholdValue());
            pstmt.setString(5, risk.getSubmitter());
            pstmt.setString(6, risk.getTracker());
            pstmt.setString(7, risk.getState());
            pstmt.setString(8, risk.getDescription());
            System.out.println(pstmt.toString());
            pstmt.executeUpdate(); 
            flag = true;
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
    
    public ArrayList<RiskVo> getRisks() throws Exception {  
    	ArrayList<RiskVo> risks = new ArrayList<RiskVo>();
    	
        try {    
        	String sql = "select * from risks";  
            pstmt = conn.prepareStatement(sql); 
            ResultSet resultSet = pstmt.executeQuery(); 
            
            if(resultSet.next()){ 
            	System.out.println(resultSet.getString(1));
            	System.out.println(resultSet.getString(2));
//                RiskVo risk = new RiskVo();
                
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
        
        return risks;
    }
}
