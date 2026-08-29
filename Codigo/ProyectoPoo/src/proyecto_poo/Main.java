public class Main {

    public static void main(String[] args) {

        // Crear equipos
        Equipo equipoRojo = new Equipo("Equipo Rojo");
        Equipo equipoAzul = new Equipo("Equipo Azul");

        // ===== EQUIPO ROJO =====
        equipoRojo.agregarPersonaje(new Guerrero("Guerrero Rojo 1", 100, 30, 5));
        equipoRojo.agregarPersonaje(new Guerrero("Guerrero Rojo 2", 100, 25, 8));
        equipoRojo.agregarPersonaje(new Mago("Mago Rojo", 90, 20, 4));
        equipoRojo.agregarPersonaje(new Mistico("Mistico Rojo", 80, 35, 3));

        // ===== EQUIPO AZUL =====
        equipoAzul.agregarPersonaje(new Guerrero("Guerrero Azul 1", 100, 30, 5));
        equipoAzul.agregarPersonaje(new Guerrero("Guerrero Azul 2", 100, 25, 8));
        equipoAzul.agregarPersonaje(new Mago("Mago Azul", 90, 20, 4));
        equipoAzul.agregarPersonaje(new Mistico("Mistico Azul", 80, 35, 3));

        int ronda = 1;
        int maxRondas = 5;
        while (!equipoRojo.estaDerrotado()
                && !equipoAzul.estaDerrotado()
                && ronda <= maxRondas) {

            System.out.println("\n==============================");
            System.out.println("        RONDA " + ronda);
            System.out.println("==============================");

            equipoRojo.atacarOtroEquipo(equipoAzul);

            if (equipoAzul.estaDerrotado()) {
                break;
            }

            equipoAzul.atacarOtroEquipo(equipoRojo);

            ronda++;
        }

        System.out.println("\n==============================");
        System.out.println("     RESULTADO FINAL");
        System.out.println("==============================");

        if (equipoRojo.estaDerrotado()) {

            System.out.println("¡¡Equipo Azul gana el combate!!");

        } else if (equipoAzul.estaDerrotado()) {

            System.out.println("¡¡Equipo Rojo gana el combate!!");

        } else {

            System.out.println("Se alcanzó el máximo de rondas.");

            int vidaRojo = equipoRojo.sumarVida();
            int vidaAzul = equipoAzul.sumarVida();

            System.out.println("Vida total Equipo Rojo: " + vidaRojo);
            System.out.println("Vida total Equipo Azul: " + vidaAzul);

            if (vidaRojo > vidaAzul) {

                System.out.println("\n¡Equipo Rojo gana por mayor cantidad de vida!");

            } else if (vidaAzul > vidaRojo) {

                System.out.println("\n¡Equipo Azul gana por mayor cantidad de vida!");

            } else {

                System.out.println("\n¡EMPATE!");

            }
        }

    }
}