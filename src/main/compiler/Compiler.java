package main.compiler;


import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Compiler {
    public String compile(File sourceFile) throws IOException {
        String[] command = new String[] {"javac", sourceFile.getAbsolutePath() };

        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();



//        String classFilePath = sourceFile.getAbsolutePath().replace(".java", ".class");
//        if (!new File(classFilePath).exists()) {
//            return "ERROR";
//        }
//
//        command = new String[] {"java", classFilePath };
//
//        builder = new ProcessBuilder(command);
//        process = builder.start();
        // 동기 비동기인지 체크


        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                result.append(line);
                result.append("\n");
            }
        }

        return result.toString();
    }

    public String execte(String code) throws IOException {
        File file = new File("C:\\dev\\test_workspace\\test.java");
        code = "public class HelloWorld {\n" +
                "    public static void main(String args[]) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";

        FileUtils.writeStringToFile(file, code, Charset.forName("utf-8"));

        return compile(file);
    }
}

