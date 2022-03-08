package com.bomberman.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.UserDao;

@WebServlet("/APIUserGameWon")
public class APIUserGameWon extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = new PrintWriter(resp.getOutputStream(), true);
		
		InputStreamReader reader = new InputStreamReader(
				req.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		
		String data = br.readLine();
		String[] parameters = data.split("&");
		
		String[] parameter1 = parameters[0].split("=");
		String[] parameter2 = parameters[1].split("=");
		
		if(!parameter1[0].equals("id")) {
			writer.println("null");
			return;
		} else if(!parameter2[0].equals("token") || !parameter2[1].equals("8e79d143-8cdf-4abf-96e8-93f0e172a12b")) {
			writer.println("null");
			return;
		}
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao userDao = daoFactory.getUserDao();
		
		userDao.addGameWon(Integer.parseInt(parameter1[1]));
	}

}