package com.dio.collections.maps.map;

import java.util.*;

public class Map1 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionario e relacione os modelos e seus respectivos consumos:");

        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);

        }};
        System.out.println(carrosPopulares);

        System.out.println("Substitua o valor de consumo do gol por 15.2:");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("confira se o modelo tucson está no dicionario:" + carrosPopulares.containsKey("tucson"));

        System.out.println("exiba o cnsumo do uno: " + carrosPopulares.get("uno"));

        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());

        System.out.println("exiba o consumo dos carros: " + carrosPopulares.values());

        System.out.println("Exiba o carro mais economico: ");
        Double consumoEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoEficiente)) modeloEficiente = entry.getKey();
        }


        System.out.println("Modelo: " + modeloEficiente + " " + consumoEficiente);

        System.out.println("Exiba o carro menos economico: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Medelo menos economico: " + modeloMenosEficiente + " " + consumoMenosEficiente);
            }
        }


        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;

        while(iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a media de consumos dos carros: " + (soma/carrosPopulares.size()));

        System.out.println("remova os carros com consumo igual a 15.6: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba os carros na ordem em que foram informados: ");

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Exiba o dicionario ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague os carros:");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionario está vazio: " +carrosPopulares.isEmpty());
    }
}
