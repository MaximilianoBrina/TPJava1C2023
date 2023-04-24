package proceso;

import modelo.Casa;
import modelo.Estudiante;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hogwarts {

    private Map<String, Casa> casas;

    public Hogwarts() {
        casas = new HashMap<>();
        casas.put("Gryffindor", new Casa(1,"Gryffindor"));
        casas.put("Slytherin", new Casa(2, "Slytherin"));
        casas.put("Hufflepuff", new Casa(3, "Hufflepuff"));
        casas.put("Ravenclaw", new Casa(4, "Ravenclaw"));
    }

    public void agregarEstudiante(Estudiante e) {
        if (casas.containsKey(e.getNombreCasa())) {
            casas.get(e.getNombreCasa()).agregarEstudiante(e);
        }
        else
            throw new RuntimeException("Error: El nombre de la casa no existe.");

    }

    public Casa getCasa(String nombre){
        return casas.get(nombre);
    }

    //Consigna 2 según clase 19/4
    public List<Estudiante> getNoHumanos() {
        List<Estudiante> noHumanosCasas = new ArrayList<>();

        for (Casa casa: casas.values()) {
            List<Estudiante> noHumanosCasa = casa.getNoHumanos();
            noHumanosCasas.addAll(noHumanosCasa);
        }
        return noHumanosCasas;
    }

}
