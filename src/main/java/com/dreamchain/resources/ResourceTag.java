package com.dreamchain.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.dreamchain.resources.ResourcesServlet.Type;

@SuppressWarnings("serial")
public class ResourceTag extends TagSupport {

	private String module;
	private Type type;
	private Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public int doStartTag() throws JspException {
		if (!map.containsKey(module + "." + type)) {
			JspWriter out = pageContext.getOut();
			try {
				String context = "/" + pageContext.getServletContext().getServletContextName();
				String hash = ResourcesServlet.resourceHash(module, type.toString());
				String src = context + "/resorces/" + module + "-" + hash + "." + type;
				out.println("<script type=\"text/javascript\" src=\"" + src + "\"></script>");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return super.doStartTag();
	}
	
	public void setName(String name) {
		Pattern ext = Pattern.compile("^(\\.*)*([^\\.])*$");
		Matcher m = ext.matcher(name);
		if (m.find()) {
			throw new IllegalArgumentException("Valid extensions are 'js' and 'css'.");
		}
		try {
			module = m.group(1);
			type = Type.valueOf(m.group(2));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Valid extensions are 'js' and 'css'.");
		}
	}
	
}
