

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("name");
		String upass = request.getParameter("pass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://cs336db.curocjyahh92.us-east-2.rds.amazonaws.com/loginPage","Group7Databases","Ourproject1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select uname,upass from loginPage.users where uname='"+uname+"' and upass='"+upass+"'");
			if (rs.next()) {
				response.sendRedirect("Welcome.jsp");//?name="+rs.getString("uname"));
		        HttpSession session = request.getSession();
		        session.setAttribute("uname", uname);

				
			
			} else {
				//response.sendRedirect("http://ec2-13-59-57-224.us-east-2.compute.amazonaws.com:8080/LoginPage/Welcome.jsp");
				out.println("Wrong username or password");
				//response.sendRedirect("http://ec2-13-59-57-224.us-east-2.compute.amazonaws.com:8080/LoginPage/home.jsp");
			}
			//response.sendRedirect("http://ec2-13-59-57-224.us-east-2.compute.amazonaws.com:8080/LoginPage/Welcome.jsp");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
