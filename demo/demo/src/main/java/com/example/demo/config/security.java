package com.example.demo.config;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionHandler;

public class security implements WebSecurityConfigurerAdapter {

	@Override
	public ExpressionParser getExpressionParser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluationContext createEvaluationContext(Authentication arg0,
			FilterInvocation arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
