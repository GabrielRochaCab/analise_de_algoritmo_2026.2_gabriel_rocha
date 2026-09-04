package unidade02;
import java.util.Arrays;
import java.util.Comparator;

public class MochilaFracionaria {
    public static void main(String[] args) {
        // Capacidade da mochila
        int capacidade = 50; 
        
        // Itens: peso, valor
        int[] pesos = {10, 20, 30}; 
        int[] valores = {60, 100, 120}; 
        
        // Calcular valor por peso
        double[] valorPorPeso = new double[pesos.length];
        for (int i = 0; i < pesos.length; i++) {
            valorPorPeso[i] = (double) valores[i] / pesos[i];
        }

        //metodos gulosos
        Item[] itens = new Item[pesos.length];
        for (int i = 0; i < pesos.length; i++){
             itens[i] = new Item();
             itens[i].peso = pesos[i];
             itens[i].valor = valores[i];
             itens[i].valorPorPeso = valorPorPeso[i];
        }

        //ordenacão
        Arrays.sort(itens, new Comparator<Item>() {
        public int compare(Item a, Item b) {
            return Double.compare(b.valorPorPeso, a.valorPorPeso);
            }
        });
        
        double valorMaximo = calcularValorMochila(itens, capacidade);
        System.out.println("Valor máximo obtido: " + valorMaximo);
    }

    static class Item {
    int peso;
    int valor;
    double valorPorPeso;
    }

    static double calcularValorMochila(Item[] itens, int capacidade) {
        double capacidadeRestante = capacidade;
        double valorMaximo = 0;

        for (int i = 0; i < itens.length; i++) {
            if (itens[i].peso <= capacidadeRestante) {
            //cabe inteiro
            capacidadeRestante -= itens[i].peso;
            valorMaximo += itens[i].valor;
        } 
        else {
            // cabe só uma fração
            double fracao = capacidadeRestante / itens[i].peso;
            valorMaximo += itens[i].valor * fracao;
            capacidadeRestante = 0;
            }
        }
    return valorMaximo;
}
}