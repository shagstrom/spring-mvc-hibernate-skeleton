package com.dreamchain.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

	public static void inputToOutput(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[8192];
		int length;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
	}
	
}
