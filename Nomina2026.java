package com.mycompany.mavenproject2;

import java.util.Scanner;

public class Nomina2026 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] empleados = new String[10][4];
        double[][] pagos = new double[10][9];

        int opcion;

        do {

            System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("        EMPRESA XYZ");
            System.out.println("        Valores en RD$");
            System.out.println("        Nomina Febrero 2026");
            System.out.println("================================================================");
            System.out.println("1. Crear Nomina");
            System.out.println("2. Modificar Registro");
            System.out.println("3. Mostrar Nomina");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    sc.nextLine();

                    for (int i = 0; i < 10; i++) {

                        System.out.println("\nEmpleado #" + (i + 1));

                        System.out.print("Departamento/Puesto: ");
                        empleados[i][1] = sc.nextLine();

                        System.out.print("Nombre: ");
                        empleados[i][2] = sc.nextLine();

                        System.out.print("Apellido: ");
                        empleados[i][3] = sc.nextLine();

                        System.out.print("Año Ingreso: ");
                        int year = sc.nextInt();

                        empleados[i][0] = (i + 1) + ""
                                + empleados[i][2].toLowerCase().charAt(0)
                                + empleados[i][3].toUpperCase().charAt(0)
                                + year;

                        System.out.print("Salario RD$: ");
                        pagos[i][0] = sc.nextDouble();

                        System.out.print("Descuento Prestamo (0 si no tiene): ");
                        pagos[i][1] = sc.nextDouble();

                        calcularDescuentos(pagos, i);
                        sc.nextLine();
                    }

                    System.out.println("\nNomina creada correctamente.");
                }

                case 2 -> {

                    System.out.print("Ingresar numero de empleado (1-10): ");
                    int pos = sc.nextInt() - 1;

                    if (pos >= 0 && pos < 10 && empleados[pos][0] != null) {

                        System.out.print("Nuevo salario: ");
                        pagos[pos][0] = sc.nextDouble();

                        System.out.print("Nuevo prestamo: ");
                        pagos[pos][1] = sc.nextDouble();

                        calcularDescuentos(pagos, pos);

                        System.out.println("Registro modificado correctamente.");

                    } else {
                        System.out.println("Empleado no valido.");
                    }
                }

                case 3 -> {

                    System.out.println("\n==============================================================================================================");
                    System.out.printf("| %-10s | %-15s | %-12s | %-12s | %-10s | %-8s | %-8s | %-8s | %-8s | %-10s |\n",
                            "COD", "DEP", "NOMBRE", "APELLIDO", "SALARIO", "PREST", "SFS", "AFP", "ISR", "NETO");
                    System.out.println("==============================================================================================================");

                    for (int i = 0; i < 10; i++) {

                        if (empleados[i][0] != null) {

                            System.out.printf("| %-10s | %-15s | %-12s | %-12s | %10.2f | %8.2f | %8.2f | %8.2f | %8.2f | %10.2f |\n",
                                    empleados[i][0],
                                    empleados[i][1],
                                    empleados[i][2],
                                    empleados[i][3],
                                    pagos[i][0],
                                    pagos[i][1],
                                    pagos[i][2],
                                    pagos[i][4],
                                    pagos[i][6],
                                    pagos[i][8]
                            );

                            System.out.println("--------------------------------------------------------------------------------------------------------------");
                        }
                    }
                }

                case 4 -> System.out.println("Saliendo...");

                default -> System.out.println("Opcion invalida.");
            }

        } while (opcion != 4);

        sc.close();
    }

    private static void calcularDescuentos(double[][] pagos, int i) {

        double salario = pagos[i][0];

        pagos[i][2] = salario * 3.04 / 100;
        pagos[i][3] = salario * 7.09 / 100;
        pagos[i][4] = salario * 2.87 / 100;
        pagos[i][5] = salario * 7.10 / 100;

        double salarioISR = salario - pagos[i][2] - pagos[i][4];

        pagos[i][6] = salarioISR * 10 / 100;

        pagos[i][7] = pagos[i][1] + pagos[i][2] + pagos[i][4] + pagos[i][6];

        pagos[i][8] = salario - pagos[i][7];
    }
}
