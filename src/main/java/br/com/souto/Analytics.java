package br.com.souto;

import java.io.IOException;
import java.util.List;

import br.com.souto.analytics.SalesAnalysis;
import br.com.souto.container.RegistersContainer;
import br.com.souto.files.SalesFiles;
import br.com.souto.repository.Repository;
import br.com.souto.repository.SalesData;
import java.nio.file.Path;

public class Analytics {
	public static void main(String[] args) throws IOException {
		
       	SalesFiles.createDirs();
        
		for (Path path: SalesFiles.getInputFilePathList()) {
			try {
				System.out.println("Processing file " + path.toString());
				List<String> registerLinesList = Repository.getRegisterLinesList(path);
				List<RegistersContainer> registersContainersList =
						new SalesData().getRegistersContainers(registerLinesList);
				//System.out.println(registersContainersList);
				String report = new SalesAnalysis().process(registersContainersList);
				Repository.saveReport(report, SalesFiles.getOutputFilePath(path));
			} catch (IndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("Invalid data in input file.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println("File read/write error.");
			}
		}
    }
}
