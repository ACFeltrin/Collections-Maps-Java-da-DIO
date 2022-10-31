package com.dio.collections.maps.exerciciosMaps;

import java.util.*;

public class exerciciosProp2 {
    public static void main(String[] args) {

        System.out.print("Quantas vezes deseja jogar os dados? ");

        Scanner input = new Scanner(System.in);
        int dados = input.nextInt();

       List<Integer> resultados = new ArrayList<>();
       Random gerador = new Random();
        for (int i = 0; i < dados; i++){
            int num = gerador.nextInt(6) + 1;
            resultados.add(num);
        }

        Map<Integer, Integer> jogadas = new HashMap<>();
        for (Integer valor : resultados) {
            if (jogadas.containsKey(valor))
                jogadas.put(valor, (jogadas.get(valor) + 1));
            else jogadas.put(valor, 1);
        }

        System.out.println("\nResultados ao lançar os dados " + dados  + " vezes");


        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : jogadas.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }
}

