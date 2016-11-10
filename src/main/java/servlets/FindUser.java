package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.UserDaoProxy;
import vo.UserVo;

@WebServlet("/findUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindUser() {
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

			String name = URLDecoder.decode(request.getParameter("user_name"), "UTF-8");
			String password = URLDecoder.decode(request.getParameter("password"), "UTF-8");
			UserVo userVo = new UserVo(name, password);
			UserDaoProxy userDaoProxy = new UserDaoProxy();

			if (userDaoProxy.findLogin(userVo))
				out.write("YES");
			else
				out.write("NO");

			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {}

		// request.setAttribute("info", info);
		// request.getRequestDispatcher("Login.jsp").forward(request,response);

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