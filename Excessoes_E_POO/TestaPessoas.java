package ExceptionHandling.Excessoes_E_POO;

public class TestaPessoas
{
    public static void main(String[] args)
    {
        Pessoas p1 = new Pessoas(12, "A", "Terra do nunca", "88844455");
        Pessoas p2 = new Pessoas(22, "B", "Narnia", "98852016579");

        validarCPF(p1);
        validarCPF(p2);
    }

    static void validarCPF(Pessoas p)
    {
        char[] charCPF = p.getCpf().toCharArray();
        boolean isCPFValido = false;

        if(charCPF.length != 11 ) {
            System.out.println("CPF inválido, precisa ter 11 digitos");
        }
        else
        {
            isCPFValido = true;
            for (int i = 0; i < charCPF.length && isCPFValido; i++)
            {
                if(charCPF[i] != '0' && charCPF[i] != '1' && charCPF[i] != '2' && charCPF[i] != '3' && charCPF[i] != '4' && charCPF[i] != '5' && charCPF[i] != '6'
                        && charCPF[i] != '7' && charCPF[i] != '8' && charCPF[i] != '9')
                {
                    System.out.println("Erro, CPF pode apenas conter numeros");
                    isCPFValido = false;
                }
            }

        }

        if (isCPFValido){
            System.out.println("CPF e valido");
        }
    }
}
