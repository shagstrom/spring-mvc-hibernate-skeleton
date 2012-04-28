package com.dreamchain.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class HashGenerator {

	public static String generate(String module, String type) {
		if (type.equals("js")) {
			try {
				List<String> files = ManifestParser.getModuleFiles("./src/main/js/JS.MF", module);
				return fileMD5(files);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("I cannot find src/main/js/JS.MF");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			return null;
		}
	}
	
	private static String fileMD5(List<String> files) throws FileNotFoundException {
		MessageDigest md = createMessageDigest();
		for (String file : files) {
			FileInputStream in = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			try {
				int length;
				while ((length = in.read(buffer)) != -1)
					md.update(buffer, 0, length);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return new String(md.digest());
	}
	
	private static MessageDigest createMessageDigest() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// I can not recover from this.
			throw new RuntimeException(e);
		}
	}

}
