package ExceptionHandling.AtividadeTratamentoExcessoes;

import java.util.Scanner;

class IllegalAgeException extends Exception 
{
    public IllegalAgeException(String msg) {
        super(msg);
    }
}

class IllegalCarPlateException extends Exception 
{
    public IllegalCarPlateException(String msg) {
        super(msg);
    }
}

public class QuestaoC 
{
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        String nome = "", email = "", dataNascimento = "",  telefone = "";
        String placa = "",  modelo = "",  marca = "";

        String erros = "";

        try 
        {
            System.out.print("Começo do cadastro \nDigite seu nome: ");
            nome = sc.nextLine();

            System.out.print("Digite seu email: ");
            email = sc.nextLine();

            System.out.print("Digite sua data de nascimento: ");
            dataNascimento = sc.nextLine();

            System.out.print("Digite seu telefone para contato: ");
            telefone = sc.nextLine();

            System.out.print("Digite a placa do seu carro: ");
            placa = sc.nextLine();

            System.out.print("Digite o modelo: ");
            modelo = sc.nextLine();

            System.out.print("Digite a marca: ");
            marca = sc.nextLine();

            if(!email.contains("@gmail.com")){
                erros += "Email inválido\n";
            }

            int anoNascimento = Integer.parseInt(dataNascimento.substring(6));
            if(2024 - anoNascimento < 18){
                erros += "Condutor menor de idade.\n";
            }

            if(placa.length() != 7){
                erros += "Placa inválida\n";
            }

            if (!erros.isEmpty()) {
                throw new Exception(erros);
            }
            
        } 
        catch (Exception e) {
            System.err.println("Erros:\n" + e.getMessage());
        }
        finally{
            System.out.println("Fim do cadastro");
        }

        sc.close();
    }
}