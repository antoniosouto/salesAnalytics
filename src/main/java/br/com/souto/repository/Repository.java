package br.com.souto.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
	
	public static List<String> getRegisterLinesList(String path)
			throws IOException {
		return Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.toList());
	}
	
	public static List<String> getRegisterLinesList(Path path)
			throws IOException {
		return Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.toList());
	}
	
	public static void saveReport(String report, String path)
			throws IOException {
	    byte[] strToBytes = report.getBytes();
	    Files.write(Paths.get(path), strToBytes);
	}

	public static void saveReport(String report, Path path)
			throws IOException {
	    byte[] strToBytes = report.getBytes();
	    Files.write(path, strToBytes);
	}
}
