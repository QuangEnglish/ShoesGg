package com.devpro.JavaWeb.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	  @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	                                        AuthenticationException exception) throws IOException, ServletException {
	        
	        System.out.println("exceipton: " + exception.getMessage());
	        String message = "";
	        if(exception.getMessage().contains("null")) {
	        	message = "1";
	        } else if(exception.getMessage().contains("Bad credentials")) {
	        	message = "2";
	        }
	        String targetUrl = determineFailureUrl(request, message);
	        super.setDefaultFailureUrl(targetUrl);
	        super.onAuthenticationFailure(request, response, exception);
	    }

	    private String determineFailureUrl(HttpServletRequest request, String message) {
	        // Check if the request is for admin login or user login
	        String loginPage = request.getParameter("loginPage");
	        if ("admin".equals(loginPage)) {
	            return "/admin/login?login_error=true&message=" + message;
	        }
	        return "/login?login_error=true";
	    }
	

}
