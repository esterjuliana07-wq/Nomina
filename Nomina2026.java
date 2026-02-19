import java.util.Scanner;

public class NominaFebrero2026 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] codigo = new String[10];
        String[] depto = new String[10];
        String[] nombre = new String[10];
        String[] apellido = new String[10];

        double[] salario = new double[10];
        double[] prestamo = new double[10];
        int[] anio = new int[10];

        int cantidad = 0;
        int opcion;

        do {

            System.out.println("\n=========================================");
            System.out.println("        EMPRESA Juliana S.R.L");
            System.out.println("        NOMINA FEBRERO 2026");
            System.out.println("        MONEDA: RD$");
            System.out.println("=========================================");
            System.out.println("1. Crear Nomina");
            System.out.println("2. Modificar Registro");
            System.out.println("3. Ver Nomina");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                // CREAR NOMINA
                case 1:

                    char seguir;

                    do {

                        if (cantidad == 10) {
                            System.out.println("Maximo 10 empleados.");
                            break;
                        }

                        sc.nextLine();

                        System.out.println("\nEmpleado #" + (cantidad + 1));

                        System.out.print("Departamento/Puesto: ");
                        depto[cantidad] = sc.nextLine();

                        System.out.print("Nombre: ");
                        nombre[cantidad] = sc.nextLine();

                        System.out.print("Apellido: ");
                        apellido[cantidad] = sc.nextLine();

                        System.out.print("Salario: ");
                        salario[cantidad] = sc.nextDouble();

                        System.out.print("Prestamo (0 si no tiene): ");
                        prestamo[cantidad] = sc.nextDouble();

                        System.out.print("Año ingreso: ");
                        anio[cantidad] = sc.nextInt();

                        codigo[cantidad] = (cantidad + 1) + "-"
                                + nombre[cantidad].toUpperCase().charAt(0)
                                + apellido[cantidad].toUpperCase().charAt(0)
                                + "-" + anio[cantidad];

                        cantidad++;

                        if (cantidad < 10) {
                            System.out.print("¿Agregar otro? (s/n): ");
                            seguir = sc.next().toLowerCase().charAt(0);
                        } else {
                            seguir = 'n';
                        }

                    } while (seguir == 's');

                    break;

                // MODIFICAR
                case 2:

                    System.out.print("Numero empleado: ");
                    int pos = sc.nextInt() - 1;

                    if (pos >= 0 && pos < cantidad) {

                        sc.nextLine();

                        System.out.print("Nuevo Depto: ");
                        depto[pos] = sc.nextLine();

                        System.out.print("Nuevo Nombre: ");
                        nombre[pos] = sc.nextLine();

                        System.out.print("Nuevo Apellido: ");
                        apellido[pos] = sc.nextLine();

                        System.out.print("Nuevo Salario: ");
                        salario[pos] = sc.nextDouble();

                        System.out.print("Nuevo Prestamo: ");
                        prestamo[pos] = sc.nextDouble();

                        System.out.print("Nuevo Año: ");
                        anio[pos] = sc.nextInt();

                        codigo[pos] = (pos + 1) + "-"
                                + nombre[pos].toUpperCase().charAt(0)
                                + apellido[pos].toUpperCase().charAt(0)
                                + "-" + anio[pos];

                        System.out.println("Modificado!");
                    }

                    break;

                // VER NOMINA
                case 3:

                    System.out.println("\n================ NOMINA ===========================================================================================================");

                    System.out.printf("%-10s %-12s %-10s %-10s %-10s %-7s %-7s %-7s %-7s %-8s %-10s %-10s\n",
                            "CODIGO", "DEPTO", "NOMBRE", "APELLIDO", "SALARIO",
                            "SFS", "SFSE", "AFP", "AFPE", "ISR", "TOT DESC", "S.TOTAL");

                    for (int i = 0; i < cantidad; i++) {

                        double sfs = salario[i] * 0.0304;
                        double sfse = salario[i] * 0.0709;

                        double afp = salario[i] * 0.0287;
                         double afpe = salario[i] * 0.0710;

                        double salarioISR = salario[i] - (sfs + afp);

                        double salarioAnual = salarioISR * 12;
                        double isrAnual = 0;

                        if (salarioAnual <= 416220) {
                            isrAnual = 0;
                        }
                        else if (salarioAnual <= 624329) {
                            isrAnual = (salarioAnual - 416220) * 0.15;
                        }
                        else if (salarioAnual <= 867123) {
                            isrAnual = 31216 + (salarioAnual - 624329) * 0.20;
                        }
                        else {
                            isrAnual = 79776 + (salarioAnual - 867123) * 0.25;
                        }

                        double isr = isrAnual / 12;

                        double totalDesc = sfs + afp + sfse + afpe + isr + prestamo[i];
                        double subTotal = salario[i] - totalDesc;

                        System.out.printf("%-10s %-12s %-10s %-10s %-10.2f %-7.2f %-7.2f %-7.2f %-7.2f %-8.2f %-10.2f %-10.2f\n",
                                codigo[i], depto[i], nombre[i], apellido[i],
                                salario[i], sfs, sfse, afp, afpe, isr, totalDesc, subTotal);
                        System.out.println("\n===========================================================================================================================");

                    }

                    break;

                case 4:
                    System.out.println("Hasta luego...");
                    break;
            }

        } while (opcion != 4);
    }
}
