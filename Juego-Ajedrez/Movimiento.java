/*
Autores:
Blancas Díaz Isaías  - 321327167
Hernández Moguel Francisco - 424136666 
Martínez Méndez Cedrik Alexis - 424146834
Perez Moreno Jesus  - 321099769
Sánchez Ramírez Miguel - 321018191
*/
//define los métodos que deben implementar las piezas de ajedrez para simular sus posibles movimientos en el tablero, 
//proporcionando una estructura común para verificar y ejecutar desplazamientos según las reglas del juego.

//Fecha: 27 de octubre 2024

/**
 * La interfaz Movimiento define los métodos básicos que cualquier objeto
 * que implemente esta interfaz debe proporcionar para moverse en un tablero
 * de juego, incluyendo avanzar, retroceder y comer.
 */
public interface Movimiento {

    /**
     * Realiza un movimiento hacia adelante en el tablero.
     *
     * @param tablero Un arreglo bidimensional de objetos Movimiento que representa el tablero de juego.
     */
    void avanzar(Movimiento tablero[][]);

    /**
     * Realiza un movimiento hacia atrás en el tablero.
     *
     * @param tablero Un arreglo bidimensional de objetos Movimiento que representa el tablero de juego.
     */
    void retroceder(Movimiento tablero[][]);

    /**
     * Realiza una acción de comer en el tablero.
     *
     * @param tablero Un arreglo bidimensional de objetos Movimiento que representa el tablero de juego.
     */
    void comer(Movimiento tablero[][]);

    /**
     * Establece la coordenada X.
     *
     * @param x La nueva coordenada X.
     */
    void setX(int x);

    /**
     * Obtiene la coordenada X.
     *
     * @return La coordenada X actual.
     */
    int getX();

    /**
     * Establece la coordenada Y.
     *
     * @param y La nueva coordenada Y.
     */
    void setY(int y);

    /**
     * Obtiene la coordenada Y.
     *
     * @return La coordenada Y actual.
     */
    int getY();
}
