package Prueba;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiarImg {

	public static String guardarEnIMG(String rutaArchivo, String nombreDestino) {
        Path origen = Paths.get(rutaArchivo);
        Path destino = Paths.get("src/main/java/IMG/", nombreDestino + ".jpg");

        try {
            File archivoOrigen = new File(rutaArchivo);
            File archivoDestino = new File(destino.toString());

            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado exitosamente a: " + archivoDestino.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }
        return "src/main/java/IMG/"+ nombreDestino + ".jpg";
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String rutaArchivo = "C:\\Users\\2DAMDesktop\\Captura.PNG";
        String nombreDestino = "Luismi2";

        guardarEnIMG(rutaArchivo, nombreDestino);
        
    }
	
	
	
	
	
}
