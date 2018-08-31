package be.intecbrussel.lambda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
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

			FileWriter writer = null;
			try {
				writer = new FileWriter(home + "/Desktop/testFolder/" + filename + ".txt");
				System.out.println("Enter your msg to :");
				String data = input.next();
				writer.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if(writer !=null) {
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
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
