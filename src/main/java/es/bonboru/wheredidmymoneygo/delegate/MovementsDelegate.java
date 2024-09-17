package es.bonboru.wheredidmymoneygo.delegate;

import es.bonboru.wheredidmymoneygo.api.MovementApi;
import es.bonboru.wheredidmymoneygo.model.Movement;
import es.bonboru.wheredidmymoneygo.web.impl.MovementsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class MovementsDelegate implements MovementApi {

    private static final Logger log = LoggerFactory.getLogger(MovementsDelegate.class);

    private MovementsServiceImpl movementsService;

    @Autowired
    public MovementsDelegate(MovementsServiceImpl movementsService){
        this.movementsService = movementsService;
    }

    @PostMapping("/movement")
    @Override
    public ResponseEntity<Void> createMovement(Movement movement){
        log.info("A request for creating a movement has arrived");
        if(movementsService.saveMovement(movement)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/movement")
    @Override
    public ResponseEntity<List<Movement>> getAllMovement(){
        log.info("A request to recuperate all movements have arrived");
        return ResponseEntity.ok(movementsService.recuperateAllMovements());
    }


    @GetMapping("/movement/{year}/{month}")
    @Override
    public ResponseEntity<List<Movement>> getMovementsByYearAndMonth(@PathVariable String year,@PathVariable String month){
        log.info("A request to recuperate all movements of {}/{}", year, month);
        return ResponseEntity.ok(movementsService.getMovementsByYearAndMonth(year, month));
    }

    @PutMapping("/movement")
    @Override
    public ResponseEntity<Movement> updateMovement(Movement movement){
        log.info("A request to update the movement: {} has arrived", movement.getId());
        Movement mvt = movementsService.updateMovement(movement);
        if (mvt != null){
            return ResponseEntity.ok(mvt);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/movement/{id}")
    @Override
    public ResponseEntity<Void> deleteMovement(@PathVariable String id){
        log.info("A request to delete the movement: {} has arrived", id);
        movementsService.deleteMovement(Long.getLong(id));
        return ResponseEntity.ok().build();
    }


}
