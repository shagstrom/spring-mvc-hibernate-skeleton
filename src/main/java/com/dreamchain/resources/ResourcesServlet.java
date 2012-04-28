package com.dreamchain.resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourcesServlet extends HttpServlet {
	
	private static final long serialVersionUID = -98896778039664612L;

	private static Map<String, String> resourcesHashes = new HashMap<String, String>();
	
	private MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();

	public ResourcesServlet() {
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempDir = ((File) getServletContext().getAttribute("javax.servlet.context.tempdir")).getAbsolutePath();
		File resource = new File(tempDir + req.getRequestURI());
		if (resource.exists()) {
		}
		resp.setContentType(mimetypesFileTypeMap.getContentType(resource));
		InputStream in = new FileInputStream(resource);
		OutputStream out = resp.getOutputStream();
		IOUtils.inputToOutput(in, out);
		in.close();
		out.close();
	}

	public static String resourceHash(String module, String type) {
		String key = module + "" + type;
		if (!resourcesHashes.containsKey(key)) {
			resourcesHashes.put(key, HashGenerator.generate(module, type));
		}
		return resourcesHashes.get(key);
	}
	
	public enum Type {
		js, css
	}
	
}