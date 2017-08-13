package mob;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ViewCollectors
 */
public class ViewCollectors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
        try {
            int wasteTypeId = Integer.parseInt(request.getParameter("wasteId"));
            
            JSONArray jarr = new JSONArray();
            ResultSet rs = DB.DBConn.getConn().createStatement().executeQuery("SELECT * FROM Collectors WHERE idCollectors IN (SELECT Collectors_idCollectors FROM Collectors_WasteType WHERE WasteType_idWasteType='"+wasteTypeId+"')");
            while (rs.next()) {
                JSONObject job = new JSONObject();
                job.put("id", rs.getInt("idCollectors"));
                job.put("name", rs.getString("name"));
                job.put("address", rs.getString("address"));
                job.put("city", rs.getString("city"));
                job.put("tel", rs.getString("tel"));
                job.put("latitude", rs.getString("latitude"));
                job.put("longitude", rs.getString("longitude"));
                jarr.put(job);
            }
            out.print(jarr);
        } catch (Exception e) {
            e.printStackTrace();
            out.write(e.toString());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
