package com.study.product.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.product.dto.UserDto;
import com.study.product.utils.RequestUtil;
import com.study.product.utils.ResponseEntity;


@WebServlet("/auth/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SigninServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto dbUser = (UserDto) request.getServletContext().getAttribute("dbUser");
		
		UserDto signinUserDto = RequestUtil.convertJsonData(request, UserDto.class);
		
		boolean isMatchUsername =  Objects.equals(dbUser.getUsername(), signinUserDto.getUsername());
		boolean isMatchPassword = Objects.equals(dbUser.getPassword(), signinUserDto.getPassword());
		
		if(!(isMatchUsername && isMatchPassword)) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("errorMessage", "사용자 정보를 다시 확인하세요.");
			ResponseEntity.ofJson(response, 403, errorMap);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("principalUser", dbUser);
		
		ResponseEntity.ofJson(response, 200, dbUser);
	}
}
