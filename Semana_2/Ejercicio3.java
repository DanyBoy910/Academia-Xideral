package Semana_2;
/*
* Daniel Rodríguez Orozco 29-04-2026
* Ejercicio 3: Sistema de Tickets con Enums Avanzados
Objetivo
Dominar enums con campos, constructores, métodos y usar EnumSet / EnumMap.

Requisitos
Crear enum Priority con valores LOW(1,48), MEDIUM(2,24), HIGH(3,8), CRITICAL(4,1) — campos: level, responseTimeHours.
Método getLabel() que retorne ej: "CRITICAL (Nivel 4, Respuesta: 1h)".
Crear enum TicketStatus con OPEN, IN_PROGRESS, RESOLVED, CLOSED.
Método canTransitionTo(TicketStatus) que valide transiciones permitidas.
Crear clase Ticket con id, description, priority, status y método transitionTo().
En main: usar EnumMap para contar tickets por status y EnumSet para filtrar urgentes.
*
* */
import java.util.*;

enum Priority {
    LOW(1, 48),
    MEDIUM(2, 24),
    HIGH(3, 8),
    CRITICAL(4, 1);

    private final int level;
    private final int responseTimeHours;

    // TODO: constructor
    Priority(int level, int responseTimeHours) {
        this.level = level;
        this.responseTimeHours = responseTimeHours;
    }

    public int getLevel() { return this.level; }
    public int getResponseTimeHours() { return this.responseTimeHours; }

    public String getLabel() {
        // TODO: retornar "NOMBRE (Nivel X, Respuesta: Yh)"
        return String.format("%s (Nivel %d, Respuesta: %dh)",
                name(),getLevel() , getResponseTimeHours());
    }
}

enum TicketStatus {
    OPEN, IN_PROGRESS, RESOLVED, CLOSED;

    public boolean canTransitionTo(TicketStatus target) {
        // TODO: definir transiciones validas
        // OPEN -> IN_PROGRESS
        // IN_PROGRESS -> RESOLVED o OPEN (reabrir)
        // RESOLVED -> CLOSED o IN_PROGRESS (reabrir)
        // CLOSED -> ninguno
        return switch (this) {
            case OPEN -> target == IN_PROGRESS;
            case IN_PROGRESS -> (target == RESOLVED) || (target == OPEN);
            case RESOLVED -> (target == CLOSED) || (target == IN_PROGRESS);
            case CLOSED -> false;
        };
    }
}

class Ticket {
    private final int id;
    private final String description;
    private final Priority priority;
    private TicketStatus status;

    public Ticket(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = TicketStatus.OPEN;
    }

    public void transitionTo(TicketStatus newStatus) {
        // TODO: validar con canTransitionTo, cambiar o imprimir error
        if(status.canTransitionTo(newStatus)){
            System.out.println("Ticket "+getId()+": "+getStatus()+" -> "+newStatus);
            status = newStatus;
        }else{
            System.out.println("NO SE PUEDE TRANSICIONAR DE " +status.name()+ " a " +newStatus.name() );
        }

    }

    // TODO: getters
    public int getId() { return id; }
    public Priority getPriority() { return priority; }
    public TicketStatus getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Ticket{id=%d, desc='%s', priority=%s, status=%s}",
                id, description, priority.getLabel(), status);
    }
}
public class Ejercicio3 {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, "Login falla", Priority.CRITICAL));
        tickets.add(new Ticket(2, "Boton desalineado", Priority.LOW));
        tickets.add(new Ticket(3, "Error en pagos", Priority.HIGH));
        tickets.add(new Ticket(4, "Mejorar docs", Priority.MEDIUM));

        System.out.println("=== Todos los Tickets ===");
        tickets.forEach(System.out::println);

        // Transiciones
        System.out.println("\n=== Transiciones ===");
        tickets.get(0).transitionTo(TicketStatus.IN_PROGRESS);
        tickets.get(2).transitionTo(TicketStatus.IN_PROGRESS);
        tickets.get(2).transitionTo(TicketStatus.RESOLVED);

        // Transicion invalida
        tickets.get(2).transitionTo(TicketStatus.OPEN);

        System.out.println("\n=== Estado Actualizado ===");
        tickets.forEach(System.out::println);

        // TODO: EnumMap para contar tickets por status
        System.out.println("\n=== Dashboard (EnumMap) ===");
        EnumMap<TicketStatus, Integer> conteo = new EnumMap<>(TicketStatus.class);
        for (TicketStatus s : TicketStatus.values()) conteo.put(s, 0);
        // TODO: contar tickets por status
        for (Ticket t: tickets){
            conteo.put(t.getStatus(),conteo.get(t.getStatus())+1);
        }

        conteo.forEach((status, count) ->
                System.out.printf("  %s: %d%n", status, count));

        // TODO: EnumSet para filtrar tickets urgentes (HIGH + CRITICAL)
        System.out.println("\n=== Tickets Urgentes (EnumSet) ===");
        EnumSet<Priority> urgentes = EnumSet.of(Priority.HIGH, Priority.CRITICAL);
        // TODO: filtrar e imprimir tickets con prioridad urgente
        for(Ticket s: tickets){
            if(urgentes.contains(s.getPriority())){
                System.out.println(s);
            }
        }
    }
}
