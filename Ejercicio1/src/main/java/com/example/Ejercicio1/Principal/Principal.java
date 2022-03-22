package com.example.Ejercicio1.Principal;

import com.example.Ejercicio1.Persona.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController     //Para devolver un JSON
public class Principal {
    @GetMapping("/user/{nombre}")       //Metodo GET y url despues del puerto
    public String Usuario(@PathVariable String nombre){     //Metodo String que devuelve una variable (.../user/endika)
        return "Hola "+ nombre;     //Devuelve texto y variable
    }

    /* Este metodo era solo para probar si funcionaba
    @GetMapping(value="/users")
    public String Usuario(){
        return "Hola Mundo";
    }
    */
    /*
    @PostMapping("/useradd")        //Metodo POST y url despues del puerto
    public @ResponseBody Persona nuevaPersona(@RequestBody Persona persona){
        Persona o = new Persona();      //Creamos el objeto de la clase persona
        int edadPersona = Integer.parseInt(persona.getEdad()) + 1;      //Creamos variable que sea la edad + 1
        o.setEdad(edadPersona + "");        //Metemos en el objeto con el metodo SET la edad desde la variable anterior
        o.setNombre(persona.getNombre());       //Metemos en el objeto con el metodo SET el nombre desde el metodo GET
        o.setPoblacion(persona.getPoblacion());     //Metemos en el objeto con el metodo SET la poblacion desde el metodo GET
        return o;       //Devolvemos el objeto
    }

     */
    @PostMapping("/useradd")        //Metodo POST y url despues del puerto
    public @ResponseBody Persona nuevaPersona(@RequestBody Persona persona){
        return new Persona(persona.getNombre(), persona.getEdad()+1, persona.getPoblacion());      //Creamos el objeto de la clase persona
    }

}
