package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SampleFilterClass extends GenericFilterBean {

	private static final Logger LOG = Logger.getLogger(SampleFilterClass.class.getName());
	
	private static final String CLIENT_HEADER = "ClientId";
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
			FilterChain filterChain) throws IOException, ServletException{
		LOG.info("INside doFilter method of class SampleFilterClass ");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String securityToken = this.getSecurity(request);
		
		// Read the tokens from some constant file/ properties file and verify the same token we received from the request.
		if("TestToken".equalsIgnoreCase(securityToken)){
			filterChain.doFilter(request, response);
		}else{
			
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);			
		}
				
	}
	
	private String getSecurity(HttpServletRequest request){
		LOG.info("INside getSecurity method of class SampleFilterClass ");
		String securityToken = request.getHeader(CLIENT_HEADER);
		return securityToken;
	}
}
