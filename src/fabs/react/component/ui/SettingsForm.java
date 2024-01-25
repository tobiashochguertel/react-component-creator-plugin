package fabs.react.component.ui;

import fabs.react.component.data.ComponentCreateOptions;
import fabs.util.AbstractSettingsForm;

import javax.swing.*;

public class SettingsForm extends AbstractSettingsForm<ComponentCreateOptions> {
    private JPanel mainPanel;
    private JTextField componentTemplateInput;
    private JTextField storyTemplateInput;
    private JTextField specTemplateInput;
    private JTextField lessTemplateInput;
    private JTextField mdTemplateInput;

    private JButton componentTemplateBtn;
    private JButton storyTemplateBtn;
    private JButton specTemplateBtn;
    private JButton lessTemplateBtn;
    private JButton mdTemplateBtn;
    private JButton componentTemplateResetBtn;
    private JButton storybookTemplateReset;
    private JButton specTemplateResetBtn;
    private JButton lessTemplateReset;
    private JButton mdTemplateResetBtn;
    private JCheckBox storybookCheckbox;
    private JCheckBox specCheckBox;
    private JCheckBox lessCheckBox;
    private JCheckBox mdCheckBox;
    private JCheckBox presenterCheckBox;
    private JCheckBox hookCheckBox;

    public SettingsForm(ComponentCreateOptions options) {
        super(options);

        if (!options.isComponentTemplateDefault()) {
            componentTemplateInput.setText(options.getComponentTemplateFile());
        }

        if (!options.isStoryTemplateDefault()) {
            storyTemplateInput.setText(options.getStoryTemplateFile());
        }

        if (!options.isSpecTemplateDefault()) {
            specTemplateInput.setText(options.getSpecTemplateFile());
        }

        if (!options.isLessTemplateDefault()) {
            lessTemplateInput.setText(options.getLessTemplateFile());
        }

        if (!options.isMDTemplateDefault()) {
            mdTemplateInput.setText(options.getMarkdownTemplateFile());
        }

        storybookCheckbox.setSelected(options.isCreateStorybookDefaultChecked());
        specCheckBox.setSelected(options.isCreateSpecDefaultChecked());
        lessCheckBox.setSelected(options.isCreateLessDefaultChecked());
        mdCheckBox.setSelected(options.isCreateMarkdownDefaultChecked());
        presenterCheckBox.setSelected(options.isCreatePresenterDefaultChecked());
        hookCheckBox.setSelected(options.isCreateHookDefaultChecked());

        componentTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, componentTemplateInput));
        componentTemplateResetBtn.addActionListener(e -> onResetButtonClicked(e, componentTemplateInput));

        storyTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, storyTemplateInput));
        storybookTemplateReset.addActionListener(e -> onResetButtonClicked(e, storyTemplateInput));

        specTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, specTemplateInput));
        specTemplateResetBtn.addActionListener(e -> onResetButtonClicked(e, specTemplateInput));

        lessTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, lessTemplateInput));
        lessTemplateReset.addActionListener(e -> onResetButtonClicked(e, lessTemplateInput));

        mdTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, mdTemplateInput));
        mdTemplateResetBtn.addActionListener(e -> onBrowseButtonClicked(e, mdTemplateInput));
    }

    @Override
    public JComponent getMainPanel() {
        return mainPanel;
    }

    @Override
    public boolean isDirty() {
        ComponentCreateOptions o = new ComponentCreateOptions();
        applySettings(o);
        return !options.equals(o);
    }

    public void applySettings(ComponentCreateOptions options) {
        String component = componentTemplateInput.getText();
        String story = storyTemplateInput.getText();
        String spec = specTemplateInput.getText();
        String less = lessTemplateInput.getText();
        String md = mdTemplateInput.getText();

        options.setComponentTemplateFile(component);
        options.setStoryTemplateFile(story);
        options.setSpecTemplateFile(spec);
        options.setLessTemplateFile(less);
        options.setMarkdownTemplateFile(md);

        options.setCreateMarkdownDefaultChecked(mdCheckBox.isSelected());
        options.setCreateSpecDefaultChecked(specCheckBox.isSelected());
        options.setCreateLessDefaultChecked(lessCheckBox.isSelected());
        options.setCreateStorybookDefaultChecked(storybookCheckbox.isSelected());
        options.setCreatePresenterDefaultChecked(presenterCheckBox.isSelected());
        options.setCreateHookDefaultChecked(hookCheckBox.isSelected());
    }
}
