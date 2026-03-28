import java.util.Scanner;

/**
 * La clase Torre representa una torre en el tablero de ajedrez, con sus coordenadas 
 * en el tablero y su color. Implementa la interfaz Movimiento.
 */
public class Torre implements Movimiento {
    int x;
    int y;
    String color;

    /**
     * Constructor de la clase Torre que inicializa la posición (x, y) y el color.
     *
     * @param x Coordenada x de la torre.
     * @param y Coordenada y de la torre.
     * @param color Color de la torre.
     */
    public Torre(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Obtiene la coordenada x de la torre.
     *
     * @return La coordenada x de la torre.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la coordenada x de la torre.
     *
     * @param x La nueva coordenada x de la torre.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada y de la torre.
     *
     * @return La coordenada y de la torre.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada y de la torre.
     *
     * @param y La nueva coordenada y de la torre.
     */
    public void setY(int y) {
        this.y = y;
    }

    private Scanner sc = new Scanner(System.in); // Solo una instancia de Scanner

    /**
     * Método sobrescrito de la interfaz Movimiento que permite avanzar la torre 
     * en el tablero según el número de casillas especificadas por el usuario. 
     * La torre puede moverse horizontal o verticalmente, pero el movimiento está 
     * limitado por la presencia de otras piezas en el tablero.
     *
     * @param tablero Matriz de Movimiento que representa el tablero.
     */
    @Override
    public void avanzar(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas casillas deseas avanzar? ");
        int casillas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        /**
         * Solicita al usuario que elija la dirección y determina la nueva posición de la torre
         * según la dirección elegida. Mueve la torre hacia adelante, atrás, izquierda o derecha
         * en el tablero, verificando que no haya obstrucciones en el camino y que la posición de
         * destino esté libre.
         *
         * @param tablero Matriz de Movimiento que representa el tablero de juego.
         */
        System.out.print("Elige la dirección (izquierda, derecha, adelante, atrás): ");
        String direccion = sc.nextLine();

        int x1 = x; // Posición futura en x
        int y1 = y; // Posición futura en y

        // Determinar la nueva posición según la dirección elegida
        if (direccion.equalsIgnoreCase("izquierda")) {
            if (color.equals("blanco")) {
                y1 += casillas;
            } else {
                y1 -= casillas; // Mover hacia la izquierda (disminuir y)
            }

        } else if (direccion.equalsIgnoreCase("derecha")) {
            if (color.equals("blanco")) {
                y1 -= casillas;
            } else {
                y1 += casillas; // Mover hacia la derecha (aumentar y)
            }

        } else if (direccion.equalsIgnoreCase("adelante")) {
            if (color.equals("blanco")) {
                x1 += casillas;
            } else {
                x1 -= casillas; // Mover hacia adelante (arriba, disminuir x)
            }

        } else {
            System.out.println("Dirección inválida.");
            return;
        }

        // Verificar si el movimiento está dentro de los límites del tablero
        if (x1 < 0 || x1 >= tablero.length || y1 < 0 || y1 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        // Verificar si la posición destino está ocupada
        if (tablero[x1][y1] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        // Mover la torre si la casilla está libre
        tablero[x1][y1] = this;  // Coloca la torre en la nueva posición
        tablero[x][y] = null;    // Elimina la torre de la posición actual
        this.x = x1;             // Actualiza la posición de la torre en x
        this.y = y1;             // Actualiza la posición de la torre en y

        System.out.println("Te has movido " + casillas + " casillas hacia " + direccion + ".");
    }

    /**
     * Permite a la torre retroceder en el tablero en la dirección y cantidad de casillas especificadas,
     * verificando las obstrucciones y los límites del tablero antes de completar el movimiento.
     *
     * @param tablero Matriz de Movimiento que representa el tablero de juego.
     */
    @Override
    public void retroceder(Movimiento tablero[][]) {
        System.out.print("¿Cuántas casillas deseas retroceder? ");
        int casillas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        int x2 = x; // Posición futura en x
        int y2 = y; // Posición futura en y

        System.out.print("Elige la dirección (atras): ");
        String direccion = sc.nextLine();

        if (direccion.equalsIgnoreCase("atras")) {
            if (color.equals("blanco")) {
                x2 -= casillas;
            } else {
                x2 += casillas;
            }

        } else {
            System.out.println("Dirección inválida.");
        }

        // Verificar si el movimiento está dentro de los límites del tablero
        if (x2 < 0 || x2 >= tablero.length || y2 < 0 || y2 >= tablero[0].length) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return;
        }

        // Verificar si la posición destino está ocupada
        if (tablero[x2][y2] != null) {
            System.out.println("No se puede mover, la casilla está ocupada.");
            return;
        }

        // Mover la torre si la casilla está libre
        tablero[x2][y2] = this;  // Coloca la torre en la nueva posición
        tablero[x][y] = null;    // Elimina la torre de la posición actual
        this.x = x2;             // Actualiza la posición de la torre en x
        this.y = y2;             // Actualiza la posición de la torre en y

        System.out.println("Has retrocedido " + casillas + " casillas hacia atrás.");
    }

    /**
     * Indica que la torre puede capturar una pieza en línea recta o en una dirección lateral
     * en el tablero de ajedrez.
     *
     * @param tablero Matriz de Movimiento que representa el tablero de juego.
     */
    @Override
    public void comer(Movimiento tablero[][]) {
        System.out.println("La torre puede comer en línea recta o lateral.");
    }
}
