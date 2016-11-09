package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        try {  
            response.setContentType("text/html");  
            response.setHeader("Cache-Control", "no-store");  
            response.setHeader("Pragma", "no-cache");  
            response.setDateHeader("Expires", 0); 
            
	    	String name=request.getParameter("user_name");  
	    	String password=request.getParameter("password");   
            out.write("YES");  
        } finally {   
            out.close();  
        }  
        
//	    request.setAttribute("info", info);//保存错误信息  
//	    request.getRequestDispatcher("Login.jsp").forward(request,response);//跳转  
      
    }  
  
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      doGet(request, response);  
    }  
}  