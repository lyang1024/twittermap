package getTweets.servlet;

import java.io.*;
import java.util.List;

//import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import getTweets.dao.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
@SuppressWarnings("serial")
public class GetHashtags extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		String statename = request.getParameter("statename");
        	//String info; 

		TopTweets tts = new TopTweets();
//		String ip = req.getHeader("x-forwarded-for"); 
//		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//		ip = req.getHeader("Proxy-Client-IP"); 
//		} 
//		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//		ip = req.getHeader("WL-Proxy-Client-IP"); 
//		} 
//		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//		ip = req.getRemoteAddr(); 
//		} 
		try {
			
			tts.setStatename(statename);
			GetTopsDao dao = new GetTopsDao();
			TopTweets ttr = dao.getTopTweets(tts);
			String result = ttr.getHashtags();
			if (result!=null){
				String[] res=result.split("_");
				//info = "Get hashtags successfully";
				//request.setAttribute("info", info);
				//request.setAttribute("statename",statename);
				request.setAttribute("hashtags", res[0]);
				request.setAttribute("top1",res[0]);
				request.setAttribute("top2",res[1]);
				request.setAttribute("top3",res[2]);
				request.setAttribute("top4",res[3]);
				request.setAttribute("top5",res[4]);
				request.setAttribute("top", result);
				request.getRequestDispatcher("ht.jsp").forward(request, response);
			}
			else{
				//info = "State name not found!";
				//request.setAttribute("info", info);
				request.getRequestDispatcher("ht.jsp").forward(request, response);
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
