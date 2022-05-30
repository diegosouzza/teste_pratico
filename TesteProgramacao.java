package com.mycompany.testeprogramacao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javabeans.Funcionario;
/**
 *
 * @author Diego Souza de Lima
 */
public class TesteProgramacao {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>(); 
        funcionarios.add(new Funcionario("Maria",   "18/10/2000", BigDecimal.valueOf(2009.44),  "Operador" ));
        funcionarios.add(new Funcionario("João",    "12/05/1990", BigDecimal.valueOf(2284.38),  "Operador" ));
        funcionarios.add(new Funcionario("Caio",    "02/05/1961", BigDecimal.valueOf(9836.14),  "Coordenador" ));
        funcionarios.add(new Funcionario("Miguel",  "14/10/1988", BigDecimal.valueOf(19119.88), "Diretor" ));
        funcionarios.add(new Funcionario("Alice",   "05/01/1995", BigDecimal.valueOf(2234.68),  "Recepcionista" ));
        funcionarios.add(new Funcionario("Heitor",  "18/11/1999", BigDecimal.valueOf(1582.72),  "Operador" ));
        funcionarios.add(new Funcionario("Arthur",  "31/03/1993", BigDecimal.valueOf(4071.84),  "Contador" ));
        funcionarios.add(new Funcionario("Laura",   "08/07/1994", BigDecimal.valueOf(3017.45),  "Gerente" ));
        funcionarios.add(new Funcionario("Heloisa", "24/05/2003", BigDecimal.valueOf(1606.85),  "Eletricista" ));
        funcionarios.add(new Funcionario("Helena",  "02/09/1996", BigDecimal.valueOf(2799.93),  "Gerente" ));
    
        //Removendo João
        System.out.println("-----------------------------------------------------");
        System.out.println("3.3 - Lista de Funcionários.");
        System.out.println("");
        
        funcionarios.remove(1);
        for(int i = 0; i < funcionarios.size(); i++){
            funcionarios.get(i).MostrarFuncionario();
        }
        
        // Funcionárions receberam 10% a mais do salário
        System.out.println("-----------------------------------------------------");
        System.out.println("3.4 - Lista atualizada dos funcionários com reajuste.");
        System.out.println("");
        
        for(int i = 0; i < funcionarios.size(); i++){
            funcionarios.get(i).salario = funcionarios.get(i).salario.multiply(BigDecimal.valueOf(1.1));        
            funcionarios.get(i).MostrarFuncionario();
        }
        
        // Agrupar funcionários por função
        System.out.println("-----------------------------------------------------");
        System.out.println("3.6 - Funcionários agrupados por Função.");
        System.out.println("");
        
        Map<String, List<Funcionario>> funcionarios_funcao = new HashMap<String, List<Funcionario>>(); 
        List<String> funcoes = new ArrayList<String>();
        for (Funcionario f: funcionarios) {      
            if (funcoes.indexOf(f.funcao) <= -1){
                funcoes.add(f.funcao);
            }            
            int idx = funcoes.indexOf(f.funcao);
            
            List<Funcionario> funcionarios_encontrados = funcionarios_funcao.get(funcoes.get(idx));
            
            if(funcionarios_encontrados == null){
                funcionarios_encontrados = new ArrayList<>();
                funcionarios_encontrados.add(f);
                funcionarios_funcao.put(funcoes.get(idx), funcionarios_encontrados);
            } 
            else
                funcionarios_encontrados.add(f);
        }
        for(int i = 0; i < funcoes.size(); i++){
            for (int j = 0; j < funcionarios_funcao.get(funcoes.get(i)).size(); j++){
                funcionarios_funcao.get(funcoes.get(i)).get(j).MostrarFuncionario();
            }
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("3.8 - Funcionários nascidos nos meses 10 e 12.");
        System.out.println("");
        
        for (int i = 0; i < funcionarios.size(); i++) {
            switch (funcionarios.get(i).nascimento.getMonth()) {
                case OCTOBER: 
                    funcionarios.get(i).MostrarFuncionario();
                    break;
                case DECEMBER: 
                    funcionarios.get(i).MostrarFuncionario();
                    break;
            }
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("3.9 - Buscar funcionário mais velho.");
        System.out.println("");
        
        int idade = 0;
        String nome = "";
        for (Funcionario f: funcionarios) {            
          if (Period.between(f.nascimento,LocalDate.now()).getYears() > idade){
              idade = Period.between(f.nascimento,LocalDate.now()).getYears();
              nome = f.nome;
          }
        }
        
        System.out.println("Funcionário mais Velho se chama "+nome+" e tem "+idade+" anos.");
        
        System.out.println("-----------------------------------------------------");
        System.out.println("3.10 - Lista de funcionários em ordem alfabética.");
        System.out.println("");
        
        funcionarios.sort((o1, o2) -> {
            return o1.nome.compareTo(o2.nome); 
        });
        
        for (int i = 0; i < funcionarios.size(); i++) {
            funcionarios.get(i).MostrarFuncionario();            
        }
        
        System.out.println("-----------------------------------------------------");
        System.out.println("3.11 - Soma dos salários.");
        System.out.println("");
        
        BigDecimal salario_total = new BigDecimal(0);
        
        for (Funcionario f: funcionarios){
            salario_total = salario_total.add(f.salario);
        }
        
        DecimalFormat num_format = new DecimalFormat("###,###.00");
        System.out.println("A soma do salário dos funcionários é de: R$ "+String.format("%9.9s",num_format.format(salario_total)));
        
        System.out.println("-----------------------------------------------------");
        System.out.println("3.12 - Cada funcionário recebe quantos salários minímos?");
        System.out.println("");
        
        BigDecimal salario_minimo = new BigDecimal(1212.00);
        for (Funcionario f: funcionarios){
            System.out.println(String.format("%-7.8s", f.nome)+" recebe "+String.format("%5.5s",num_format.format(f.salario.divide(salario_minimo,2,1)))+" salários minímos.");
        }
    }    
}
