import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NumerosCRUD {
    private List<Double> numeros = new ArrayList<>();

    public void criarNumero(double numero) {
        numeros.add(numero);
    }

    public List<Double> lerNumeros() {
        return numeros;
    }

    public void atualizarNumero(int indice, double novoNumero) {
        if (indice >= 0 && indice < numeros.size()) {
            numeros.set(indice, novoNumero);
        } else {
            System.out.println("\nÍndice inválido.");
        }
    }

    public void excluirNumero(int indice) {
        if (indice >= 0 && indice < numeros.size()) {
            numeros.remove(indice);
        } else {
            System.out.println("\nÍndice inválido.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumerosCRUD numerosCRUD = new NumerosCRUD();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Criar número");
            System.out.println("2. Ler números");
            System.out.println("3. Atualizar número");
            System.out.println("4. Excluir número");
            System.out.println("5. Sair");

            try {
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.print("\nDigite o número: ");
                        double novoNumero = scanner.nextDouble();
                        numerosCRUD.criarNumero(novoNumero);
                        break;
                    case 2:
                        List<Double> numerosLidos = numerosCRUD.lerNumeros();
                        System.out.println("\nNúmeros na lista: " + numerosLidos);
                        break;
                    case 3:
                        System.out.print("\nDigite o índice do número a ser atualizado: ");
                        int indiceAtualizacao = scanner.nextInt();
                        System.out.print("\nDigite o novo número: ");
                        double novoNumeroAtualizado = scanner.nextDouble();
                        numerosCRUD.atualizarNumero(indiceAtualizacao, novoNumeroAtualizado);
                        break;
                    case 4:
                        System.out.print("\nDigite o índice do número a ser excluído: ");
                        int indiceExclusao = scanner.nextInt();
                        numerosCRUD.excluirNumero(indiceExclusao);
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("\nOpção inválida.");
                        break;
                }

                // Atraso de 1 segundo (1000 milissegundos)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nEncerrando o programa.");
    }
}
