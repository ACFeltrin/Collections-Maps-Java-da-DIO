package com.dio.collections.maps.exerciciosMaps;

import java.util.*;

public class exerciciosProp1 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");

        Map<String, Integer> estadosPop = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);

        }};
        System.out.println(estadosPop);

        System.out.println("Substitua a população de RN por 3.543.165: ");
        estadosPop.put("RN", 3543165);
        System.out.println(estadosPop);


        System.out.println("confira se o estado PB está no dicionario:" + estadosPop.containsKey("PB"));

        System.out.println("-----\nInserindo PB no dicionário\n------");
        estadosPop.put("PB", 4039277);

        System.out.println("População de PB: " + estadosPop.get("PB"));

        System.out.println("--\t Ordem Inserção \t--");
        System.out.println(estadosPop);

        System.out.println("--\t Ordem Alfabética \t--");
        Map<String, Integer> estadosPop1 = new TreeMap<>(estadosPop);
        System.out.println(estadosPop1);

        Integer menorPop = Collections.min(estadosPop1.values());
        Set<Map.Entry<String, Integer>> entries = estadosPop1.entrySet();
        String menorEst = "";
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(menorPop)) menorEst = entry.getKey();
        }
        System.out.println("O estado com a menor população é " + menorEst + " com o total de " + menorPop);

        Integer maiorPop = Collections.max(estadosPop1.values());
        Set<Map.Entry<String, Integer>> entries1 = estadosPop1.entrySet();
        String maiorEst = "";
        for (Map.Entry<String, Integer> entry : entries1) {
            if (entry.getValue().equals(maiorPop)) maiorEst = entry.getKey();
        }
        System.out.println("O estado com maior população é " + maiorEst + " com o total de " + maiorPop);

        Iterator<Integer> iterator = estadosPop1.values().iterator();
        Integer soma = 0;

        while(iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("A soma da população dos estados é: " + soma);

        System.out.println("A média da população dos estados é: " + (soma / estadosPop1.size()));

        System.out.println("Remova os estados com populaçao menor que 4.000.000: ");

        Iterator<Integer> iterator1 = estadosPop1.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000) iterator1.remove();
        }
        System.out.println(estadosPop1);

        System.out.println("---\nApague o dicionário de estados\n---");
        estadosPop1.clear();

        System.out.println("O dicionário está vazio? " + estadosPop1.isEmpty());


    }
}
