public class Guerrero extends Personaje {
    private int ataqueBase;
    
    // Constructor
    public Guerrero(String n, int v, int a, int d) {
        super(n, v, a, d);
        ataqueBase = a;
    }
    @Override
    public void usarEstrategia() {

        // Duplica el ataque antes de atacar
        ataque = ataqueBase * 2;

    }

}