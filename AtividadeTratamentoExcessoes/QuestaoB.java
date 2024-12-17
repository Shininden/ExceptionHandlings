package ExceptionHandling.AtividadeTratamentoExcessoes;

import java.util.Scanner;

class InvalidCPF_Exception extends Exception
{
    public InvalidCPF_Exception(String msg){
        super(msg);
    }
}

public class QuestaoB 
{
    static String estado = "";
    static boolean isDataValid = false;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String cpf = "";
        
        String[] siglas1 = new String[5];
        siglas1[0] = "DF"; siglas1[1] = "GO"; siglas1[2] = "MS"; siglas1[3] = "MT"; siglas1[4] = "TO";

        String[] siglas2 = new String[6];
        siglas2[0] = "AC"; siglas2[1] = "AM"; siglas2[2] = "AP"; siglas2[3] = "PA"; siglas2[4] = "RO"; siglas2[5] = "RR";

        String[] siglas3 = new String[3];
        siglas3[0] = "CE"; siglas3[1] = "MA"; siglas3[2] = "PI";

        String[] siglas4 = new String[4];
        siglas4[0] = "AL"; siglas4[1] = "PB"; siglas4[2] = "PE"; siglas4[3] = "RN";

        String[] siglas5 = new String[2];
        siglas5[0] = "BA"; siglas5[1] = "SE";

        String[] siglas7 = new String[2];
        siglas7[0] = "ES"; siglas7[1] = "RJ";

        String[] siglas9 = new String[2];
        siglas9[0] = "PR"; siglas9[1] = "SC";

        try 
        {
            System.out.print("Digite seu CPF (sem pontos ou traço): ");
            cpf = sc.nextLine();

            while (cpf.contains(".") || cpf.contains("-")) 
            {
                System.out.print("CPF digitado incorretamente, digite de novo: ");
                cpf = sc.nextLine();
            }

            System.out.print("Digite as siglas do seu estado: ");
            estado = sc.nextLine();

            switch (cpf.charAt(8)) 
            {
                case '1':
                    validarCPF(siglas1);
                    break;
                
                case '2':
                    validarCPF(siglas2);
                    break;

                case '3':
                    validarCPF(siglas3);
                    break;

                case '4':
                    validarCPF(siglas4);
                    break;

                case '5':
                    validarCPF(siglas5);
                    break;

                case '6':
                    validarCPF("MG");
                    break;

                case '7':
                    validarCPF(siglas7);
                    break;

                case '8':
                    validarCPF("SP");
                    break;

                case '9':
                    validarCPF(siglas9);
                    break;

                case '0':
                    validarCPF("RS");
                    break;
            }
        } 
        catch (InvalidCPF_Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        sc.close();
    }

    public static void validarCPF(String[] siglas) throws InvalidCPF_Exception
    {
        for (int i = 0; i < siglas.length; i++) 
        {
            if(estado.equals(siglas[i]))
            {
                isDataValid = true;
                System.out.println("Informações de acordo");
            }                
        }

        if(!isDataValid){
            throw new InvalidCPF_Exception("CPF e estado não batem");
        }
    }

    public static void validarCPF(String sigla) throws InvalidCPF_Exception
    {
        if(estado.equalsIgnoreCase(sigla))
        {
            isDataValid = true;
            System.out.println("Informações de acordo");
        }

        if(!isDataValid){
            throw new InvalidCPF_Exception("CPF e estado não batem");
        }
    }
}