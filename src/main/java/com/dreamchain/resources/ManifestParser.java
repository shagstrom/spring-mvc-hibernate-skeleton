package com.dreamchain.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManifestParser {

	public static List<String> getModuleFiles(String manifest, String module) throws IOException {
		String path = new File(manifest).getParentFile().getAbsolutePath();
		BufferedReader reader = new BufferedReader(new FileReader(manifest));
		findModule(reader, module);
		List<String> files = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null && !line.trim().startsWith(":")) {
			if (!line.trim().isEmpty()) {
				files.add(path + "/" + line);
			}
		}
		if (files.isEmpty()) {
			throw new RuntimeException("A module must have at least one file.");
		} else {
			return files;
		}
	}
	
	private static void findModule(BufferedReader reader, String module) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.matches(":" + module)) {
				return;
			}
		}
		throw new RuntimeException("Module " + module + " was not found.");
	}
	
}
