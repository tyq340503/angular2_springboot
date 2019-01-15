package com.example.demo.response;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;

public class ConstrainViolateException {
	public static String getMsg(ConstrainViolateException e){
		
		List<String> msg = new ArrayList<>();
		
		for(ConstrainViolate<?> violation : e.getConstrainViolations()){
			msg.add(violation.getMsg());
		}
		String message = StringUtils.join(msg.toArray(),";");
		return message;
	}
}
