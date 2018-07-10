package com.jac.web.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jac.web.dao.BookDAO;
import com.jac.web.model.Book;

@WebServlet("/SaveBookController")
@MultipartConfig(fileSizeThreshold=1024*1024*2, //2MB
                  maxFileSize=1024*1024*10,
                  maxRequestSize=1024*1024*50)

public class SaveBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="images";
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		String savePath="C:\\Users\\1796117\\eclipse-workspace\\apache-tomcat-8.5.32\\webapps\\library\\"+File.separator+SAVE_DIR;
		File fileSaveDir=new File(savePath);
		Part part=request.getPart("picLink");
        
        String fileName=extractFileName(part);
        part.write(savePath+File.separator+fileName);
		try {
			Book book = new Book();
			book.setTitle(request.getParameter("title"));
			book.setAuthor(request.getParameter("author"));
			int publicshYear = Integer.parseInt(request.getParameter("publicshYear"));
			book.setPublishYear(publicshYear);
			
			int id = Integer.parseInt(request.getParameter("id"));
			book.setId(id);
			//images/BriefHistoryTime.jpg
            String filePath="images/"+File.separator+fileName;
            
			book.setPicLink(filePath);
			
			//String pathDB="";
			//String path="C:/Users/Qian/Desktop/";
           // ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
			//List<FileItem> mutifilesfiles = sf.parseRequest(request);
			//for (FileItem fileItem : mutifilesfiles) {
			//	pathDB=fileItem.getName();
			//	fileItem.write(new File(fileItem.getName()));
			//}

			
			//System.out.println("path:"+pathDB);
			BookDAO bookDb=new BookDAO();
			if (id == 0) {
				bookDb.addBook(book);
			} else {
				bookDb.updateBook(book);
			}
			
			
			//System.out.println("file uploaded!");
			ArrayList<Book> list = BookDAO.getAllBook();
			request.setAttribute("booksList", list);
			RequestDispatcher rd = request.getRequestDispatcher("indexAdmin.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String extractFileName(Part part) {
		String contentDisp =part.getHeader("content-disposition");
		String[] items=contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2, s.length()-1);
			}
		}
		return "";
		
		
	}

}
