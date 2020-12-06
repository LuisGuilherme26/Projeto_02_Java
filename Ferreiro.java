
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Ferreiro {
    int proficiencia;
    int carisma;
    int dinheiro;
    int materiais;

    public Ferreiro(int proficiencia, int carisma, int dinheiro, int materiais) {
        this.proficiencia = proficiencia;
        this.carisma = carisma;
        this.dinheiro = dinheiro;
        this.materiais = materiais;
    }
    
    void Produzir(String arma){
        switch(arma){
            case "espada":
                if(proficiencia >= 2 && materiais >= 2){
                    proficiencia += 2;
                    materiais -= 2;
                    JOptionPane.showMessageDialog(null, "Espada construida");
                    Vender(arma);
                }else if(proficiencia < 2){
                    JOptionPane.showMessageDialog(null, "Você não sabe fazer uma espada");
                }else if(materiais < 2){
                    JOptionPane.showMessageDialog(null, "Compre mais mateirais");
                }
            break;
            case "escudo":
                if(proficiencia >= 4 && materiais >= 3){
                    proficiencia += 3;
                    materiais -= 3;
                    JOptionPane.showMessageDialog(null, "Escudo construido");
                    Vender(arma);
                }else if(proficiencia < 4){
                    JOptionPane.showMessageDialog(null, "Você não sabe fazer um escudo");
                }else if(materiais < 3){
                    JOptionPane.showMessageDialog(null, "Compre mais mateirais");
                }
            break;
            case "foice":
                if(proficiencia >= 7 && materiais >= 5){
                    proficiencia += 5;
                    materiais -= 5;
                    JOptionPane.showMessageDialog(null, "Foice construida");
                    Vender(arma);
                }else if(proficiencia < 7){
                    JOptionPane.showMessageDialog(null, "Você não sabe fazer uma foice");
                }else if(materiais < 5){
                    JOptionPane.showMessageDialog(null, "Compre mais mateirais");
                }
            break;
        }
    }
    
    void Comprar(int quant){
        JOptionPane.showMessageDialog(null, "Quanto você quer gastar?");
        Scanner tcl = new Scanner(System.in);
        quant = tcl.nextInt();
        materiais = (quant / 3) * 4;
        dinheiro -= quant;
        JOptionPane.showMessageDialog(null, "Você comprou +"+materiais+" materiais");
    }
    
    void Vender(String arma){
        int multi = 1;
        Random rand = new Random();
        int barganhar = rand.nextInt(25);
        if(barganhar <= carisma){
            multi = 2;
            JOptionPane.showMessageDialog(null, "Você conseguiu barganhar sua venda");
        }else{
            carisma += 3;
        }
        switch(arma){
            case "espada":
                dinheiro += 2 * multi;
                JOptionPane.showMessageDialog(null, "Dinheiro: +"+2 * multi);
            break;
            case "escudo":
                dinheiro += 3 * multi;
                JOptionPane.showMessageDialog(null, "Dinheiro: +"+3 * multi);
            break;
            case "foice":
                dinheiro += 6 * multi;
                JOptionPane.showMessageDialog(null, "Dinheiro: +"+6 * multi);
            break;
           } 
        
    }
    
    public String toString(){
        return "Jose: proficiencia: "+ proficiencia +", carisma: "+ carisma +", dinheiro: "+ dinheiro +
                ", materiais: "+ materiais;
    }    
    
    public static void main(String[] args) {
        Ferreiro Jose = new Ferreiro(2, 5, 10, 5);
        String arma = "";
        int quant_dinheiro = 0;
        
        //Primeira venda
        JOptionPane.showMessageDialog(null, "Cliente pediu uma espada");
        arma = "espada";
        Jose.Produzir(arma);
        JOptionPane.showMessageDialog(null, Jose);
        
        //Segunda venda
        JOptionPane.showMessageDialog(null, "Cliente pediu um escudo");
        arma = "escudo";
        Jose.Produzir(arma);
        JOptionPane.showMessageDialog(null, Jose);
                
        //Terceira venda v1
        JOptionPane.showMessageDialog(null, "Cliente pediu uma espada");
        arma = "espada";
        Jose.Produzir(arma);
        JOptionPane.showMessageDialog(null, Jose);
        
        //Primeira compra
        Jose.Comprar(quant_dinheiro);
        JOptionPane.showMessageDialog(null, Jose);
        
        //Terceira venda v2
        JOptionPane.showMessageDialog(null, "Cliente pediu uma foice");
        arma = "foice";
        Jose.Produzir(arma);
        JOptionPane.showMessageDialog(null, Jose);
    }
}
