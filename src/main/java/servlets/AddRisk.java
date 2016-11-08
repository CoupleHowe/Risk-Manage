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
        // TODO Auto-generated constructor stub  
    }  
  
    /** 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter writer = response.getWriter();
    	writer.print(true);
//    String name=request.getParameter("name");  
//    String password=request.getParameter("password");  
//    List<String> info=new ArrayList<String>();  
//    if(name==null||"".equals(name)){ //用户名输入格式问题  
//        info.add("用户名不能为空");  
//        System.out.println("用户名不能为空");  
//    }  
//  
//    if(password==null||"".equals(password)){//密码输入格式问题  
//        info.add("密码不能为空");  
//        System.out.println("密码不能为空");  
//    }  
//    if(info.size()==0){  
//        User user=new User();  
//        user.setName(name);  
//        user.setPassword(password);  
//        UserDAOProxy userDAOProxy=new UserDAOProxy();  
//        try {  
//              
//            if(userDAOProxy.findLogin(user)){  
//                info.add("用户登录成功，欢迎"+user.getName()+"光临！");               
//            }else {  
//                info.add("用户登录失败，错误的用户名和密码");  
//            }                         
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
//    request.setAttribute("info", info);//保存错误信息  
//    request.getRequestDispatcher("Login.jsp").forward(request,response);//跳转  
      
    }  
  
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      doGet(request, response);  
    }  
}  