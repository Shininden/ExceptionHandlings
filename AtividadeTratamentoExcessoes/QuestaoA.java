package ExceptionHandling.AtividadeTratamentoExcessoes;

import java.util.Scanner;

public class QuestaoA 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String email = " ";
        boolean isEmailValid = false;

        do 
        {
            try 
            {
                System.out.print("Digite seu email constitucional (@fatec.sp.gov.br): ");
                email = sc.nextLine();

                if(!email.contains("@fatec.sp.gov.br")){
                    throw new IllegalArgumentException();
                }

                isEmailValid = true;
                System.out.println("email inserido corretamente");
            } 
            catch (IllegalArgumentException e) {
                System.err.println("\nEsse email esta incorreto, precisa conter '@fatec.sp.gov.br'\n");
            }
        } 
        while (!isEmailValid);

        sc.close();
    }
}