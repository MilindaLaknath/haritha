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
 * Servlet implementation class ViewBins
 */
public class ViewBins extends HttpServlet {
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
            ResultSet rs = DB.DBConn.getConn().createStatement().executeQuery("SELECT * FROM Bin WHERE idWasteType='"+wasteTypeId+"'");
            while (rs.next()) {
                JSONObject job = new JSONObject();
                job.put("id", rs.getInt("idBin"));
                job.put("name", rs.getString("binName"));
                job.put("wasteType", rs.getString("idWasteType"));
                job.put("collectors", rs.getString("idCollectors"));
                job.put("latitude", rs.getString("latitude"));
                job.put("longitude", rs.getString("longitude"));
                job.put("full", rs.getString("isFull"));
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
