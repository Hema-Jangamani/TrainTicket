package com.TrainTickets.controller;

import com.TrainTickets.config.JwtTokenGenerator;
import com.TrainTickets.model.TrainTicket;
import com.TrainTickets.model.TrainTicketDto;
import com.TrainTickets.service.TrainTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TrainTicketController {

    private TrainTicketService service;
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    public TrainTicketController(TrainTicketService service,JwtTokenGenerator jwtTokenGenerator){
        this.service = service;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("/bookTicket")
    public TrainTicket addTicket(@RequestBody TrainTicket ticket){
        return service.bookTicket(ticket);
    }

    @PostMapping("/login")
    public Map<String,String> authenticateTicket(@RequestBody TrainTicketDto trainTicketDto){
        final TrainTicket ticket = this.service.authenticateTicket(trainTicketDto.getId(), trainTicketDto.getName());
        return this.jwtTokenGenerator.generateToken(ticket);
    }

    @GetMapping("/getTickets")
    public List<TrainTicket> getTicketsList(){
        return service.getAllTickets();
    }

    @GetMapping("/getTickets/{id}")
    public Object getTicketById(@PathVariable("id") Integer id){
        TrainTicket ticket = service.getTicketById(id);
        if (ticket != null){
            return ticket;
        } else {
            return "No ticket found";
        }
    }

    @PutMapping("/editTicket/{id}")
    public Object editTicket(@RequestBody TrainTicket ticket, @PathVariable("id") Integer id){
        TrainTicket editTicket = this.service.updateTicket(ticket);
        if (ticket.getId().equals(id)){
            return ticket;
        }else {
            return "No ticket found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteTicketById(@PathVariable("id") Integer id){
             service.deleteTicket(id);
             return "Successfully deleted";
        }
}
