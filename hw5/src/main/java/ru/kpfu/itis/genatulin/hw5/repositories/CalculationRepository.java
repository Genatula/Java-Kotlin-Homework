package ru.kpfu.itis.genatulin.hw5.repositories;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.genatulin.hw5.entities.Calculation;
import ru.kpfu.itis.genatulin.hw5.entities.Operation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
public class CalculationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveCalculation(Calculation calculation) {
        entityManager.persist(calculation);
    }

    @Transactional
    public Calculation getCalculation(int arg1, int arg2, Operation operation) {
        Query query = entityManager.createQuery(
                "select c from Calculation c where arg1 = " + arg1 + "" +
                        " and arg2 = " + arg2 + "" + " and operation in :operationList", Calculation.class);
        query.setParameter("operationList", Arrays.asList(Operation.values()));
        List<Calculation> result = (List<Calculation>) query.getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
