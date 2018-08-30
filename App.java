package be.intecbrussel.lambda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileio {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String osNameMatch = osName.toLowerCase();
		String home = System.getProperty("user.home");
		FileSystem file = FileSystems.getDefault();

		System.out.println(
				"OS: " + System.getProperty("os.name") + ", USER DIRECTORY: " + System.getProperty("user.home"));

		Scanner input = new Scanner(System.in);

		if (osNameMatch.contains("linux")) {
			new File(home + "/Desktop/testFolder").mkdir();
			System.out.println("Sucessfully created the directory.\n" + "Enter your txt file name: [without .txt]");
			String filename = input.next();
			File f = new File(home + "/" + filename + ".txt");
			try {
				FileOutputStream fs = new FileOutputStream(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Path path = Paths.get(home + "/Desktop/testFolder/" + filename + ".txt");
			System.out.println("Enter your msg to " + filename);
			String data = input.next();
			List<String> lines = new ArrayList<>();
			lines.add(data);

			try {
				Files.write(path, lines, Charset.defaultCharset(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (osNameMatch.contains("windows")) {
			new File(home + "\\Desktop\\testFolder").mkdir();
		} else if (osNameMatch.contains("solaris") || osNameMatch.contains("sunos")) {
			// solaris
		} else if (osNameMatch.contains("mac os") || osNameMatch.contains("macos") || osNameMatch.contains("darwin")) {
			// macos
		} else {
		}

	}

}
