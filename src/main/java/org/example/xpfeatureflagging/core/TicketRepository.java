package org.example.xpfeatureflagging.core;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    List<Ticket> findAll();

    Optional<Ticket> findById(Long ticketId);

    Ticket save(Ticket ticket);
}