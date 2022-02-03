package ru.kpfu.itis.genatulin.hw5.repositories;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.genatulin.hw5.entities.Calculation;
import ru.kpfu.itis.genatulin.hw5.entities.Operation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CalculationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCalculation(Calculation calculation) {
        entityManager.getTransaction().begin();
        entityManager.persist(calculation);
        entityManager.getTransaction().commit();
    }

    public Calculation getCalculation(int arg1, int arg2, Operation operation) {
        entityManager.getTransaction().begin();
        List<Calculation> result = entityManager.createQuery(
                "select * from calculation where arg_1 = " + arg1 + "" +
                        " and arg_2 = " + arg2 + "" +
                        " and operation = " + operation.name() + ";", Calculation.class).getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
