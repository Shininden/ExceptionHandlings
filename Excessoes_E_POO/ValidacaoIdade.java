package ExceptionHandling.Excessoes_E_POO;
//Crie um programa que verifique se a idade de uma
// pessoa está dentro de um limite válido

import java.util.Scanner;

class InvalidAgeException extends Exception
{
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ValidacaoIdade
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a sua idade? ");
        int idade = sc.nextInt();

        try
        {
            validarIdade(idade);
            System.out.println("Idade valida");
        }
        catch (InvalidAgeException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        finally {
            System.out.println("Programa encerrado");
        }
        sc.close();
    }

    public static void validarIdade(int idade) throws InvalidAgeException {
        if (idade < 18 || idade > 65) {
            throw new InvalidAgeException("Idade fora do limite permitido (18 a 65 anos).");
        }
    }
}
