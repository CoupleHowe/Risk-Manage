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
//    if(name==null||"".equals(name)){ //�û��������ʽ����  
//        info.add("�û�������Ϊ��");  
//        System.out.println("�û�������Ϊ��");  
//    }  
//  
//    if(password==null||"".equals(password)){//���������ʽ����  
//        info.add("���벻��Ϊ��");  
//        System.out.println("���벻��Ϊ��");  
//    }  
//    if(info.size()==0){  
//        User user=new User();  
//        user.setName(name);  
//        user.setPassword(password);  
//        UserDAOProxy userDAOProxy=new UserDAOProxy();  
//        try {  
//              
//            if(userDAOProxy.findLogin(user)){  
//                info.add("�û���¼�ɹ�����ӭ"+user.getName()+"���٣�");               
//            }else {  
//                info.add("�û���¼ʧ�ܣ�������û���������");  
//            }                         
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
//    request.setAttribute("info", info);//���������Ϣ  
//    request.getRequestDispatcher("Login.jsp").forward(request,response);//��ת  
      
    }  
  
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      doGet(request, response);  
    }  
}  