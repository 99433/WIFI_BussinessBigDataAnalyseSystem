package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handle.VisitingCycleHandler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class VisitingCycleRateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int length=0;
		String str;
		if((str=req.getParameter("num"))!=null){
			length=Integer.valueOf(str);
		}else {
			resp.getOutputStream().write("N".getBytes());
			return ;
		}
		String[] FlowArr=VisitingCycleHandler.getRate();
		JSONArray ja = JSONArray.fromObject(FlowArr);
		JSONObject jo=new JSONObject();
		jo.put("Flow", ja);
		System.out.println(jo);
		resp.getOutputStream().write(jo.toString().getBytes());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
