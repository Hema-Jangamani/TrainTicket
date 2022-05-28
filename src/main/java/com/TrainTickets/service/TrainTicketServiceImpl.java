package com.TrainTickets.service;

import com.TrainTickets.model.TrainTicket;
import com.TrainTickets.repository.TrainTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainTicketServiceImpl implements TrainTicketService{

    @Autowired
    private TrainTicketRepository repository;


    @Override
    public TrainTicket bookTicket(TrainTicket ticket) {
        return repository.save(ticket);
    }

    @Override
    public TrainTicket authenticateTicket(Integer id, String name) {
        final boolean exists = this.repository.existsById(id);
        if (!exists){
            System.out.println("User not exists");
        }
        final Optional<TrainTicket> optionalTicket = this.repository.findByIdAndName(id,name);
        if (optionalTicket.isEmpty()){
            System.out.println("Enter name");
        }
        return optionalTicket.get();
    }

    @Override
    public List<TrainTicket> getAllTickets() {
        return repository.findAll();
    }

    @Override
    public TrainTicket getTicketById(Integer id) {
        Optional<TrainTicket> getTicket = repository.findById(id);
        if (getTicket.isPresent()){
            return getTicket.get();
        } else {
            return null;
        }
    }

    @Override
    public TrainTicket updateTicket(TrainTicket ticket) {
        TrainTicket existById = this.repository.save(ticket);
        if (existById != null){
            return repository.save(ticket);
        }
        return null;
    }

    @Override
    public void deleteTicket(Integer id) {

         repository.deleteById(id);
    }
}
