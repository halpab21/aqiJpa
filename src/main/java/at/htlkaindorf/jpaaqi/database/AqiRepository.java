package at.htlkaindorf.jpaaqi.database;

import at.htlkaindorf.jpaaqi.pojos.AQI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AqiRepository extends JpaRepository<AQI, Long> {
}