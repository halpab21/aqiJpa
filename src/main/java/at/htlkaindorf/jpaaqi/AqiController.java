package at.htlkaindorf.jpaaqi;

import at.htlkaindorf.jpaaqi.database.AqiRepository;
import at.htlkaindorf.jpaaqi.pojos.AQI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AqiController {
    @Autowired
        private AqiRepository repository;

    @GetMapping("getAll")
    public ResponseEntity<Iterable<AQI>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
