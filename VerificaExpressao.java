import java.util.Scanner;
import java.util.Stack;

public class VerificaExpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a expressão: ");
        String expressao = scanner.nextLine();

        if (estaCorreta(expressao)) {
            System.out.println("Expressão CORRETA!");
        } else {
            System.out.println("Expressão INCORRETA!");
        }

        scanner.close();
    }

    public static boolean estaCorreta(String exp) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) return false; 
                char topo = pilha.pop();

                if (!corresponde(topo, c)) {
                    return false; 
                }
            }
        }

        return pilha.isEmpty();
    }

    private static boolean corresponde(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
               (abre == '[' && fecha == ']') ||
               (abre == '{' && fecha == '}');
    }
}
