package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.RiskDaoProxy;
import vo.RiskVo;

@WebServlet("/addRisk")
public class AddRisk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRisk() {
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

			String riskContent = request.getParameter("riskContent");
			String possibility = request.getParameter("possibility");
			String effectLevel = request.getParameter("effectLevel");
			String thresholdValue = request.getParameter("thresholdValue");
			String submitter = request.getParameter("submitter");
			String tracker = request.getParameter("tracker");
			String state = new String("未发现");
			String description = new String("无");

			if(possibility.equals("high"))
				possibility = "高";
			else if(possibility.equals("middle"))
				possibility = "中";
			else
				possibility = "低";
			
			if(effectLevel.equals("high"))
				effectLevel = "高";
			else if(effectLevel.equals("middle"))
				effectLevel = "中";
			else
				effectLevel = "低";
			
			RiskVo risk = new RiskVo(riskContent, possibility, effectLevel, thresholdValue, submitter, tracker, state, description); 
			RiskDaoProxy riskDaoProxy = new RiskDaoProxy();
			if (riskDaoProxy.add(risk))
				out.write("YES");
			else
				out.write("NO");

			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
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