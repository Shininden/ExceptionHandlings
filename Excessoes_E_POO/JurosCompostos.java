package ExceptionHandling.Excessoes_E_POO;

import java.util.InputMismatchException;
import java.util.Scanner;

//Implemente um programa que calcula os juros compostos de um
// investimento, onde o usuário deve informar o valor principal,
// a taxa de juros e o período em meses
public class JurosCompostos
{
    public static void main(String[] args)
    {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        double principal = 0;
        double taxa = 0;
        int meses = 0;

        try
        {
            System.out.print("Informe o valor principal do investimento: ");
            principal = sc.nextDouble();

            if(principal <= 0){
                throw new IllegalArgumentException();
            }

            System.out.print("Informe o da taxa em porcentagem: ");
            taxa = sc.nextDouble();

            System.out.print("Informe quantos meses vai durar a aplicacao ");
            meses = sc.nextInt();

            double total = principal * Math.pow(1 + taxa / 100, meses);
            System.out.printf("O valor total após %d meses será: %.2f\n", meses, total);
        }
        catch (IllegalArgumentException e) {
            System.err.println("O valor deve ser de pelo menos 1 real");
        }
        catch (InputMismatchException e){
            System.err.println("Nada de letras");
        }
        finally {
            System.out.println("Programa de cálculo de juros compostos encerrado.");
        }
    }
}
