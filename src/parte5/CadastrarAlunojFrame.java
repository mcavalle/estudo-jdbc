package parte5;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastrarAlunojFrame extends JFrame {
    private JLabel nomeLabel = new JLabel("Nome:");
    private JTextField nomeTextField = new JTextField(20);
    private JLabel prontuarioLabel = new JLabel("Prontuário:");
    private JTextField prontuarioTextField = new JTextField(20);
    private JLabel emailLabel = new JLabel("E-mail:");
    private JTextField emailTextField = new JTextField(20);
    private JCheckBox ativoCheckBox = new JCheckBox("Ativo", true);
    private JButton cadastrarButton = new JButton("Cadastrar");
    private JPanel panel = new JPanel();

    public CadastrarAlunojFrame(){
        setTitle("Cadastrar Aluno");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.add(nomeLabel);
        panel.add(nomeTextField);
        panel.add(prontuarioLabel);
        panel.add(prontuarioTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(ativoCheckBox);
        panel.add(new JLabel(""));
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> {
            String nome = nomeTextField.getText();
            String prontuario = prontuarioTextField.getText();
            String email = emailTextField.getText();
            Boolean ativo = ativoCheckBox.isSelected();

            ArrayList<String> errors = new ArrayList<>();

            //Validar dados
            if(nome.isBlank()){
                errors.add("Nome não pode ser vazio");
            }

            if(nome.trim().length() < 3 || nome.trim().length() > 100){
                errors.add("Nome deve ter entre 3 e 100 caracteres");
            }

            if(prontuario.isBlank()){
                errors.add("Prontuário não pode ser vazio");
            }

            if(!errors.isEmpty()){
                JOptionPane.showMessageDialog(CadastrarAlunojFrame.this, String.join("\n", errors), "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    AlunoDAO alunoDAO = new AlunoDAO();
                    Aluno aluno = alunoDAO.create(new Aluno(nome, prontuario, email, ativo));
                    Aluno alunoSalvo = alunoDAO.create(aluno);
                    System.out.println(alunoSalvo.getId());
                    cleanTextFields();
                } catch (Exception ex) {
                    
                }
            }
        });

        getContentPane().add(panel); 
        setResizable(false); 

        setVisible(true); 
    }

    private void cleanTextFields(){

    }
}
