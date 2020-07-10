import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AbstractActionTest extends JFrame 
{
    private static final long serialVersionUID = 1L;

    private  final  String  BUTTON_NAME = "button1"; 

    public AbstractActionTest()
    {
        super("������ ������������� Action");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // ������ �����������
        Container container = getContentPane();
        // ������������� �������� ����������������� ������������
        container.setLayout(new FlowLayout());
        // �������� ������, ����������� ���� ��������
        Action action = new SimpleAction();
        JButton button1 = new JButton(action);
        button1.setName(BUTTON_NAME);
        button1.setText("First button");
        button1.setMnemonic('F');
        JButton button2 = new JButton(action);
        button2.setName("button2");
        button2.setText("Second button");
        button2.setMnemonic('S');
        container.add(button1);
        container.add(button2);
        // ������� ���� �� �����
        setSize(320, 100);
        setVisible(true);
    }
    // ���������� �����
    class SimpleAction extends AbstractAction {
        private static final long serialVersionUID = 1L;
        SimpleAction() {
                // ��������� �������
                // putValue(NAME, "����� Action!");
                putValue(SHORT_DESCRIPTION, "��� ���������");
                // putValue(MNEMONIC_KEY, new Integer('A'));
        }
        // ��������� ������� ������� �� ������
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            System.out.println("������� �� ������ <" + btn.getName() + ">");
            // ����� ��������� �������, �� ����, � ����� ����������� ��� ������������
            if (btn.getName().equalsIgnoreCase(BUTTON_NAME)) {
                btn.setEnabled(false);
                // ��������� �������
                // putValue(NAME, "Disabled button");
                btn.setText("Disabled button");
            }
        }
    };
    public static void main(String[] args) {
        new AbstractActionTest();
    }
}