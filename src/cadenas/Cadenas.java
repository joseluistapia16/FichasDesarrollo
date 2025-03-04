/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadenas;

/**
 *
 * @author Usuario
 */
public class Cadenas {
    
     public static String validateString(String input) {
  // Verificar si la cadena es nula o vacía
        if (input == null || input.isEmpty()) {
            return null; // Devolver null para indicar que la cadena no es válida
        }

        // Eliminar espacios en blanco al inicio y al final de la cadena
        input = input.trim();

        // Verificar que la cadena tenga al menos 4 caracteres después de eliminar los espacios
        if (input.length() < 6) {
            return null; // Devolver null para indicar que la cadena no es válida
        }

        return input; // Devolver la cadena válida
    }
    
    
    
}
