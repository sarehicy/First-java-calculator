// Importando biblioteca com componentes GUI
import javax.swing.*;
import java.awt.*;
// Precisei importar individualmente essas funções, pois não estava compilando
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Calculadora simples usando GUI;
 * A classe SimpleCalculatorGUI é uma subclasse da classe JFrame;
 * 
 * A aplicação possui 2 campos para que o usuário insira valores;
 * A aplicação apresenta uma mensagem de erro caso seja inserido um valor não numérico, ou caso não seja inserido nada;
 * Assim que o usuário inserir os dois valores ele poderá realizar operações simples: +, -, *, /;
 * O resultado da operação será mostrado em um terceiro campo.
 */

//Subclasse da classe JFrame
public class SimpleCalculatorGUI extends JFrame{


    // Classe de botões personalizados que é subclasse da classe JButton
    // e implementa a interface ActionListener 
    public class Button extends JButton implements ActionListener{

        // Constructor da classe, recebe texto que o botão deve carregar
        public Button(String text){
            super(text);    //Chama constructor da classe JButton 

            // Caracteristicas do botão
            this.setBackground(new Color(129, 82, 40));
            this.setForeground(Color.WHITE);

            // definindo ActionListener
            this.addActionListener(this);
        }

        // Implementação da função da interface ActionListener
        // Ela determina o que deve ser feito quando o botão for clicado
        @Override
        public void actionPerformed(ActionEvent e){

            // tenta ler input A
            try{
                a = Double.parseDouble(inputA.getText());
            }   
            catch(NumberFormatException k){ // Caso a string não contenha um valor numérico
                erroMessage.setText("Insira um valor válido");
                return;
            } 

            // tenta ler input B
            try{
                b = Double.parseDouble(inputB.getText());
            }   
            catch(NumberFormatException k){ // Caso a string não contenha um valor numérico
                erroMessage.setText("Insira um valor válido");
                return;
            }

        
            String operation = this.getText();  // Guarda a operação referente ao botão clicado

            // Determinando que operação deve ser realizada e atribuindo o resultado adequado
            if (operation == "+"){
                result = String.valueOf(a+b);
            }
            if (operation == "-"){
                result = String.valueOf(a-b);
            }
            if (operation == "*"){
                result = String.valueOf(a*b);
            }
            if (operation == "/"){
                result = String.valueOf(a/b);
            }

            resultado.setText(result);  // Coloca texto no JTextFIeld resultado
        }

    }

    // VARIÁVEIS DE INPUT E OUTPUT
    private double a;       // irá guardar o primeiro número digitado pelo usuário
    private double b;       // irá guardar o segundo número digitado pelo usuário
    private String result;  // irá guardar o resultado da operação


    // COMPONENTES DA JANELA | |Criando variáveis que representam os componentes
    // I. Botões | Para as operações
    private JButton plus = new Button("+");
    private JButton minus = new Button("-");
    private JButton mult = new Button("*");
    private JButton div = new Button("/");

    // II. Campos de input | Para os números a e b
    private JTextField inputA = new JTextField(6);
    private JTextField inputB = new JTextField(6);

    // III. Campo de output | Para o resultado da operação e mensagem de erro
    private JTextArea resultado = new JTextArea(1, 10);
    private JTextArea erroMessage = new JTextArea(1, 10);


    // IV. Paineis
    JPanel numbersInput = new JPanel(); // Painel com números e resultado
    JPanel buttons = new JPanel(); // Painel que deve conter botões
    JPanel erro = new JPanel();

    // constructor da interface da calculadora
    public SimpleCalculatorGUI(){

        // Definindo características da janela
        setSize(300, 150);          // Tamanho | (largura, altura)
        setLocation(500, 150);      // Posição na tela | (x, y)
        setTitle("Calculadora");    // Titulo da janela
        getContentPane().setBackground(new Color(255, 255, 145)); // Cor da janela
        setVisible(true);
  
        // Adicionando botões ao painel
        buttons.add(plus);
        buttons.add(minus);
        buttons.add(mult);
        buttons.add(div);

        // Bloqueando modificações dos campos de output por parte do usuário
        resultado.setEditable(false);
        erroMessage.setEditable(false); 

        // Adicionando campos de input e output aos paineis
        numbersInput.add(inputA);
        numbersInput.add(inputB);
        numbersInput.add(resultado);
        erro.add(erroMessage);

        //.setOpaque(false) faz com que o fundo dos componentes fique transparente
        numbersInput.setOpaque(false);
        buttons.setOpaque(false);
        erro.setOpaque(false);

        // Adicionando painel à janela
        this.getContentPane().add("North", numbersInput);
        this.getContentPane().add("Center", buttons);
        this.getContentPane().add("South", erro);

    }

    public static void main(String args[]){
        new SimpleCalculatorGUI();
    }
}