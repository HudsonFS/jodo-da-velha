package jogodavelha.com.br.jogodavelha;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*; //Biblioteca//

public class JogoDaVelha extends JFrame {

    JButton[] bt = new JButton[9];//Vetor de botões.Quantidade//
    JLabel placar = new JLabel("Placar");
    JLabel px = new JLabel("X 0"); //Pontuação da O //
    JLabel po = new JLabel("O 0"); //Pontuação do X //
    JButton novo = new JButton("Novo Jogo");
    JButton zerar = new JButton("Zerar o Placar");
    int PX = 0;
    int PO = 0;
    boolean xo = false;
    boolean[] click = new boolean[9];

    public JogoDaVelha() { //Construtor// //SET é utilizado para modificar atributos//
        setVisible(true); //Torna janela visivel//
        setTitle("Jogo da velha");//Titulo da janela//
        setDefaultCloseOperation(3); //Opção de fechamento da janela//
        setLayout(null);//Deixa disponivel p/ configurar janela//
        setBounds(250, 100, 700, 500);//Localização e tamanho da janela em px//
        add(placar);
        add(px);
        add(po);
        add(novo);
        add(zerar);
        placar.setBounds(425,50,100,30);
        px.setBounds(400,75,100,30);
        po.setBounds(450,75,100,30);
        novo.setBounds(400,155,140,30);
        zerar.setBounds(400,195,140,30);
        novo.addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) { 
                limpar();
            }
        });
        zerar.addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) { 
                PO = 0;
                PX = 0;
                atualizar();
            }
        });
        int cont = 0;//Variavel Contadora de numeros inteiros//
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);//Posições.tamanhos.Botões//
                bt[cont].setFont(new Font("Arial", Font.BOLD, 40));//Fonte e tamanho //
                cont++;
            }
        }
        for (int i = 0; i < 9; i++) {
            click[i] = false;
        }
        bt[0].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[0] == false) {
                    click[0] = true;
                    mudar(bt[0]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[1].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[1] == false) {
                    click[1] = true;
                    mudar(bt[1]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[2].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[2] == false) {
                    click[2] = true;
                    mudar(bt[2]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[3].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[3] == false) {
                    click[3] = true;
                    mudar(bt[3]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[4].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[4] == false) {
                    click[4] = true;
                    mudar(bt[4]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[5].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[5] == false) {
                    click[5] = true;
                    mudar(bt[5]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[6].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[6] == false) {
                    click[6] = true;
                    mudar(bt[6]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[7].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[7] == false) {
                    click[7] = true;
                    mudar(bt[7]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
        bt[8].addActionListener(new java.awt.event.ActionListener() { //Ação dos botões//
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[8] == false) {
                    click[8] = true;
                    mudar(bt[8]);//Chamar a ação pelo metodo na posição//
                }
            }
        });
    }

    public void mudar(JButton btn) { //Metodo para ação do botão//
        if (xo) { //se 'xo' for verdadeiro//
            btn.setText("O");
            xo = false; //se torna falso//
        } else { //senão, 'xo' for falso// 
            btn.setText("X");
            xo = true; //se torna verdadeiro//
        }
        ganhou();
    }
    public void atualizar(){ //Soma da Atualização do placar//
        px.setText("X" + PX);
        po.setText("O" + PO);
    }
    public void ganhou() {
        int cont = 0; 
        for (int i = 0; i < 9; i++){
            if(click[i] == true){
                cont++;
            }
        }
        //Posições jogadas na qual X ganha//
        if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X")
                || (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
                || (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
                || (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
                || (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
                || (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
            JOptionPane.showMessageDialog(null, "X Ganhou!");
            PX++;
            atualizar();
            limpar();
        //Posições jogadas na qual O ganha//
        }else if ((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O")
                || (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
                || (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
                || (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
                || (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
                || (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
            JOptionPane.showMessageDialog(null, "O Ganhou!");
            PO++;
            atualizar();
            limpar();
        // Situação do empate onde os 9 botoes foram utilizados//    
        }else if (cont == 9){
            JOptionPane.showMessageDialog(null, "Empate!");
            limpar();
        }
    }
    public void limpar(){ //Metodo para llimpar as jogadas// 
        for (int i = 0; i < 9; i++){
            bt[i].setText("");
            click[i] = false;
            xo = false;
        }
    }
    public static void main(String[] args) {
        new JogoDaVelha();
    }
}

