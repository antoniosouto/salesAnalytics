package br.com.souto.repository;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.MalformedLinkException;

public class Repository {
	
	public static List<String> getRegisterLinesList(Path path)
			throws IOException {
		try {
			return Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.toList());
		} catch (Exception e) {}
		
		return Files.lines(path, StandardCharsets.ISO_8859_1).collect(Collectors.toList());
	}
	
	public static void saveReport(String report, Path path)
			throws IOException {
	    byte[] strToBytes = report.getBytes();
	    Files.write(path, strToBytes);
	}
}
