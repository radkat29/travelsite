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
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		PrintWriter out = response.getWriter();
		doGet(request, response);
		String uname = request.getParameter("name");
		String upass = request.getParameter("pass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://cs336db.curocjyahh92.us-east-2.rds.amazonaws.com/loginPage","Group7Databases","Ourproject1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select uname from loginPage.users where uname='"+uname+"'");
			if (!rs.next()) {
				response.sendRedirect("WelcomeNewUser.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				session.setAttribute("upass", upass);
				Statement st2 = con.createStatement();
				String query = "insert into loginPage.users values('" + uname + "', '" + upass + "')";
		
				st2.executeUpdate(query);
				//ResultSet rs1 = stmt.executeQuery("insert into loginPage.users(uname, upass) values (" + uname + "," + upass + ")");
				
			
			} else {
				out.println("User already exists!!!!");
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

