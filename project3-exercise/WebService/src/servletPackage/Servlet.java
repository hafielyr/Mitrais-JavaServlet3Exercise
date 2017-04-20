package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Generated;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import data.InformationData;
import data.Trainee;
import netscape.javascript.JSObject;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "this is sample servlet", urlPatterns = { "/Servlet" })
@MultipartConfig
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Trainee> data=new ArrayList<Trainee>();
	ArrayList<Trainee> filter=new ArrayList<Trainee>();
	InformationData id;
	public Servlet(){
		data.add(new Trainee("aaa",20));
		data.add(new Trainee("aaa",21));
		data.add(new Trainee("bbb",20));
		data.add(new Trainee("ccc",21));
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchTerm=request.getParameter("searchTerm");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		if(searchTerm!=null){
			filter=(ArrayList<Trainee>) data.stream().filter(s->s.getName().contains(searchTerm)).collect(Collectors.toList());
			id=new InformationData(filter,"hello from server");
		}	
		else{
			id=new InformationData(data,"hello from server");
		}
		String json=new Gson().toJson(id);
		PrintWriter writer=response.getWriter();
		response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String name=request.getParameter("name");
		PrintWriter writer=response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		if(name!=null){
			filter=(ArrayList<Trainee>) data.stream().filter(s->s.getName().contains(name)).collect(Collectors.toList());
			id=new InformationData(filter,"hello from server");
		}	
		else{
			id=new InformationData(data,"hello from server");
		}
		String json=new Gson().toJson(id);
		response.getWriter().write(json);
	}
}
