package com.TrainTickets.config;

import com.TrainTickets.model.TrainTicket;

import java.util.Map;

public interface JwtTokenGenerator {

    Map<String,String> generateToken(TrainTicket ticket);
}
