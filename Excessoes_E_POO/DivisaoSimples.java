package ExceptionHandling.Excessoes_E_POO;

// Desenvolva um programa que solicite ao usuário o número de notas
// que ele deseja informar e, em seguida, permita que ele insira essas
// notas e calcule a média delas.

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoSimples
{
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numeroNotas = 0;
        int soma = 0;

        try
        {
            System.out.print("Quantas notas quer por no sistema? ");
            numeroNotas = sc.nextInt();

            if (numeroNotas <= 0) {
                throw new IllegalArgumentException("O número de notas deve ser maior que zero.");
            }

            for (int i = 0; i < numeroNotas; i++)
            {
                System.out.print("Informe a nota " + (i+1) + ": ");
                soma += sc.nextInt();
            }

            double media = (double) soma / numeroNotas;
            System.out.println("A media e: " + media);
        }
        catch (InputMismatchException e) {
            System.err.println("Nao digite letras, apenas numeros");
        }
        catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        finally {
            System.out.println("Programa de cálculo da media encerrado.");
        }

        sc.close();
    }
}
