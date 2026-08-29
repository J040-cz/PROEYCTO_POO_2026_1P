import java.util.Random;

public class Mistico extends Personaje {

    private int ataqueBase;

    // Constructor
    public Mistico(String n, int v, int a, int d) {
        super(n, v, a, d);
        ataqueBase = a;
    }
    @Override
    public void usarEstrategia() {
        Random random = new Random();
        int valor = random.nextInt(4); // Genera 0, 1, 2 o 3
        ataque = (int) (ataqueBase * (1 + valor * 0.1));

    }
}