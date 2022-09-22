package com.recetA.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Process;
import com.recetA.domain.ProcessDAO;
import com.recetA.domain.Ingredient;
import com.recetA.domain.IngredientDAO;
import com.recetA.domain.Basic;
import com.recetA.domain.BasicDAO;
import com.recetA.domain.FavoritesMember;

public class RecipedetailpageCon2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("detailed recipe ready.");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		try {
			int b_code=Integer.parseInt(request.getParameter("b_code"));
			String n = request.getParameter("n");
			session.setAttribute("n",n);
			System.out.println(n+"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			//p_order, p_explanation, p_url
			ProcessDAO dao = new ProcessDAO();
			IngredientDAO dao2 = new IngredientDAO();
			BasicDAO dao3 = new BasicDAO();
			List<Process> cnt = dao.selectDetailRecipe(b_code);
			List<Ingredient> cnt2 = dao2.selectRecipeingre(b_code);
			List<Basic> cnt3 = dao3.selectbName(b_code);
			if (cnt != null) {
				if(cnt2 != null) {
					if(cnt3 != null) {
						
						session.setAttribute("cnt", cnt);
						session.setAttribute("cnt2", cnt2);
						session.setAttribute("cnt3", cnt3);
						for(Process l : cnt) {
							System.out.println(l.getP_order());
							System.out.println(l.getP_explanation());
							System.out.println(l.getP_url());
							
						}
						for(Ingredient m: cnt2) {
							System.out.println(m.getI_name());
							System.out.println(m.getI_volume());
						}
						for(Basic b : cnt3)
						{
							System.out.println(b.getB_name());
						}
						//session.setAttribute("order", l.getP_order());
						//session.setAttribute("exp", l.getP_explanation());
						//session.setAttribute("url", l.getP_url());
						response.sendRedirect("recipe.jsp");
					}
					}
			} else {
				
				response.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			FavoritesMember Favorites_Data = (FavoritesMember)session.getAttribute("Favorites_Data");
			int b_code = (int)Favorites_Data.getB_code();
			String n = request.getParameter("n");
			session.setAttribute("n",n);
			System.out.println(n+"ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			//p_order, p_explanation, p_url
			ProcessDAO dao = new ProcessDAO();
			IngredientDAO dao2 = new IngredientDAO();
			BasicDAO dao3 = new BasicDAO();
			List<Process> cnt = dao.selectDetailRecipe(b_code);
			List<Ingredient> cnt2 = dao2.selectRecipeingre(b_code);
			List<Basic> cnt3 = dao3.selectbName(b_code);
			if (cnt != null) {
				if(cnt2 != null) {
					if(cnt3 != null) {
						
						session.setAttribute("cnt", cnt);
						session.setAttribute("cnt2", cnt2);
						session.setAttribute("cnt3", cnt3);
						for(Process l : cnt) {
							System.out.println(l.getP_order());
							System.out.println(l.getP_explanation());
							System.out.println(l.getP_url());
							
						}
						for(Ingredient m: cnt2) {
							System.out.println(m.getI_name());
							System.out.println(m.getI_volume());
						}
						for(Basic b : cnt3)
						{
							System.out.println(b.getB_name());
						}
						//session.setAttribute("order", l.getP_order());
						//session.setAttribute("exp", l.getP_explanation());
						//session.setAttribute("url", l.getP_url());
						response.sendRedirect("recipe.jsp");
					}
					}
			} else {
				
				response.sendRedirect("main.jsp");
			}
		}
		
		
		
	}
}
