package proxy;

import java.util.ArrayList;

import dao.RiskDao;
import dbc.DatabaseConnection;
import vo.RiskVo;

public class RiskDaoProxy {
	private DatabaseConnection dbc = null;
	private RiskDao dao = null;

	public RiskDaoProxy() {
		try {
			dbc = new DatabaseConnection();
			dao = new RiskDao(dbc.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean add(RiskVo risk) throws Exception {
		boolean flag = false;

		try {
			flag = dao.add(risk);
		} finally {
			dbc.close();
		}

		return flag;
	}

	public ArrayList<RiskVo> getRisks() throws Exception {
		ArrayList<RiskVo> risks = new ArrayList<RiskVo>();
		
		try {
			risks = dao.getRisks();
		} finally {
			dbc.close();
		}
		
		return risks;
	}
}
