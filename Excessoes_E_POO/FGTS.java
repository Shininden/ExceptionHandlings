package ExceptionHandling.Excessoes_E_POO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FGTS
{
    public static void main(String[] args) throws InterruptedException
    {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean isNameValid = false;
        boolean isSalaryValid = false;

        String nome = "";

        do
        {
            try
            {
                Thread.sleep(100);
                System.out.print("Informe seu nome: ");
                nome = sc.nextLine();

                if(nome.contains("0") || nome.contains("1") || nome.contains("2") ||
                        nome.contains("3") || nome.contains("4") || nome.contains("5") ||
                        nome.contains("6") || nome.contains("7") || nome.contains("8") ||
                        nome.contains("9"))
                {
                   throw new InputMismatchException();
                }

                else if(nome.length() < 5 || nome.length() > 50){
                    throw new IllegalArgumentException();
                }
                else
                {
                    if(nome.endsWith(" ")){
                        throw new IllegalArgumentException();
                    }
                }

                isNameValid = true;

            }
            catch (InputMismatchException e) {
                System.err.println("Erro: o nome nao pode conter numeros!\n");
            }

            catch (IllegalArgumentException e) {
                System.err.println("Erro: numero de caracteres invalido!\n");
            }

            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (!isNameValid);


        System.out.println();


        double salario = 0;

        while (!isSalaryValid)
        {
            try
            {
                Thread.sleep(100);
                System.out.print("Informe seu salario: ");
                salario = sc.nextDouble();

                if(salario < 1412){
                    throw new IllegalArgumentException();
                }
                isSalaryValid = true;
            }
            catch (InputMismatchException e)
            {
                System.err.println("Erro: informe um numero valido (ex: 567,44)\n");
                sc.nextLine();
            }

            catch (IllegalArgumentException e) {
                System.err.println("Erro: salario abaixo do minino de 1412\n");
            }

            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\nRecibo de pagamento: ");
        System.out.println("Nome: " + nome);
        System.out.println("Salario: R$" + salario);
        System.out.printf("FGTS: R$ %.2f", salario * 0.08);

        sc.close();
    }
}
