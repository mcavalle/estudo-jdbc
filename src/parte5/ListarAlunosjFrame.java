package parte5;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarAlunosjFrame extends JDialog {
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JPanel panel;

    public ListarAlunosjFrame(){
        setTitle("Cadastrar Aluno");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);

        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Nome", "Prontuario", "Email", "Ativo"},
            0
        );

        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);

        panel = new JPanel(new BorderLayout());

        panel.add(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        loadData();

        setVisible(true);
        
    }
    
    private void loadData(){
        Object[] rowData1 = {1, "Maria", "SP0101", "maria@email.com", true};
        Object[] rowData2 = {2, "Pedro", "SP0102", "pedro@email.com", false};
        Object[] rowData3 = {3, "Joao", "SP0103", "joao@email.com", true};

        tableModel.addRow(rowData1);
        tableModel.addRow(rowData2);
        tableModel.addRow(rowData3);
    }
}
