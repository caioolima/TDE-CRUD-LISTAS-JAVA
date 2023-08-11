import java.util.ArrayList;
import java.util.List;

// Interface para realizar as operações
interface Operacao {
    double calcular(List<Double> numeros);
}

// Operações aritméticas
class Soma implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = 0;
        for (double num : numeros) {
            resultado += num;
        }
        return resultado;
    }
}

class Subtracao implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }
}

class Multiplicacao implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = 1;
        for (double num : numeros) {
            resultado *= num;
        }
        return resultado;
    }
}

class Divisao implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado /= numeros.get(i);
        }
        return resultado;
    }
}

// Calculadora
class Calculadora {
    public double executarOperacao(String operador, List<Double> numeros) {
        Operacao operacao = switch (operador) {
            case "+" -> new Soma();
            case "-" -> new Subtracao();
            case "*" -> new Multiplicacao();
            case "/" -> new Divisao();
            default -> throw new IllegalArgumentException("Operação não suportada.");
        };

        return operacao.calcular(numeros);
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        String operador1 = "+";
        String operador2 = "-";
        String operador3 = "*";
        String operador4 = "/";
        List<Double> numeros = new ArrayList<>();
        numeros.add(5.0);
        numeros.add(4.0);
        numeros.add(3.0);
        numeros.add(2.0);
        numeros.add(1.0);

        double resultado1 = calculadora.executarOperacao(operador1, numeros);
        double resultado2 = calculadora.executarOperacao(operador2, numeros);
        double resultado3 = calculadora.executarOperacao(operador3, numeros);
        double resultado4 = calculadora.executarOperacao(operador4, numeros);

        System.out.println("Resultado soma:\n" + resultado1);
        System.out.println("\nResultado subtração:\n" + resultado2);
        System.out.println("\nResultado multiplicação:\n" + resultado3);
        System.out.println("\nResultado divisão:\n" + resultado4);
    }
}
