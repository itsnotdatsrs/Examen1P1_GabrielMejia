package examen1p1_gabrielmejia;
        

import java.util.Scanner;
import java.util.Random;
        
public class Examen1P1_GabrielMejia {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("Menu de Ejercicios:");
            System.out.println("1. Fight or Flight (8 puntos)");
            System.out.println("2. Tri Fuerza (6 puntos)");
            System.out.println("3. Salir");

            System.out.print("Selecciona una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> {
                    Scanner scanner = new Scanner(System.in);
                    Random random = new Random();
                    System.out.println("Fight or Flight");

                    int DistanciaRival = random.nextInt(16) + 15;
                    int balas = 25;
                    int RivalVida = 25;
                    int dañominimo = 1;
                    int dañomaximo = 7;
                    int RivalMinimo = 3;
                    int RivalMaximo = 5;
                    int probabilidadInicial = 65; 
                    
                    System.out.println("Ingrese Maestria");
                    System.out.println("1. Principiante");
                    System.out.println("2. Intermedio");
                    System.out.println("3. Experto");

                    int Maestria = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    switch (Maestria) {

                        case 1 -> probabilidadInicial += 0;
                        case 2 -> probabilidadInicial += 5;
                        case 3 -> probabilidadInicial += 15;
                        default -> System.out.println("Opcion no valida, eligiendo principiante");
                    }

                    while (balas > 0 && DistanciaRival > 0) {
                        System.out.println("Ronda " + (26 - balas));
                        System.out.println("El jugador cuenta con: " + balas + " balas!");
                        System.out.println("Vida restante del zombie: " + RivalVida);
                        System.out.println("El zombie se encuentra a: " + DistanciaRival + "metros");

                        System.out.println("Listo para la siguiente ronda [S/N]");
                        char respuesta = scanner.nextLine().toUpperCase().charAt(0);

                        if (respuesta == 'S') {
                            
                            int probabilidadDisparo = random.nextInt(100) + 1;

                            if (probabilidadDisparo <= probabilidadInicial) {
                                
                                int daño = random.nextInt(dañomaximo - dañominimo + 1) + dañominimo;
                                RivalVida -= daño;
                                System.out.println("Hit! El tiro ha reducido el HP del Zombie por un total de " + daño + "!");
                            } else {
                                System.out.println("Ha fallado!");
                            }

                            int AvanceRival = random.nextInt(RivalMaximo - RivalMinimo + 1) + RivalMinimo;
                            DistanciaRival -= AvanceRival;

                        } else if (respuesta == 'N') {
                            System.out.println("Fin.");
                            break;
                        } else {
                            
                            System.out.println("Opcion no valida");
                        }

                        balas--;
                    }

                    if (RivalVida <= 0) {
                        System.out.println("YOU WIN, has logrado vencer al zombie!");
                    }else{
                    if (balas <= 0) {
                        System.out.println("GAME OVER, las balas se han acabado.");
                    }else{
                        System.out.println("GAME OVER, la distancia se redujo a 0!");
                    }
                    }  
                } // Fin de Case 1
                    
                    
                case 2 -> {
                    System.out.println("Tri Fuerza");
                        Scanner scanner = new Scanner(System.in);
                        int tamaño = 0;

                        while (tamaño <= 20 || tamaño % 2 != 0) {
                            System.out.print("Numero par y mayor que 20: ");
                            tamaño = scanner.nextInt();
                            if (tamaño <= 20 || tamaño % 2 != 0) {
                                System.out.println("Numero no valido");
                            }
                        }
                        // Triangulo arriba
                        for (int i = 0; i < tamaño / 2; i++) {
                            // Espacios antes del Triangulo de arriba
                            for (int j = 0; j < tamaño - i - 1; j++) {
                                System.out.print(" ");
                            }

                            
                            for (int j = 0; j <= i; j++) {
                                System.out.print("* ");
                            }

                            // Espacios despues del triangulo de arriba
                            for (int j = 0; j < tamaño - i - 1; j++) {
                                System.out.print(" ");
                            }

                            System.out.println();
                        }// Fin de Triangulo de arriba
                        
                        // Triangulos de Abajo
                        for (int i = 0; i < tamaño / 2; i++) {
                            // Espacios antes del triángulo izquierdo
                            for (int j = 0; j < tamaño / 2 - i - 1; j++) {
                                System.out.print(" ");
                            }

                            // Triangulo izquierdo
                            for (int j = 0; j <= i; j++) {
                                System.out.print("* ");
                            }

                            // Espacio en medio
                            for (int j = 0; j < tamaño - 2 * (i + 1); j++) {
                                System.out.print(" ");
                            }

                            // Triangulo derecho
                            for (int j = 0; j <= i; j++) {
                                System.out.print("* ");
                            }

                            System.out.println();
                        }// Fin de Triangulos de abajo
                    } // Fin de Case 2

                case 3 -> {
                    
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    } // Fin de Main
}// Fin de Class
