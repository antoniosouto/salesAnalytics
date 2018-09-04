# salesAnalytics

1. gradle.bat run
2. copy *.dat files to %HOMEPATH%/data/in

Each 10 seconds the job will run, create the data/* directories structure, process the files in %HOMEPATH%/data/in and save the reports in %HOMEPATH%/data/out 
  
On Linux:
1. export GRADLE_USER_HOME=\`pwd\`/.gradle
2. ./gradlew run
3. copy *.dat files to %HOME%/data/in
