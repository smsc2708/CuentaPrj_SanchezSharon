import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalCuenta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        Cuenta cuentaActual = null;
        int opcion;

        do {
            System.out.println("\nMenú principal");
            System.out.println("1) Crear Cuenta");
            System.out.println("2) Conocer la cantidad de Cuentas Creadas");
            System.out.println("3) Listar Cuentas");
            System.out.println("4) Seleccionar Cuenta actual");
            System.out.println("5) Depositar");
            System.out.println("6) Retirar");
            System.out.println("7) Consultar Saldo");
            System.out.println("8) Consultar Estado (toString)");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Creación de cuenta:");
                    System.out.println("1) Crear con saldo y nombre");
                    System.out.println("2) Crear solo con saldo (nombre después)");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Digite el nombre del cuentaHabiente: ");
                        String nombre = sc.nextLine();
                        System.out.print("Digite el saldo inicial: ");
                        double saldo = sc.nextDouble();
                        cuentas.add(new Cuenta(nombre, saldo));
                        System.out.println("Cuenta creada exitosamente.");
                    } else if (tipo == 2) {
                        System.out.print("Digite el saldo inicial: ");
                        double saldo = sc.nextDouble();
                        Cuenta c = new Cuenta(saldo);
                        cuentas.add(c);
                        sc.nextLine();
                        System.out.print("Digite el nombre del cuentaHabiente: ");
                        String nombre = sc.nextLine();
                        c.setNombreCuentaHabiente(nombre);
                        System.out.println("Cuenta creada exitosamente.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 2:
                    System.out.println("Cantidad de cuentas creadas: " + Cuenta.getCantCuentasCreada());
                    break;

                case 3:
                    System.out.println("Listado de cuentas:");
                    for (int i = 0; i < cuentas.size(); i++) {
                        System.out.println((i + 1) + ") " + cuentas.get(i).getCodCuenta() +
                                " - " + cuentas.get(i).toString());
                    }
                    break;

                case 4:
                    System.out.print("Digite el número de la cuenta a seleccionar: ");
                    int numCuenta = sc.nextInt();
                    if (numCuenta > 0 && numCuenta <= cuentas.size()) {
                        cuentaActual = cuentas.get(numCuenta - 1);
                        System.out.println("Cuenta seleccionada: " + cuentaActual.getCodCuenta());
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 5:
                    if (cuentaActual != null) {
                        System.out.print("Digite el monto a depositar: ");
                        double monto = sc.nextDouble();
                        double nuevoSaldo = cuentaActual.depositar(monto);
                        System.out.println("Depósito exitoso. Nuevo saldo: " + nuevoSaldo);
                    } else {
                        System.out.println("Seleccione primero una cuenta.");
                    }
                    break;

                case 6:
                    if (cuentaActual != null) {
                        System.out.print("Digite el monto a retirar: ");
                        double monto = sc.nextDouble();
                        double nuevoSaldo = cuentaActual.retirar(monto);
                        System.out.println("Nuevo saldo: " + nuevoSaldo);
                    } else {
                        System.out.println("Seleccione primero una cuenta.");
                    }
                    break;

                case 7:
                    if (cuentaActual != null) {
                        System.out.println("Saldo actual: " + cuentaActual.getSaldo());
                    } else {
                        System.out.println("Seleccione primero una cuenta.");
                    }
                    break;

                case 8:
                    if (cuentaActual != null) {
                        System.out.println("Estado de la cuenta:");
                        System.out.println(cuentaActual.toString());
                    } else {
                        System.out.println("Seleccione primero una cuenta.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
