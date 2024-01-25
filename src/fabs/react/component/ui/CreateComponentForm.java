package fabs.react.component.ui;

import fabs.react.component.data.ComponentCreateOptions;
import fabs.util.AbstractDialog;

import javax.swing.*;
import java.awt.event.*;

public class CreateComponentForm extends AbstractDialog<ComponentCreateOptions> {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox unitTestCheckBox;
    private JCheckBox LessCheckBox;
    private JCheckBox markdownCheckBox;
    private JCheckBox presenterCheckBox;
    private JCheckBox useHookCheckBox;
    private JCheckBox subComponentsCheckBox;
    private JCheckBox viewModelCheckBox;

    public CreateComponentForm(ComponentCreateOptions options) {
        super(options);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        unitTestCheckBox.setSelected(true);
        LessCheckBox.setSelected(true);
        markdownCheckBox.setSelected(true);
        presenterCheckBox.setSelected(true);
        useHookCheckBox.setSelected(true);
    }

    @Override
    protected void onOK() {
        options.setComponentName(componentNameTextField.getText());
        options.setCreateSpecFile(unitTestCheckBox.isSelected());
        options.setCreateLessFile(LessCheckBox.isSelected());
        options.setCreateMDFile(markdownCheckBox.isSelected());
        options.setCreatePresenterFile(presenterCheckBox.isSelected());
        options.setCreateHookFile(useHookCheckBox.isSelected());
        options.setCreateSubComponent(subComponentsCheckBox.isSelected());
        options.setCreateViewModel(viewModelCheckBox.isSelected());
        super.onOK();
    }

    public String getComponentName() {
        return componentNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return componentNameTextField.getText();
    }
}
