package com;



import java.io.*;
  import java.nio.charset.StandardCharsets;
  import java.nio.file.Files;
  import java.nio.file.Path;
  import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;

import java.util.Arrays;
  import java.util.List;
public class filePrint {

  public static void main(String[] args) throws IOException {

    String fileName = "C:\\Users\\I542218\\testproject\\test.txt";
    List<String> lines = Arrays.asList("line 1", "line 2", "line 3", "你好，世界");

    writeUnicodeJava8(fileName, lines);
    //writeUnicodeJava11(fileName, lines);
    //writeUnicodeClassic(fileName, lines);
    String data = "Hello! How are you?";
    File dest = new File("C:\\Users\\I542218\\testproject\\test.txt");
    //With Default encoding and no append
    FileUtils.writeStringToFile(dest, data,"utf-8");

 //   File fActualResponse = new File("testpipeline/testfiles_"+ TEST_FOLDER_SUF+"/actualResponse.txt");
  //  FileUtils.writeStringToFile(fActualResponse, actualResponse, "utf-8");



    //With Default encoding and append true
   // FileUtils.writeStringToFile(dest, data, true);
    //System.out.println(FileUtils.readFileToString(dest));




























    System.out.println("Done");
  }

  // in the old days
  public static void writeUnicodeClassic(String fileName, List<String> lines) {

    File file = new File(fileName);

    try (FileOutputStream fos = new FileOutputStream(file);
      OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
      BufferedWriter writer = new BufferedWriter(osw)
    ) {

      for (String line : lines) {
        writer.append(line);
        writer.newLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  // Java 8 - Files.newBufferedWriter(path) - default UTF-8
  public static void writeUnicodeJava8(String fileName, List<String> lines) {

    Path path = Paths.get(fileName);

    try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

      for (String line : lines) {

        writer.append(line);
        writer.newLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }



}