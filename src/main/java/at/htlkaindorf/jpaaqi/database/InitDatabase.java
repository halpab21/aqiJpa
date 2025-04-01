package at.htlkaindorf.jpaaqi.database;

import at.htlkaindorf.jpaaqi.pojos.AQI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDatabase {

    @Autowired
    private AqiRepository repository;

    @PostConstruct
    public void createDatabaseFromFile(){
        try {
            InputStream input = this.getClass().getResourceAsStream("/aqi.json");

            ObjectMapper mapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule());

            List<AQI> students = mapper
                    .readerForListOf(AQI.class)
                    .readValue(input);

            repository.saveAll(students);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
