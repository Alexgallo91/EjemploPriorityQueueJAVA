
package pruebaproperties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;


public class PruebaProperties {
    
    private Properties tabla;
    
    public PruebaProperties()
    {
        tabla = new Properties();
        
        tabla.setProperty("color", "azul");
        tabla.setProperty("anchura", "200");
        
        System.out.println("Despues de establecer propiedades: \n");
        listarPropiedades();
        
        //reemplaza el valor de una propiedad
        tabla.setProperty("color", "rojo");
        
        System.out.println("Despues de reemplazar propiedades");
        listarPropiedades();
        
        guardarLasPropiedades();
        
        tabla.clear(); //limpia o borra todo
        System.out.println("Despues de limpiar: \n");
        listarPropiedades();
        
        cargarPropiedades();
        
        Object valor = tabla.getProperty("color");
        
        if(valor != null)
            System.out.printf("El valor de la propiedad color es %s\n",
                                valor);
        else
            System.out.println("La propiedad color no esta en la tabla");    
    }

    public void listarPropiedades()
    {
        Set<Object> claves = tabla.keySet();
        for(Object o:claves)
            System.out.printf("%s\t\t%s\n", o, tabla.getProperty((String)o));
        System.out.println();
    }
    
    public void guardarLasPropiedades()
    {
        try
        {
            FileOutputStream salida = new FileOutputStream("props.txt");
            tabla.store(salida, "Propiedades de ejemplo");
            salida.close();
            System.out.println("Despues de guardar las propiedades");
            listarPropiedades();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void cargarPropiedades()
    {
        try
        {
            FileInputStream entrada = new FileInputStream("props.txt");
            tabla.load(entrada);
            entrada.close();
            System.out.println("Despues de cargar las propiedades");
            listarPropiedades();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }  
        
    }
    
    public static void main(String[] args) {
        new PruebaProperties();
    }
    
}
