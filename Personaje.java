public class Personaje implements Combatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public int calcularDanio() {
        return nivel * 10; // Daño base según nivel
    }

    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
            System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);
            System.out.println(nombre + " ha sido derrotado.");
        } else {
            System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);
        }
    }

    // Parte 4: Sobrecarga adicional en Personaje (mostrarEstado)
    public void mostrarEstado() {
        System.out.println("-> Personaje: " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida);
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println(this.toString() + " | Vivo: " + (estaVivo ? "Sí" : "No"));
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String prefijo) {
        System.out.println(prefijo + " " + nombre + " [Nivel: " + nivel + ", HP: " + puntosVida + "]");
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe básico.");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se pone en guardia.");
    }

    @Override
    public String toString() {
        String vivoStr = estaVivo ? "Sí" : "No";
        return "Nombre: " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida + " | Vivo: " + vivoStr;
    }
}