/*
Autores:
Blancas Díaz Isaías  - 321327167
Hernández Moguel Francisco - 424136666 
Martínez Méndez Cedrik Alexis - 424146834
Perez Moreno Jesus  - 321099769
Sánchez Ramírez Miguel - 321018191
*/
//Fecha: 27 de octubre 2024

import java.util.Scanner;

/**
 * La clase Ajedrez implementa un juego de ajedrez básico con un tablero de 8x8,
 * donde se pueden realizar movimientos de piezas como peones, torres, caballos,
 * alfiles, reina y rey. El usuario puede avanzar, retroceder o comer con una pieza.
 */
public class Ajedrez {

    /**
     * Constructor vacío para la clase Ajedrez.
     * Inicializa una nueva instancia del juego sin configurar el tablero.
     */
    public Ajedrez() {
        // Constructor vacío
    }

    /**
     * Método principal del programa. Inicializa el tablero de ajedrez, coloca las piezas
     * en sus posiciones iniciales y proporciona un menú para que el usuario realice
     * movimientos de las piezas.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        int tamano = 8;  // Tamaño del tablero de ajedrez (8x8)
        Movimiento[][] tablero = new Movimiento[tamano][tamano];

        // Inicializar el tablero vacío
        for (int row = 0; row < tamano; row++) {
            for (int col = 0; col < tamano; col++) {
                tablero[row][col] = null;  // Espacio vacío
            }
        }

        // Colocar peones en la segunda y séptima fila
        for (int col = 0; col < tamano; col++) {
            tablero[1][col] = new Peon(1, col, "blanco");  // Peones blancos
            tablero[6][col] = new Peon(6, col, "negro");  // Peones negros
        }

        // Colocar otras piezas en sus posiciones iniciales
        tablero[0][0] = new Torre(0, 0, "blanco");  // Torres blancas
        tablero[0][7] = new Torre(0, 7, "blanco");  
        tablero[7][0] = new Torre(7, 0, "negro");  
        tablero[7][7] = new Torre(7, 7, "negro");  
        tablero[0][1] = new Caballo(0, 1, "blanco");  // Caballos blancos
        tablero[0][6] = new Caballo(0, 6, "blanco");  
        tablero[7][1] = new Caballo(7, 1, "negro");  
        tablero[7][6] = new Caballo(7, 6, "negro");  
        tablero[0][2] = new Alfil(0, 2, "blanco");  // Alfiles blancos
        tablero[0][5] = new Alfil(0, 5, "blanco");  
        tablero[7][2] = new Alfil(7, 2, "negro");  
        tablero[7][5] = new Alfil(7, 7, "negro");  
        tablero[0][3] = new Reina(0, 3, "blanco");  // Reina blanca
        tablero[7][3] = new Reina(7, 3, "negro");  
        tablero[0][4] = new Rey(0, 4, "blanco");  // Rey blanco
        tablero[7][4] = new Rey(7, 4, "negro");  

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int fila;
        int columna;
        imprimirTablero(tablero);

        // Bucle para permitir que el usuario realice acciones
        do {
            System.out.println("Selecciona una acción para una pieza:");
            System.out.println("1. Avanzar");
            System.out.println("2. Retroceder");
            System.out.println("3. Comer");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el lugar donde está situada la pieza, fila-columna (ej. 1 2)");
                    fila = sc.nextInt();
                    columna = sc.nextInt();
                    tablero[fila][columna].avanzar(tablero);
                    imprimirTablero(tablero);
                    break;
                case 2:
                    System.out.println("Ingresa el lugar donde está situada la pieza, fila-columna (ej. 1 2)");
                    fila = sc.nextInt();
                    columna = sc.nextInt();
                    tablero[fila][columna].retroceder(tablero);
                    imprimirTablero(tablero);
                    break;
                case 3:
                    System.out.println("Ingresa el lugar donde está situada la pieza, fila-columna (ej. 1 2)");
                    fila = sc.nextInt();
                    columna = sc.nextInt();
                    tablero[fila][columna].comer(tablero);
                    imprimirTablero(tablero);
                    break;
                case 4:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }

    /**
     * Imprime el tablero de ajedrez en la consola, mostrando la posición actual
     * de cada pieza o los espacios vacíos.
     *
     * @param tablero Un arreglo bidimensional que representa el tablero de ajedrez.
     */
    public static void imprimirTablero(Movimiento[][] tablero) {
        int tamano = tablero.length;
        System.out.println(" 0  1  2  3  4  5  6  7  / ");
        for (int row = 0; row < tamano; row++) {
            for (int col = 0; col < tamano; col++) {
                if (tablero[row][col] instanceof Peon) {
                    if (row < tamano / 2) {
                        System.out.print("[P]");  // Peón blanco
                    } else {
                        System.out.print("[p]");  // Peón negro
                    }
                } else if (tablero[row][col] instanceof Torre) {
                    if (row < tamano / 2) {
                        System.out.print("[T]");  // Torre blanca
                    } else {
                        System.out.print("[t]");  // Torre negra
                    }
                } else if (tablero[row][col] instanceof Caballo) {
                    if (row < tamano / 2) {
                        System.out.print("[C]");  // Caballo blanco
                    } else {
                        System.out.print("[c]");  // Caballo negro
                    }
                } else if (tablero[row][col] instanceof Alfil) {
                    if (row < tamano / 2) {
                        System.out.print("[A]");  // Alfil blanco
                    } else {
                        System.out.print("[a]");  // Alfil negro
                    }
                } else if (tablero[row][col] instanceof Reina) {
                    if (row < tamano / 2) {
                        System.out.print("[Q]");  // Reina blanca
                    } else {
                        System.out.print("[q]");  // Reina negra
                    }
                } else if (tablero[row][col] instanceof Rey) {
                    if (row < tamano / 2) {
                        System.out.print("[K]");  // Rey blanco
                    } else {
                        System.out.print("[k]");  // Rey negro
                    }
                } else {
                    if ((row + col) % 2 == 0) {
                        System.out.print("[ ]");  // Casilla blanca
                    } else {
                        System.out.print("[+]");  // Casilla negra
                    }
                }
            }
            System.out.print(" " + row);
            System.out.println();  // Nueva línea para la siguiente fila
        }
    }
}

