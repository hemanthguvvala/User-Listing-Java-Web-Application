package com.hkgroups.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hkgroups.entity.ImageDataModel;

/**
 * Servlet implementation class imagecontroller
 */
@WebServlet("/imagecontroller")
public class imagecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		action = action.toLowerCase();
		switch (action) {
		case "imagedatalist": {
			imagedatalist(request, response);
		}
			break;
		default: {
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		action = action.toLowerCase();
		switch (action) {
		case "filesupload": {
			fileupload(request, response);
		}
			break;
		case "imagedatalist": {
			imagedatalist(request, response);
		}
			break;
		default: {
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
		}

	}

	private void imagedatalist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ImageDataModel> imagelist = new FileAccessOperation().imagelist();
		request.setAttribute("imagelist", imagelist);
		request.setAttribute("Image Data List Page", "title");
		request.getRequestDispatcher("imagedata.jsp").forward(request, response);
	}

	private void fileupload(HttpServletRequest request, HttpServletResponse response) {

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> images = upload.parseRequest(request);
			for (FileItem image : images) {
				String imagename = image.getName();
				File file = new File(imagename);
				if (!file.exists()) {
					new FileAccessOperation().addImages(new ImageDataModel(imagename));
					System.out.println(imagename);
				}
				imagedatalist(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
