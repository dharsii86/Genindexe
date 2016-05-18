/*
 * Interface which allow user to create a scrapie test.
 */
package screen;

import data.SpeciesList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import nf.RawData;
import nf.ScrapieResult;
import nf.ScrapieTest;
import nf.Specie;

/**
 *
 * @author SCRUM Group 2.
 */
public class ScrapieTestInterface extends JPanel {

    private final MenuWindow globalScreen;

    private final JLabel labValue, nameSpe, labPosition, title;

    private JTextField position, value;

    private JComboBox boxCategory;

    private final JButton validate;

    public ScrapieTestInterface(final MenuWindow globalScreen) {
        super();
        this.globalScreen = globalScreen;
        this.setLayout(new GridBagLayout());

        /*Initialisation*/
        //  title
        title = new JLabel("Scrapie Test creation", SwingConstants.CENTER);
        this.setBackground(Color.white);
        title.setFont(title.getFont().deriveFont(24.0f));

        //  box Category
        nameSpe = new JLabel("Name of the species");
        Set<String> cat = SpeciesList.getSpecies().keySet();
        String[] nameSpecies = cat.toArray(new String[cat.size()]);
        boxCategory = new JComboBox(nameSpecies);
        boxCategory.setPreferredSize(new Dimension(200, 24));

        // Labels
        labPosition = new JLabel("Position : ");
        position = new JTextField();
        position.setToolTipText("Enter the position of the scrapie test.");
        position.setPreferredSize(new Dimension(200, 24));
        labValue = new JLabel("Value : ");
        value = new JTextField();
        value.setToolTipText("Enter the value of the scrapie test.");
        value.setPreferredSize(new Dimension(200, 24));

        // Button validation
        validate = new JButton("Test");
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String specieName;
                specieName = (String) boxCategory.getSelectedItem();

                if (!specieName.equals("") && !position.getText().equals("") && !value.getText().equals("")) {

                    ScrapieResult res;
                    RawData rowEntry, rowResult;
                    Specie sp = SpeciesList.get(specieName);
                    int pos = Integer.parseInt(position.getText());
                    int val = Integer.parseInt(value.getText());

                    rowEntry = new RawData(pos, val);
                    ScrapieTest scrapie = new ScrapieTest(sp, pos, val);
                    res = (ScrapieResult) scrapie.newResult();
                    rowResult = res.getScrapieValue();
                    if (rowEntry.getValue() != 0 && rowEntry.getPosition() != 0) {
                        globalScreen.setSouth("The Scrapie Test with the Specie: " + sp.getName() + ", the position : " + position.getText() + " and the value : " + value.getText() + " is a success.");
                        close();
                    } else {
                        globalScreen.setSouth("The Scrapie Test with the Specie: " + sp.getName() + ", the position : " + position.getText() + " and the value : " + value.getText() + " has failed.");
                    }
                } else {
                    globalScreen.setSouth("A field is empty.");
                }

            }
        });

        //////////////////////////////////
        // Grid Bag Constraints
        GridBagConstraints gbTitle = new GridBagConstraints();
        GridBagConstraints gblabBox = new GridBagConstraints();
        GridBagConstraints gbBox = new GridBagConstraints();
        GridBagConstraints gblabPos = new GridBagConstraints();
        GridBagConstraints gbpos = new GridBagConstraints();
        GridBagConstraints gblabVal = new GridBagConstraints();
        GridBagConstraints gbval = new GridBagConstraints();
        GridBagConstraints gbValidate = new GridBagConstraints();

        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        gbTitle.gridwidth = 3;

        gblabBox.gridx = 0;
        gblabBox.gridy = 2;
        gblabBox.anchor = GridBagConstraints.LINE_END;

        gbBox.gridx = 2;
        gbBox.gridy = 2;
        gbBox.anchor = GridBagConstraints.LINE_START;

        gblabPos.gridx = 0;
        gblabPos.gridy = 4;
        gblabPos.anchor = GridBagConstraints.LINE_END;

        gbpos.gridx = 2;
        gbpos.gridy = 4;
        gbpos.anchor = GridBagConstraints.LINE_START;

        gblabVal.gridx = 0;
        gblabVal.gridy = 6;
        gblabVal.anchor = GridBagConstraints.LINE_END;

        gbval.gridx = 2;
        gbval.gridy = 6;
        gbval.anchor = GridBagConstraints.LINE_START;

        gbValidate.gridx = 0;
        gbValidate.gridy = 8;
        gbValidate.gridwidth = 3;

        this.add(title, gbTitle);
        this.add(nameSpe, gblabBox);
        this.add(boxCategory, gbBox);
        this.add(labPosition, gblabPos);
        this.add(position, gbpos);
        this.add(labValue, gblabVal);
        this.add(value, gbval);
        this.add(validate, gbValidate);

        // organisation panel
        GridBagConstraints gbpan1 = new GridBagConstraints();

        gbpan1.gridx = 1;
        gbpan1.gridy = 1;
        JPanel pos1 = new JPanel();
        pos1.setPreferredSize(new Dimension(50, 10));
        pos1.setBackground(Color.white);

        GridBagConstraints gbpan2 = new GridBagConstraints();

        gbpan2.gridx = 1;
        gbpan2.gridy = 2;
        JPanel pos2 = new JPanel();
        pos2.setPreferredSize(new Dimension(30, 10));
        pos2.setBackground(Color.white);

        GridBagConstraints gbpan3 = new GridBagConstraints();

        gbpan3.gridx = 1;
        gbpan3.gridy = 3;
        JPanel pos3 = new JPanel();
        pos3.setPreferredSize(new Dimension(30, 10));
        pos3.setBackground(Color.white);

        GridBagConstraints gbpan4 = new GridBagConstraints();

        gbpan4.gridx = 1;
        gbpan4.gridy = 5;
        JPanel pos4 = new JPanel();
        pos4.setPreferredSize(new Dimension(50, 10));
        pos4.setBackground(Color.white);

        this.add(pos1, gbpan1);
        this.add(pos2, gbpan2);
        this.add(pos3, gbpan3);
        this.add(pos4, gbpan4);

    }

    // Close the panel
    private void close() {
        try {
            globalScreen.delMiddle();
        } catch (NullPointerException ex) {
            System.out.println("Ligne 145");
        }
    }
}
