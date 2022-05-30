package javabeans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Diego Souza de Lima
 */
public class Pessoa {
    public String nome;
    public LocalDate nascimento;
    
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Pessoa (String nome, String nascimento) {
        this.nome = nome;
        this.nascimento = LocalDate.parse(nascimento, df);
    }
}
