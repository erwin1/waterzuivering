/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package merlijnsmislukkingen.waterzuivering;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author merlijn
 */
public class WaterZuivering {
    
    int water = 1;
    double stikstof = 50;
    double fosfor = 10;
    double bacterie = 0.00005;
    double algen = 3;
    double medicijnresten = 0.01;
    double microplastics = 0.05;
    double metalen = 0.175;
    double pH = 7.25;
    
    Map<String, Double> concentratieStoffen = new HashMap<>();
    Map<String, Double> voorkomen = new HashMap<>();
    
    
    public void main(String[] args) {
//        concentratieStoffen.put("stikstof", stikstof);
//        concentratieStoffen.put("fosfor", fosfor);
//        concentratieStoffen.put("bacterien", bacterie);
//        concentratieStoffen.put("algen", algen);
//        concentratieStoffen.put("medicijnresten", medicijnresten);
//        concentratieStoffen.put("microplastics", microplastics);
//        concentratieStoffen.put("metalen", metalen);
//        concentratieStoffen.put("pH-waarde", pH);
        System.err.println("GRAFIEK / VERSCHIL / VERSCHIL2 / PERCENTAGEVERLIES/ UI?");
        voorkomen.put("bacterien", 1e9);          // 1 × 10^9
        voorkomen.put("stikstof", 2.15e19);       // 2.15 × 10^19
        voorkomen.put("fosfor", 1.94e19);         // 1.94 × 10^19
        voorkomen.put("algen", 1e8);              // 1 × 10^8 (voorbeeld)
        voorkomen.put("medicijnresten", 4e18);    // 4 × 10^18
        voorkomen.put("microplastics", 1.91e6);   // 1.91 × 10^6
        voorkomen.put("metalen", 1.08e19);     
        
        System.err.println("beginwaarde:");
        updateMap();
        printMap();
        System.err.println("");
        System.err.println("");
        System.err.println("eerste zuivering");
        filtratie();
        updateMap();
        printMap();
        System.err.println("absoluut voorkomen");
        printHvlheid();
        System.err.println("");
        System.err.println("");
        System.err.println("tweede zuivering");
        coagulatieFlocculatie();
        updateMap();
        printMap();
        System.err.println("");
        System.err.println("");
        System.err.println("tweede zuivering");
        neutralisatie();
        updateMap();
        printMap();
        System.err.println("");
        System.err.println("");
        System.err.println("tweede zuivering");
        microOrganisme();
        updateMap();
        printMap();
        System.err.println("absoluut voorkomen");
        printHvlheid();
        
    }
    public void filtratie() {
        stikstof = stikstof-5*stikstof/100;
        fosfor = fosfor-10*fosfor/100;
        bacterie = bacterie -30*bacterie/100;
        algen = algen-50*algen/100;
        medicijnresten = medicijnresten-10*medicijnresten/100;
        microplastics = microplastics-30*microplastics/100;
        metalen = metalen-10*metalen/100;
    }
    public void coagulatieFlocculatie() {
        stikstof = stikstof-15*stikstof/100;
        fosfor = fosfor-70*fosfor/100;
        bacterie = bacterie * 0.1;
        algen = algen-90*algen/100;
        medicijnresten = medicijnresten-20*medicijnresten/100;
        microplastics = microplastics-80*microplastics/100;
        metalen = metalen-65*metalen/100;
    }
    public void neutralisatie() {
        pH = 7;
    }
    public void microOrganisme() {
        stikstof = stikstof-50*stikstof/100;
        fosfor = fosfor-40*fosfor/100;
        algen = algen-30*algen/100;
        medicijnresten = medicijnresten-15*medicijnresten/100;
        metalen = metalen-5*metalen/100;
    }
    public void verdamping() {
        System.err.println("achterwege gelaten voor het moment. 99% effectiviteit voor merendeel van de stoffen.");
    }
    public void updateMap() {
        concentratieStoffen.put("stikstof", stikstof);
        concentratieStoffen.put("fosfor", fosfor);
        concentratieStoffen.put("bacterien", bacterie);
        concentratieStoffen.put("algen", algen);
        concentratieStoffen.put("medicijnresten", medicijnresten);
        concentratieStoffen.put("microplastics", microplastics);
        concentratieStoffen.put("metalen", metalen);
        concentratieStoffen.put("pH-waarde", pH);
    }
    public void printMap() {
        for (Map.Entry<String, Double> entry : concentratieStoffen.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            System.out.printf("%s -> %.2e%n", entry.getKey(), entry.getValue());
    }
    }
    public void printHvlheid() {
        for (Map.Entry<String, Double> entry : concentratieStoffen.entrySet()) {
            String key = entry.getKey();
            double concentratie = entry.getValue();
            double hoeveelheid = voorkomen.getOrDefault(key, 0.0); // voorkomt NullPointerException
            String type = entry.getKey();
            if ((type!="bacterien") && (type!="algen")) {
                type = "moleculen";
            }
            double resultaat = concentratie * hoeveelheid;
            System.err.printf("%-15s -> %.3e %s%n", key, resultaat, type);

        }
    }
}
