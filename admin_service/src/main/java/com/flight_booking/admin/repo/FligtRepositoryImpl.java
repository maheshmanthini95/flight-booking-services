package com.flight_booking.admin.repo;

import com.flight_booking.admin.entity.Airline;
import com.flight_booking.admin.entity.Airport;
import com.flight_booking.admin.entity.Flight;
import com.flight_booking.admin.pojo.FlightSearchQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public abstract class FligtRepositoryImpl implements  FlightRepository {
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Method to return flights based on search criteria.
     * @param searchQuery
     * @return
     */
    public List<Flight> flightsBySearchQuery(FlightSearchQuery searchQuery) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Flight.class);
        Root<Flight> flightRoot = query.from(Flight.class);
        Join<Flight, Airline> joinAirline = flightRoot.join("airline", JoinType.INNER);
        Join<Flight, Airport> joinAirport = flightRoot.join("from", JoinType.INNER);
        Join<Flight, Airport> joinAirport2 = flightRoot.join("to", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();
        if (searchQuery.getDepartureTime() != null) {
            Predicate predicate = builder.lessThan(flightRoot.get("departureTime"), searchQuery.getDepartureTime());
            predicates.add(predicate);
        }
        if (searchQuery.getArrivalTime() != null) {
            Predicate predicate = builder.lessThan(flightRoot.get("arrivalTime"), searchQuery.getArrivalTime());
            predicates.add(predicate);
        }
        if (searchQuery.getFrom() != null) {
            Predicate predicate = builder.equal(joinAirport.get("id"), searchQuery.getFrom());
            predicates.add(predicate);
        }
        if (searchQuery.getTo() != null) {
            Predicate predicate = builder.equal(joinAirport.get("id"), searchQuery.getTo());
            predicates.add(predicate);
        }
        query.where(predicates.toArray(Predicate[]::new));

        List<Flight> list = entityManager.createQuery(query.select(flightRoot)).getResultList();
        return list;
    }
}
