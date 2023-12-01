package Middleware.share;
import java.io.IOException;
import java.nio.file.*;

public class CopyFileShare {
	public void share(String receiveEmail,String userEmail, String filename) {
		Path sourcePath = Paths.get("/root/upload/"+userEmail+"/"+filename);
        Path destinationPath = Paths.get("/root/upload/"+receiveEmail+"/share/");

        try {
        	Files.createDirectories(destinationPath);
            // Copy the file
        	 Path destinationFile = destinationPath.resolve(sourcePath.getFileName());

             // Copy the file to the destination folder
             Files.copy(sourcePath, destinationFile, StandardCopyOption.REPLACE_EXISTING);

             System.out.println("File copied successfully to: " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error copying the file: " + e.getMessage());
        }
	}
}
