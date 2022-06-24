package com.TrainTickets.service;

import com.TrainTickets.model.TrainTicket;
import com.TrainTickets.repository.TrainTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public TrainTicket updateTicket(TrainTicket ticket, Integer id) {
        TrainTicket ticket1 = repository.findById(id).get();
        if (Objects.nonNull(ticket.getName()) && !"".equalsIgnoreCase(ticket.getName())){
            ticket1.setName(ticket.getName());
        }

        if (Objects.nonNull(ticket.getAge()) && ticket.getAge() != 0){
            ticket1.setAge(ticket.getAge());
        }

        if (Objects.nonNull(ticket.getGender()) && !"".equalsIgnoreCase(ticket.getGender())){
            ticket1.setGender(ticket.getGender());
        }

        if (Objects.nonNull(ticket.getSource()) && !"".equalsIgnoreCase(ticket.getSource())){
            ticket1.setSource(ticket.getSource());
        }

        if (Objects.nonNull(ticket.getDestination()) && !"".equalsIgnoreCase(ticket.getDestination())){
            ticket1.setDestination(ticket.getDestination());
        }

        return repository.save(ticket1);
    }

    @Override
    public void deleteTicket(Integer id) {

         repository.deleteById(id);
    }
}
