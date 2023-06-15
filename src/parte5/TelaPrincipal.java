package parte5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JButton cadastrarButton;
    private JButton listarButton;
    private JPanel panel;
    
    public TelaPrincipal(){
        setTitle("Tela Principal");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cadastrarButton = new JButton("Cadastrar Aluno");
        listarButton = new JButton("Listar Alunos");

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Cadastrar Aluno");
                new CadastrarAlunojFrame();
            }
        });

        listarButton.addActionListener(e -> {
            System.out.println("Listar Alunos");
            new ListarAlunosjFrame();
        });

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(cadastrarButton);
        panel.add(listarButton);

        getContentPane().add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new TelaPrincipal();
            }
        });
    }
}
