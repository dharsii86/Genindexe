package screen;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 *
 * @author SCRUM Group 2.
 */
public class AutoCloseDialog extends JDialog {

    private JLabel messageLabel;
    private long timeout;

    public AutoCloseDialog(Frame owner, String title, String message, long timeout) {

        super(owner, title);
        messageLabel = new JLabel(message);
        this.timeout = timeout;
        add(messageLabel);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(owner);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                new Thread() {

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(AutoCloseDialog.this.timeout);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } finally {
                            dispose();
                        }
                    }
                }.start();
            }
        });
    }

    public static void showAutoCloseDialog(Frame owner, String title, String message, long timeout) {
        AutoCloseDialog dialog = new AutoCloseDialog(owner, title, message, timeout);
        dialog.setVisible(true);
    }
}
