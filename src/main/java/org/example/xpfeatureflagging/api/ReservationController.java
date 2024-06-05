package org.example.xpfeatureflagging.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.xpfeatureflagging.core.Reservation;
import org.example.xpfeatureflagging.core.Ticket;
import org.example.xpfeatureflagging.core.TicketingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Sample API", description = "Sample API for demonstration")
public class ReservationController {

    private final TicketingService ticketingService;

    public ReservationController(TicketingService ticketingService) {
        this.ticketingService = ticketingService;
    }

    @GetMapping("/tickets")
    @Operation(summary = "Get All Tickets", description = "Get all tickets available for reservation")
    public List<Ticket> getAllTickets() {
        return ticketingService.getAllTickets();
    }

    @PostMapping("{projectId}/reserve")
    @Operation(summary = "Reserves Tickets", description = "reserves a ticket")
    public Ticket reserveTicket(@PathVariable String projectId, @RequestBody Reservation reservation) {
        return ticketingService.reserveTicket(projectId, reservation.getTicketId());
    }
}