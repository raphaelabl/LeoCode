package at.htl.control;

import at.htl.entities.LeocodeFile;
import at.htl.entities.LeocodeFiletype;
import at.htl.repositories.LeocodeFileRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@ApplicationScoped
public class FileHandler {

    public final String zipLocation = "../project-under-test.zip";
    @Inject
    LeocodeFileRepository fileRepository;

    public String zipLeocodeFiles(List<LeocodeFile> files) {
        try (
                FileOutputStream fos = new FileOutputStream(zipLocation);
                ZipOutputStream zipOut = new ZipOutputStream(fos)
        ) {
            files.forEach(file -> {
                try {
                    if (file.filetype.equals(LeocodeFiletype.TEST)) {
                        zipOut.putNextEntry(new ZipEntry("test/" + file.name));
                    } else {
                        zipOut.putNextEntry(new ZipEntry(file.name));
                    }
                    zipOut.write(file.content, 0, file.content.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return zipLocation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
