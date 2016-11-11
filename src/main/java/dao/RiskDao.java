package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.RiskVo;

public class RiskDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public RiskDao(Connection conn) {
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

			pstmt.executeUpdate();
			flag = true;
		} finally {
			if (pstmt != null) {
				pstmt.close();
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

			while (resultSet.next()) {
				String riskContent = resultSet.getString(1);
				String possibility = resultSet.getString(2);
				String effectLevel = resultSet.getString(3);
				String thresholdValue = resultSet.getString(4);
				String submitter = resultSet.getString(5);
				String tracker = resultSet.getString(6);
				String state = resultSet.getString(7);
				String description = resultSet.getString(8);
				RiskVo risk = new RiskVo(riskContent, possibility, effectLevel, thresholdValue, submitter, tracker, state, description);
				
				risks.add(risk);
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return risks;
	}

	public ArrayList<RiskVo> getRisksBySubmitter(String param) throws Exception {
		ArrayList<RiskVo> risks = new ArrayList<RiskVo>();

		try {
			String sql = "select * from risks where submitter=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param);
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				String riskContent = resultSet.getString(1);
				String possibility = resultSet.getString(2);
				String effectLevel = resultSet.getString(3);
				String thresholdValue = resultSet.getString(4);
				String submitter = resultSet.getString(5);
				String tracker = resultSet.getString(6);
				String state = resultSet.getString(7);
				String description = resultSet.getString(8);
				RiskVo risk = new RiskVo(riskContent, possibility, effectLevel, thresholdValue, submitter, tracker, state, description);
				
				risks.add(risk);
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return risks;
	}

	public ArrayList<RiskVo> getRisksByTracker(String param) throws Exception {
		ArrayList<RiskVo> risks = new ArrayList<RiskVo>();

		try {
			String sql = "select * from risks where tracker=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param);
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				String riskContent = resultSet.getString(1);
				String possibility = resultSet.getString(2);
				String effectLevel = resultSet.getString(3);
				String thresholdValue = resultSet.getString(4);
				String submitter = resultSet.getString(5);
				String tracker = resultSet.getString(6);
				String state = resultSet.getString(7);
				String description = resultSet.getString(8);
				RiskVo risk = new RiskVo(riskContent, possibility, effectLevel, thresholdValue, submitter, tracker, state, description);
				
				risks.add(risk);
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return risks;
	}
}
