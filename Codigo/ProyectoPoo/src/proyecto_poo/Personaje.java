public abstract class Personaje {

    private String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;

    // Constructor
    public Personaje(String n, int v, int a, int d) {
        this.nombre = n;
        this.vida = v;
        this.ataque = a;
        this.defensa = d;
    }

    // Recibir ataque
    public void recibirAtaque(int dano) {

        int danoReal = dano - defensa;

        if (danoReal < 0) {
            danoReal = 0;
        }

        vida -= danoReal;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nombre + " recibe " + danoReal
                + " de daño. Vida restante: " + vida);
    }

    // Realizar ataque
    public void realizarAtaque(Personaje contrario) {

        usarEstrategia();
        contrario.recibirAtaque(ataque);

    }

    // Método abstracto
    public abstract void usarEstrategia();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    // Setters
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    // Saber si sigue vivo
    public boolean estaVivo() {
        return vida > 0;
    }

}