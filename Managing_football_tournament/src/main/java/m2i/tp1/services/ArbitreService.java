package m2i.tp1.services;

import java.util.Optional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.tp1.entities.Arbitre;
import m2i.tp1.entities.Match;
import m2i.tp1.repositories.ArbitreRepositories;
import m2i.tp1.repositories.MatchRepositories;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ArbitreService {
    @Autowired
    private ArbitreRepositories arbitreRepositorires;

    @Autowired
    private MatchRepositories matchRepositorires;

    public void deleteArbitreById(Long idarbitre) {
        Optional<Arbitre> arbitreOptional = arbitreRepositorires.findById(idarbitre);
        
        if (arbitreOptional.isPresent()) {
            Arbitre arbitre = arbitreOptional.get();
            
            // Update the related Match records
            for (Match match : arbitre.getMatches()) {
                match.setArbitre(null);  // Set idarbitre to NULL
                matchRepositorires.save(match);  // Save the updated Match
            }
            
            arbitreRepositorires.deleteById(idarbitre);
        }
    }
    
    
    
    public Arbitre updateArbitre(Long idarbitre, Arbitre updatedArbitre) {
        Optional<Arbitre> existingArbitre = arbitreRepositorires.findById(idarbitre);

        if (existingArbitre.isPresent()) {
            Arbitre arbitre = existingArbitre.get();
            arbitre.setName(updatedArbitre.getName());
            arbitre.setNationality(updatedArbitre.getNationality());

            // You can update other fields as well

            return arbitreRepositorires.save(arbitre);
        } else {
            // Handle the case where the Arbitre with the given idarbitre does not exist.
            // You can return null or throw an exception to indicate the error.
            return null;
        }
        // they are the cruds by defaults in the repository
    }
    
 // Service method
    public Arbitre addArbitre(Long idarbitre, String name, String nationality, MultipartFile file) {
        Arbitre arbitre = new Arbitre(idarbitre, name, nationality, "", null);
        String directoryPath = "src/main/resources/static/photos/";
        String fileName = arbitre.getIdarbitre() + ".png";
        String fullPath = directoryPath + fileName;

        try {
            // Check if the directory exists, if not create it
            Path directory = Paths.get(directoryPath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Save the file
            Path filePath = Paths.get(fullPath);
            Files.write(filePath, file.getBytes());

            // Update Arbitre with photo URL
            String urlPhoto = "http://localhost:8080/photos/" + fileName;
            arbitre.setPhotos(urlPhoto);

            return arbitreRepositorires.save(arbitre);
        } catch (IOException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return null;
        }
    }
    
    
}
