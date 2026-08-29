import java.util.ArrayList;

public class Equipo {

    private String nombre;
    private ArrayList<Personaje> personajes;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        personajes = new ArrayList<>();
    }

    // Agregar personaje
    public void agregarPersonaje(Personaje p) {
        personajes.add(p);

        if (p instanceof Mago) {
            ((Mago) p).setEquipo(this);
        }
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public String getNombre() {
        return nombre;
    }

    // Ataque del equipo
    public void atacarOtroEquipo(Equipo otroEquipo) {

        System.out.println("Equipo atacante " + nombre);

        // Atacan todos excepto el Místico
        for (int i = 0; i < personajes.size() && i < otroEquipo.getPersonajes().size(); i++) {

            Personaje atacante = personajes.get(i);

            if (atacante instanceof Mistico) {
                continue;
            }

            Personaje defensor = otroEquipo.getPersonajes().get(i);

            if (atacante.estaVivo() && defensor.estaVivo()) {
                atacante.realizarAtaque(defensor);
            }
        }

        // El Místico ataca al final
        for (int i = 0; i < personajes.size() && i < otroEquipo.getPersonajes().size(); i++) {

            Personaje atacante = personajes.get(i);

            if (atacante instanceof Mistico) {

                Personaje defensor = otroEquipo.getPersonajes().get(i);

                if (atacante.estaVivo() && defensor.estaVivo()) {
                    atacante.realizarAtaque(defensor);
                }
            }
        }
    }

    // Verificar si el equipo fue derrotado
    public boolean estaDerrotado() {

        for (Personaje p : personajes) {
            if (p.estaVivo()) {
                return false;
            }
        }

        return true;
    }

    // Vida total del equipo (opcional)
    public int sumarVida() {

        int suma = 0;

        for (Personaje p : personajes) {
            suma += p.getVida();
        }

        return suma;
    }
}