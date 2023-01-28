import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        CuentaBancaria cuenta1 = new CuentaBancaria("Aarón Ballestín Fuertes",
                "ES4712345678901234567890");
        menu(cuenta1);

    }

    public static void menu(CuentaBancaria cuenta1) {

        int menu = 0;
        Scanner teclado = new Scanner(System.in);
        
        while (menu != 8) {
            System.out.println("---MENÚ---");
            System.out.println("1. Imprimir datos de la cuenta");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Mostrar saldo");
            System.out.println("5. Mostrar titular");
            System.out.println("6. Mostrar IBAN");
            System.out.println("7. Lista Movimientos");
            System.out.println("8. Salir Programa");
            menu = teclado.nextInt();
            switch (menu) {
                case 1:
                    System.out.println(cuenta1);
                    break;
                case 2:
                    System.out.println("¿Cuanto dinero quieres ingresar?");
                    double ingreso = teclado.nextDouble();
                    cuenta1.modificarSaldo(ingreso);
                    break;
                case 3:
                    System.out.println("¿Cuanto dinero quieres retirar?");
                    double retirar = -teclado.nextDouble();
                    cuenta1.modificarSaldo(retirar);
                    break;
                case 4:
                    System.out.println("Saldo: " + cuenta1.getSaldo());
                    break;
                case 5:
                    System.out.println("Titular: " + cuenta1.getTitularCuenta());
                    break;
                case 6:
                    System.out.println("IBAN: " + cuenta1.getIBAN());
                    break;
                case 7:
                    ArrayList<Double> movimientos = cuenta1.getMovimientos();
                    System.out.println("--Movimientos--");
                    for (int i = 0; i < movimientos.size(); i++) {
                        System.out.println(movimientos.get(i));
                    }
                    break;

            }
        }
    }

}
