import java.util.Random;

public class Mago extends Personaje {

    private Equipo equipo;

    // Constructor
    public Mago(String n, int v, int a, int d) {
        super(n, v, a, d);
    }

    // Asignar el equipo al mago
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public void usarEstrategia() {

        if (equipo == null) {
            return;
        }

        Random random = new Random();

        int posicion = random.nextInt(equipo.getPersonajes().size());

        Personaje aliado = equipo.getPersonajes().get(posicion);

        int curacion = (int) (getVida() * 0.25);

        aliado.setVida(aliado.getVida() + curacion);
    }
}