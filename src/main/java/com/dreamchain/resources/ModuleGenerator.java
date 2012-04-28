package com.dreamchain.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ModuleGenerator {

	public static void generate(File resource, String manifest, String module) throws IOException {
		List<String> files = ManifestParser.getModuleFiles(manifest, module);
		new FileOutputStream(resource);
	}
	
}
