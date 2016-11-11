package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.RiskDaoProxy;
import vo.RiskVo;

@WebServlet("/showRisk")
public class ShowRisk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowRisk() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			
			String submitter = request.getParameter("submitter");
			String tracker = request.getParameter("tracker");
			
			RiskDaoProxy riskDaoProxy = new RiskDaoProxy();
			if(submitter != null) {
				ArrayList<RiskVo> risks = riskDaoProxy.getRisksBySubmitter(URLDecoder.decode(submitter, "UTF-8"));
				
				String res = new String();
				for(int i = 0; i < risks.size(); i++) {
					res += risks.get(i).toTable();
				}
				
				out.write(res);
			}
			else if(tracker != null) {
				ArrayList<RiskVo> risks = riskDaoProxy.getRisksByTracker(URLDecoder.decode(tracker, "UTF-8"));
				
				String res = new String();
				for(int i = 0; i < risks.size(); i++) {
					res += risks.get(i).toTable();
				}
				
				out.write(res);
			}
			else {
				ArrayList<RiskVo> risks = riskDaoProxy.getRisks();
				
				String res = new String();
				for(int i = 0; i < risks.size(); i++) {
					res += risks.get(i).toTable();
				}
				
				out.write(res);
			}

			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}