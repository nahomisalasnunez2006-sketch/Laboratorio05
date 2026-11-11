import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;

    public GestorBatalla() {
        historial = new ArrayList<>();
    }

    // Versión 1: un solo atacante
    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        historial.add(atacante.getNombre() + " atacó solo (daño: " + danio + ")");
        System.out.println("[BATALLA] " + atacante.getNombre() + " ataca solo → daño: " + danio);
    }

    // Versión 2: atacante vs defensor
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        System.out.println("[BATALLA] " + atacante.getNombre() + " ataca a " + defensor.getNombre() + " → daño: " + danio);
        atacante.atacar();
        defensor.recibirDanio(danio);
        defensor.defender();
        
        String evento = atacante.getNombre() + " atacó a " + defensor.getNombre() + " (daño: " + danio + ")";
        if (!defensor.isEstaVivo()) {
            evento += " - " + defensor.getNombre() + " derrotado";
        }
        historial.add(evento);
    }

    // Versión 3: todo un equipo ataca
    public void ejecutarAtaque(Personaje[] equipo) {
        System.out.println("[BATALLA] Ataque masivo del equipo (" + equipo.length + " personajes)");
        StringBuilder nombres = new StringBuilder();
        for (Personaje p : equipo) {
            p.atacar();
            nombres.append(p.getNombre()).append(", ");
        }
        historial.add("Ataque en equipo: " + nombres.toString().replaceAll(", $", ""));
    }

    public void mostrarHistorial() {
        System.out.println("\n-- Historial --");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void limpiarHistorial() {
        historial.clear();
        System.out.println("Historial limpiado.");
    }
}