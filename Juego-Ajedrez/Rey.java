import java.util.Scanner;

/**
 * La clase Rey representa una pieza de ajedrez llamada "Rey" en un tablero. 
 * Implementa la interfaz Movimiento y contiene métodos para avanzar, retroceder 
 * y comer en el tablero.
 */
public class Rey implements Movimiento {
    int x;
    int y;
    String color;

    /**
     * Constructor para inicializar la posición y el color del Rey.
     * 
     * @param x     La coordenada x inicial.
     * @param y     La coordenada y inicial.
     * @param color El color del Rey (blanco o negro).
     */
    public Rey(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Obtiene la coordenada x del Rey.
     * 
     * @return La coordenada x.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la coordenada x del Rey.
     * 
     * @param x La nueva coordenada x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada y del Rey.
     * 
     * @return La coordenada y.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada y del Rey.
     * 
     * @param y La nueva coordenada y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Mueve el Rey una casilla en la dirección especificada, si es posible. 
     * Verifica que el movimiento esté dentro de los límites del tablero y 
     * que la casilla destino esté libre.
     * 
     * @param tablero El tablero de juego, representado como una matriz de 
     *                Movimiento.
     */
    @Override
    public void avanzar(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);
        // El rey solo puede moverse una casilla

        System.out.println("Elige la dirección en la que deseas avanzar (arriba, abajo, izquierda, derecha, diagonal arriba-izquierda, diagonal arriba-derecha, diagonal abajo-izquierda, diagonal abajo-derecha): ");
        String direccion = sc.nextLine();

        // Variables para la nueva posición
        int x1 = x;
        int y1 = y;

        // Ejecutar la dirección elegida
        if (direccion.equalsIgnoreCase("arriba")) {
            x1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion.equalsIgnoreCase("abajo")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else if (direccion.equalsIgnoreCase("izquierda")) {
            y1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion.equalsIgnoreCase("derecha")) {
            y1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else if (direccion.equalsIgnoreCase("diagonal arriba-izquierda")) {
            x1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
            y1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion.equalsIgnoreCase("diagonal arriba-derecha")) {
            x1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
            y1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else if (direccion.equalsIgnoreCase("diagonal abajo-izquierda")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
            y1 += (color.equalsIgnoreCase("blanco") ? 1 : -1);
        } else if (direccion.equalsIgnoreCase("diagonal abajo-derecha")) {
            x1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
            y1 += (color.equalsIgnoreCase("blanco") ? -1 : 1);
        } else {
            System.out.println("Dirección no válida.");
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

        // Mover el rey si la casilla está libre
        tablero[x1][y1] = this;  // Coloca el rey en la nueva posición
        tablero[x][y] = null;    // Elimina el rey de la posición actual
        this.x = x1;             // Actualiza la posición del rey en x
        this.y = y1;             // Actualiza la posición del rey en y

        System.out.println("Te has movido 1 casilla hacia " + direccion);
    }

    /**
     * Retrocede el Rey una casilla en la dirección especificada. Verifica que 
     * la dirección sea válida y que el movimiento sea posible.
     * 
     * @param tablero El tablero de juego, representado como una matriz de 
     *                Movimiento.
     */
    @Override
    public void retroceder(Movimiento tablero[][]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántas casillas deseas retroceder? ");
        int casillas = sc.nextInt();
        sc.nextLine(); // limpiar el buffer

        if (casillas == 1) {
            System.out.println("Elige la dirección (derecha, izquierda, diagonal o línea recta): ");
            String direccion = sc.nextLine();

            if (direccion.equalsIgnoreCase("diagonal derecha")) {
                System.out.println("Has retrocedido 1 casilla hacia la diagonal derecha.");
            } else if (direccion.equalsIgnoreCase("diagonal izquierda")) {
                System.out.println("Has retrocedido 1 casilla hacia la diagonal izquierda.");
            } else if (direccion.equalsIgnoreCase("línea recta")) {
                System.out.println("Has retrocedido 1 casilla en línea recta.");
            } else {
                System.out.println("Dirección no válida.");
            }
        } else {
            System.out.println("El rey solo puede retroceder una casilla.");
        }
    }

    /**
     * El Rey puede comer en la casilla donde cae.
     * 
     * @param tablero El tablero de juego, representado como una matriz de 
     *                Movimiento.
     */
    public void comer(Movimiento tablero[][]) {
        System.out.println("El rey solo puede comer en la casilla donde cae.");
    }
}
