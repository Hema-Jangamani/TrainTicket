package com.TrainTickets.repository;

import com.TrainTickets.model.TrainTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainTicketRepository extends JpaRepository<TrainTicket,Integer> {

    //login
    Optional<TrainTicket> findByIdAndName(Integer id, String name);
}
