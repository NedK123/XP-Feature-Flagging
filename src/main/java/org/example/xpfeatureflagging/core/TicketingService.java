package org.example.xpfeatureflagging.core;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TicketingService {

    private final TicketRepository ticketRepository;
    private final FeaturesManager featuresManager;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket reserveTicket(String projectId, Long ticketId) {
        if (featuresManager.isFeatureEnabled(projectId, "Fast-Fast-Env-Go-Go")) {
            return reserveTicketInternal(ticketId);
        } else {
            throw new UnsupportedOperationException("Reserving tickets is not enabled");
        }
    }

    private Ticket reserveTicketInternal(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setReserved(true);
        return ticketRepository.save(ticket);
    }
}