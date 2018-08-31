package br.com.souto.files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class SalesFiles {
	
	public static void createDirs() throws IOException {
		Files.createDirectories(Paths.get(homePath + INPUT_PATH));
		Files.createDirectories(Paths.get(homePath + OUTPUT_PATH));
	}
	
	public static List<Path> getInputFilePathList() throws IOException {
		Path dir = FileSystems.getDefault().getPath( homePath + INPUT_PATH );
		DirectoryStream<Path> stream = Files.newDirectoryStream( dir, "*.dat" );
		List<Path> pathList = new ArrayList<Path>();
		for (Path path : stream) {
		    //System.out.println( path.getFileName() );
		    pathList.add(path);
		}
		stream.close();
		return pathList;
	}
	
	public static Path getOutputFilePath(Path path) {	
		return Paths.get(homePath + OUTPUT_PATH + "\\" + path.getFileName().toString().replace(".dat", ".done.dat"));
	}
	
	private static String setHomePath() {
		return System.getenv("HOMEPATH").isEmpty() ? System.getenv("HOME") : System.getenv("HOMEPATH");
	}

	private static String homePath = setHomePath();
	private static final String INPUT_PATH = "\\data\\in";
	private static final String OUTPUT_PATH = "\\data\\out";

}
