package com.dio.collections.maps.ordenarmap;

import java.util.*;

public class ordenacaoMap {
    public static void main(String[] args) {
        System.out.println("--\t Ordem Aleatória \t--");
        Map<String, livro> meusLivros = new HashMap<>() {{
            put("Hawking, Stephen", new livro("Uma Breve história do tempo", 256));
            put("Duhigg, Charles", new livro("A Força do Hábito", 408));
            put("Harari, Yuval Noah", new livro("21 lições para o Século 21", 432));
        }};

        for(Map.Entry<String, livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem Inserção \t--");
        Map<String, livro> meusLivros1 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new livro("Uma Breve história do tempo", 256));
            put("Duhigg, Charles", new livro("A Força do Hábito", 408));
            put("Harari, Yuval Noah", new livro("21 lições para o Século 21", 432));
        }};
        for(Map.Entry<String, livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem Alfabética Autores \t--");
        Map<String, livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String, livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\t Ordem Alfabética Livros \t--");
        Set<Map.Entry<String, livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String, livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());




    }


}



class livro {
    private String nome;
    private Integer paginas;

    public livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        livro livro = (livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, livro>> {

    @Override
    public int compare(Map.Entry<String, livro> l1, Map.Entry<String, livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}