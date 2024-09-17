package es.bonboru.wheredidmymoneygo;

import es.bonboru.wheredidmymoneygo.model.Movement;
import es.bonboru.wheredidmymoneygo.model.TypeMovement;
import es.bonboru.wheredidmymoneygo.repositories.MovementsRepository;
import es.bonboru.wheredidmymoneygo.web.impl.MovementsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovementServiceImplTest {

    @Autowired
    private MovementsRepository movementsRepository;

    @Autowired
    private ModelMapper modelMapper;

    private MovementsServiceImpl movementsService;

    @BeforeEach
    void init(){
        movementsService = new MovementsServiceImpl(movementsRepository, modelMapper);
    }

    @Test
    void saveMovementTest(){
        Movement m1 = new Movement();
        m1.setNecessary(true);
        m1.setQuantity(100.0);
        m1.setReason(TypeMovement.OCIO);
        movementsService.saveMovement(m1);
        Assertions.assertNotNull(movementsRepository.findById(1L));
    }



}
