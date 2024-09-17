package es.bonboru.wheredidmymoneygo.web.impl;

import es.bonboru.wheredidmymoneygo.enums.TypeMovementEnum;
import es.bonboru.wheredidmymoneygo.model.Movement;
import es.bonboru.wheredidmymoneygo.model.MovementEntity;
import es.bonboru.wheredidmymoneygo.model.TypeMovement;
import es.bonboru.wheredidmymoneygo.repositories.MovementsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class MovementsServiceImpl {

    private final MovementsRepository movementsRepository;

    private static final Logger log = LoggerFactory.getLogger(MovementsServiceImpl.class);

    @Autowired
    public MovementsServiceImpl(MovementsRepository movementsRepository){
        this.movementsRepository = movementsRepository;
    }

    public boolean saveMovement(Movement movement){
        try {
            MovementEntity movementEntity = movementToMovementEntity(movement);
            log.info("Movement {} to be saved", movementEntity);
            MovementEntity mvt = movementsRepository.save(movementEntity);
            log.info("Movement {} saved correctly", mvt.getId());
            return true;
        } catch (IllegalArgumentException e){
            log.error("Error building the movement entity", e);
            return false;
        }

    }

    public List<Movement> recuperateAllMovements(){
        return movementsRepository.findAll().stream().map(this::movementEntityToMovement).toList();
    }

    public List<Movement> getMovementsByYearAndMonth(String year, String month){
        return movementsRepository.findByYearAndMonth(year, month).stream().map(this::movementEntityToMovement).toList();
    }


    private MovementEntity movementToMovementEntity(Movement movement) throws IllegalArgumentException{
        MovementEntity mvn = new MovementEntity();
        mvn.setDateMovement(movement.getDateMovement());
        mvn.setDateCreation(OffsetDateTime.now());
        mvn.setDateModification(OffsetDateTime.now());
        mvn.setReason(TypeMovementEnum.valueOf(movement.getReason().toString()));
        mvn.setSubReason(movement.getSubreason());
        mvn.setQuantity(movement.getQuantity());
        mvn.setNecessary(movement.getNecessary());
        return mvn;
    }

    private Movement movementEntityToMovement(MovementEntity movement) throws IllegalArgumentException{
        Movement mvn = new Movement();
        mvn.setDateCreation(movement.getDateMovement());
        mvn.setReason(TypeMovement.valueOf(movement.getReason().toString()));
        mvn.setSubreason(movement.getSubReason());
        mvn.setQuantity(movement.getQuantity());
        mvn.setNecessary(movement.getNecessary());
        return mvn;
    }
}
