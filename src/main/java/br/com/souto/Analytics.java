package br.com.souto;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.logging.Level;

import br.com.souto.analytics.SalesAnalysis;
import br.com.souto.files.SalesFiles;
import br.com.souto.processor.RegistersProcessor;
import br.com.souto.repository.Repository;
import br.com.souto.repository.SalesData;
import java.nio.file.Path;

public class Analytics {
	
	private final ScheduledExecutorService scheduler =
		       Executors.newScheduledThreadPool(1);

	final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void generateReportsJob() {

		final Runnable reportsGenerator = new Runnable() {
			public void run() {
				logger.info("\nStarting Job...");
				try {
					for (Path path: SalesFiles.getInputFilePathList()) {
						try {
							
							logger.info("Processing file " + path.toString());
								
							List<String> registerLinesList = Repository.getRegisterLinesList(path);
							List<RegistersProcessor> registersContainersList =
									new SalesData().getRegistersContainers(registerLinesList);
							
							logger.fine(registersContainersList.toString());
							
							String report = new SalesAnalysis().process(registersContainersList);
							
							Repository.saveReport(report, SalesFiles.getOutputFilePath(path));
								
						} catch (IndexOutOfBoundsException | NumberFormatException e) {
								logger.log(Level.SEVERE, "Invalid data in input file.");
						} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
						} catch (IOException e) {
							logger.log(Level.SEVERE, "File read/write error: " + e.getMessage());
						}
					}
				} catch (IOException e) {
					logger.log(Level.SEVERE, "File read/write error: " + e.getMessage());
				}
			}};
			final ScheduledFuture<?> reportsGeneratorHandler =
		            scheduler.scheduleAtFixedRate(reportsGenerator, 10, 10, TimeUnit.SECONDS);
			
		}
	
	public static void main(String[] args) {
        
		try {
			SalesFiles.createDirs();
			Analytics analytics = new Analytics();
			analytics.generateReportsJob();
			
		} catch (IOException e) {
			System.out.println("ERROR: File read/write error: " + e.getMessage());
		}

    }
}
