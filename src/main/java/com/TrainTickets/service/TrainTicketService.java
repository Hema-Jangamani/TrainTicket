package com.TrainTickets.service;

import com.TrainTickets.model.TrainTicket;

import java.util.List;

public interface TrainTicketService {

    TrainTicket bookTicket(TrainTicket ticket);

    TrainTicket authenticateTicket(Integer id, String name);

    List<TrainTicket> getAllTickets();

    TrainTicket getTicketById(Integer id);

    TrainTicket updateTicket(TrainTicket ticket);

    void deleteTicket(Integer id);
}
