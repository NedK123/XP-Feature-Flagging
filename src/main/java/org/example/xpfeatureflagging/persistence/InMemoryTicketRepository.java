package org.example.xpfeatureflagging.persistence;

import org.example.xpfeatureflagging.core.Ticket;
import org.example.xpfeatureflagging.core.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryTicketRepository implements TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }

    @Override
    public Optional<Ticket> findById(Long ticketId) {
        return tickets.stream().filter(ticket -> ticket.getId().equals(ticketId)).findFirst();
    }

    @Override
    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

}
