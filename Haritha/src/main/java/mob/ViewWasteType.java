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
 * Servlet implementation class ViewWasteType
 */
public class ViewWasteType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
        try {
            JSONArray jarr = new JSONArray();
            ResultSet rs = DB.DBConn.getConn().createStatement().executeQuery("SELECT * FROM WasteType");
            while (rs.next()) {
//                int idwt = rs.getInt("idWasteType");
//                String wt = rs.getString("type");
//                out.print(idwt + " " + wt);
//                out.print("<br/>");
//                
                JSONObject job = new JSONObject();
                job.put("id", rs.getInt("idWasteType"));
                job.put("type", rs.getString("type"));
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
