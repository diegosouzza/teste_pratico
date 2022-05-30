package javabeans;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author Diego Souza de Lima
 */
public class Funcionario extends Pessoa{
   public BigDecimal salario;    
   public String funcao;   
   
   DecimalFormat num_format = new DecimalFormat("###,###.00");
 
   
   public Funcionario (String nome, String nascimento, BigDecimal salario, String funcao){
       super(nome, nascimento);
       
       this.funcao = funcao;
       this.salario = salario;
   }
   
   public void MostrarFuncionario(){        
        
       System.out.println(String.format("%-8.8s", nome) + "| " + nascimento.format(df)+" |"+String.format("%9.9s",num_format.format(salario))+"| "+funcao);        
    }
}
