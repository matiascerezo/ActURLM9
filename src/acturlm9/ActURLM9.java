package acturlm9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class ActURLM9 {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL url = new URL("http://www.servidor.com/cercar?tipus=compres&inici=2010-03-01&final=2010-03-31");
        System.out.println("PROTOCOLO ----------------> " + url.getProtocol());
        System.out.println("AUTORITAT ----------------> " + url.getAuthority());
        System.out.println("HOST ----------------> " + url.getHost());
        System.out.println("PORT ----------------> " + url.getPort());
        System.out.println("PATH ----------------> " + url.getPath());
        System.out.println("QUERY ----------------> " + url.getQuery());
        System.out.println("FILENAME ----------------> " + url.getFile());
        System.out.println("REF ----------------> " + url.getRef());
        System.out.println();

        //llegirURL();
        
        //comunicacioURL();

    }

    public static void llegirURL() throws MalformedURLException, IOException {

        try {
            URL url = new URL("http://www.elpais.com");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (MalformedURLException mue) {
            System.out.println("URL no válida");
        } catch (IOException ioe) {
            System.out.println("Error en la comunicación");
        }
    }

    public static void comunicacioURL() {
        try {
            URL url = new URL("http://www.elpais.es");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);
            conexion.connect();

            //Lectura i mostra de les capçaleres
            int i = 1;
            while (conexion.getHeaderFieldKey(i) != null) {
                System.out.println(conexion.getHeaderFieldKey(i) + 46);
                System.out.println(conexion.getHeaderFieldKey(i) + ":" + conexion.getHeaderField(i));
                i++;
            }
            //Lectura i mostra del contingut

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String s = in.readLine();
            while (s != null) {
                System.out.println(s);
                s = in.readLine();
            }
        } catch (Exception e) {
            System.out.println("Fallo");
        }
    }
}
