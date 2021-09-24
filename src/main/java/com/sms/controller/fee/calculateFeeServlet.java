package com.sms.controller.fee;

import java.io.IOException;
import java.util.Optional;

import com.sms.model.Fee;
import com.sms.model.User;
import com.sms.service.factory.ServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/calculateFee")
public class calculateFeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		String courseCode = req.getParameter("courseCode");
		
		Fee fee = new Fee(userName,courseCode);
		
		HttpSession session = req.getSession();
		
		try {
			Optional<User> feeData = ServiceFactory.getInstance().getService("feeservice").get(fee);
			req.setAttribute("feeData",feeData);
			
		}catch (Exception e)
		{
			req.setAttribute("errMessage", e.getMessage());
		}
		
		req.getRequestDispatcher("/showChallan.jsp").forward(req, resp);
		

}
}
