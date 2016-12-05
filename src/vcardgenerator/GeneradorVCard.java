/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcardgenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reymundo Tenorio
 */
public class GeneradorVCard {
    
     public void CreateVcf() {

        Person Persona1 = new Person("Reymundo", "Tenorio", "8888 8888", "Nicaragua");
        Person Persona2 = new Person("Carlos", "López", "8888 8888", "Nicaragua");
        Person Persona3 = new Person("María", "Sánchez", "8888 8888", "Nicaragua");
        Person Persona4 = new Person("José", "González", "8888 8888", "Nicaragua");
       

        List <Person> Personas = new ArrayList();
        Personas.add(Persona1);
        Personas.add(Persona2);
        Personas.add(Persona3);
        Personas.add(Persona4);

        File vcfFile = new File("Generate.vcf");
        FileWriter fw = null;
        try {
            fw = new FileWriter(vcfFile);
        } catch (IOException ex) {
            Logger.getLogger(VCardGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Person p : Personas) {
            try {
                fw.write("BEGIN:VCARD\r\n");
                fw.write("VERSION:2.1\r\n");

                fw.write("N:" + p.getLastName() + ";" + p.getFirstName() + ";;;\r\n");
                fw.write("FN:" + p.getFirstName() + " " + p.getLastName() + "\r\n");
                fw.write("TEL;CELL:" + p.getPhoneNumber() + "\r\n");
                fw.write("ADR;HOME:;;" + p.getAddress() + ";;;;\r\n");
                
                fw.write("END:VCARD\r\n");
            } catch (IOException ex) {
                Logger.getLogger(VCardGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(VCardGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Guardado con éxito");

    }

   

}
