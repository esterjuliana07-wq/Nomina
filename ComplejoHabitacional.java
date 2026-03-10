import java.util.Random;

public class ComplejoHabitacional {

    public static void main(String[] args) {

        Random random = new Random();

        final int TORRES = 7;
        final int PISOS = 20;
        final int APTOS = 6;

        int[][][] habitantes = new int[TORRES][PISOS][APTOS];
        boolean[][][] disponible = new boolean[TORRES][PISOS][APTOS];

        int totalHabitantes = 0;

        for (int t = 0; t < TORRES; t++) {
            for (int p = 0; p < PISOS; p++) {
                for (int a = 0; a < APTOS; a++) {

                    habitantes[t][p][a] = random.nextInt(6);
                    disponible[t][p][a] = random.nextBoolean();

                    totalHabitantes += habitantes[t][p][a];
                }
            }
        }

        System.out.println("\nPROMEDIO DE HABITANTES POR TORRE:");

        for (int t = 0; t < TORRES; t++) {
            int sumaTorre = 0;

            for (int p = 0; p < PISOS; p++) {
                for (int a = 0; a < APTOS; a++) {
                    sumaTorre += habitantes[t][p][a];
                }
            }

            double promedioTorre = (double) sumaTorre / (PISOS * APTOS);
            System.out.println("Torre " + (t + 1) + ": " + promedioTorre);
        }

        System.out.println("\nPROMEDIO DE HABITANTES POR PISO:");

        for (int p = 0; p < PISOS; p++) {
            int sumaPiso = 0;

            for (int t = 0; t < TORRES; t++) {
                for (int a = 0; a < APTOS; a++) {
                    sumaPiso += habitantes[t][p][a];
                }
            }

            double promedioPiso = (double) sumaPiso / (TORRES * APTOS);
            System.out.println("Piso " + (p + 1) + ": " + promedioPiso);
        }

        System.out.println("\nTOTAL DE HABITANTES DEL COMPLEJO: " + totalHabitantes);

        System.out.println("\nAPARTAMENTOS DISPONIBLES PARA ALQUILER:");

        for (int t = 0; t < TORRES; t++) {
            for (int p = 0; p < PISOS; p++) {
                for (int a = 0; a < APTOS; a++) {

                    if (disponible[t][p][a]) {
                        System.out.println("Torre: " + (t + 1)
                                + " Piso: " + (p + 1)
                                + " Apto: " + (a + 1));
                    }
                }
            }
        }
    }
}