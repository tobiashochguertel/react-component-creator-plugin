package fabs.react.component.data;

import fabs.util.AbstractOptions;
import fabs.util.StringFormatter;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "rcc.component";
    private final String COMPONENT_TEMPLATE_KEY = "COMPONENT_TEMPLATE_KEY";
    private final String SPEC_TEMPLATE_KEY = "SPEC_TEMPLATE_KEY";
    private final String STORY_TEMPLATE_KEY = "STORY_TEMPLATE_KEY";
    private final String MD_TEMPLATE_KEY = "MD_TEMPLATE_KEY";
    private final String LESS_TEMPLATE_KEY = "LESS_TEMPLATE_KEY";
    private final String HOOK_TEMPLATE_KEY = "HOOK_TEMPLATE_KEY";
    private final String PRESENTER_TEMPLATE_KEY = "PRESENTER_TEMPLATE_KEY";

    private final String defaultComponentTemplateFile = "templates/component/{{componentName}}.tsx.mustache";
    private final String defaultLessTemplateFile = "templates/component/{{componentName}}.less.mustache";
    private final String defaultSpecTemplateFile = "templates/component/{{componentName}}.spec.tsx.mustache";
    private final String defaultStoryTemplateFile = "templates/component/{{componentName}}.story.tsx.mustache";
    private final String defaultMarkdownTemplateFile = "templates/component/{{componentName}}.md.mustache";
    private final String defaultHookTemplateFile = "templates/component/use{{componentCamelcaseName}}.tsx.mustache";
    private final String defaultPresenterTemplateFile = "templates/component/{{componentName}}-presenter.tsx.mustache";
    private final String indexTemplateFile = "templates/component/index.ts.mustache";

    private String componentTemplateFile = defaultComponentTemplateFile;
    private String lessTemplateFile = defaultLessTemplateFile;
    private String specTemplateFile = defaultSpecTemplateFile;
    private String storyTemplateFile = defaultStoryTemplateFile;
    private String markdownTemplateFile = defaultMarkdownTemplateFile;
    private String hookTemplateFile = defaultHookTemplateFile;
    private String presenterTemplateFile = defaultPresenterTemplateFile;

    private final String MD_CHECKBOX_KEY = "MD_CHECKBOX_KEY";
    private final String STORY_CHECKBOX_KEY = "STORY_CHECKBOX_KEY";
    private final String LESS_CHECKBOX_KEY = "LESS_CHECKBOX_KEY";
    private final String SPEC_CHECKBOX_KEY = "SPEC_CHECKBOX_KEY";

    private boolean isCreateStorybookDefaultChecked = false;
    private boolean isCreateSpecDefaultChecked = true;
    private boolean isCreateLessDefaultChecked = true;
    private boolean isCreateMarkdownDefaultChecked = true;
    private boolean isCreatePresenterDefaultChecked = true;
    private boolean isCreateHookDefaultChecked = true;

    private Boolean isCreateLessFile = false;
    private Boolean isCreateSpecFile = false;
    private Boolean isCreateStoryFile = false;
    private Boolean isCreateMDFile = false;
    private Boolean isCreatePresenterFile = false;
    private Boolean isCreateHookFile = false;
    private Boolean isCreateSubComponentFolder = false;
    private Boolean isCreateViewModelFolder = false;

    private String componentName;

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(COMPONENT_TEMPLATE_KEY, componentTemplateFile);
        element.setAttribute(LESS_TEMPLATE_KEY, lessTemplateFile);
        element.setAttribute(SPEC_TEMPLATE_KEY, specTemplateFile);
        element.setAttribute(STORY_TEMPLATE_KEY, storyTemplateFile);
        element.setAttribute(MD_TEMPLATE_KEY, markdownTemplateFile);

        element.setAttribute(MD_CHECKBOX_KEY, Boolean.toString(isCreateMarkdownDefaultChecked));
        element.setAttribute(STORY_CHECKBOX_KEY, Boolean.toString(isCreateStorybookDefaultChecked));
        element.setAttribute(LESS_CHECKBOX_KEY, Boolean.toString(isCreateLessDefaultChecked));
        element.setAttribute(SPEC_CHECKBOX_KEY, Boolean.toString(isCreateSpecDefaultChecked));
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setLessTemplateFile(element.getAttributeValue(LESS_TEMPLATE_KEY));
        setSpecTemplateFile(element.getAttributeValue(SPEC_TEMPLATE_KEY));
        setStoryTemplateFile(element.getAttributeValue(STORY_TEMPLATE_KEY));
        setMarkdownTemplateFile(element.getAttributeValue(MD_TEMPLATE_KEY));

        setCreateMarkdownDefaultChecked(Boolean.valueOf(element.getAttributeValue(MD_TEMPLATE_KEY)));
        setCreateStorybookDefaultChecked(Boolean.valueOf(element.getAttributeValue(STORY_CHECKBOX_KEY)));
        setCreateLessDefaultChecked(Boolean.valueOf(element.getAttributeValue(LESS_CHECKBOX_KEY)));
        setCreateSpecDefaultChecked(Boolean.valueOf(element.getAttributeValue(SPEC_CHECKBOX_KEY)));
    }

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(indexTemplateFile);
        files.add(componentTemplateFile);

        if (isCreateLessFile) {
            files.add(lessTemplateFile);
        }

        if (isCreateMDFile) {
            files.add(this.markdownTemplateFile);
        }

        if (isCreatePresenterFile) {
            files.add(presenterTemplateFile);
        }

        return files;
    }

    @Override
    public Map<String, String> getTemplateVariables() {
        Map<String, String> templateModel = new HashMap<>();

        templateModel.put("componentName", componentName);
        templateModel.put("className", componentName.replaceAll("-", "_"));
        templateModel.put("componentCamelcaseName", StringFormatter.toCamelCase(componentName));

        return templateModel;
    }

    @Override
    public ArrayList<String> getTestFiles() {
        ArrayList<String> files = new ArrayList<>();
        if (isCreateSpecFile) {
            files.add(specTemplateFile);
        }
        return files;
    }

    @Override
    public ArrayList<String> getHookFiles() {
        ArrayList<String> files = new ArrayList<>();
        if (isCreateHookFile) {
            files.add(hookTemplateFile);
        }
        return files;
    }

    @Override
    public boolean getCreateSubComponent() {
        return isCreateSubComponentFolder;
    }

    @Override
    public boolean getCreateViewModel() {
        return isCreateViewModelFolder;
    }

    public void setComponentTemplateFile(String componentTemplateFile) {
        if (componentTemplateFile == null || componentTemplateFile.isEmpty()) {
            this.componentTemplateFile = defaultComponentTemplateFile;
            return;
        }
        this.componentTemplateFile = componentTemplateFile;
    }


    public void setLessTemplateFile(String lessTemplateFile) {
        if (lessTemplateFile == null || lessTemplateFile.isEmpty()) {
            this.lessTemplateFile = defaultLessTemplateFile;
            return;
        }
        this.lessTemplateFile = lessTemplateFile;
    }


    public void setSpecTemplateFile(String specTemplateFile) {
        if (specTemplateFile == null || specTemplateFile.isEmpty()) {
            this.specTemplateFile = defaultSpecTemplateFile;
            return;
        }
        this.specTemplateFile = specTemplateFile;
    }


    public void setStoryTemplateFile(String storyTemplateFile) {
        if (storyTemplateFile == null || storyTemplateFile.isEmpty()) {
            this.storyTemplateFile = defaultStoryTemplateFile;
            return;
        }
        this.storyTemplateFile = storyTemplateFile;
    }


    public void setMarkdownTemplateFile(String markdownTemplateFile) {
        if (markdownTemplateFile == null || markdownTemplateFile.isEmpty()) {
            this.markdownTemplateFile = defaultMarkdownTemplateFile;
            return;
        }
        this.markdownTemplateFile = markdownTemplateFile;
    }

    public boolean isComponentTemplateDefault() {
        return componentTemplateFile.equals(defaultComponentTemplateFile);
    }

    public boolean isLessTemplateDefault() {
        return lessTemplateFile.equals(defaultLessTemplateFile);
    }

    public boolean isSpecTemplateDefault() {
        return specTemplateFile.equals(defaultSpecTemplateFile);
    }

    public boolean isStoryTemplateDefault() {
        return storyTemplateFile.equals(defaultStoryTemplateFile);
    }

    public boolean isMDTemplateDefault() {
        return markdownTemplateFile.equals(defaultMarkdownTemplateFile);
    }

    public void setCreateLessFile(Boolean createLessFile) {
        isCreateLessFile = createLessFile;
    }

    public void setCreateSpecFile(Boolean createSpecFile) {
        isCreateSpecFile = createSpecFile;
    }

    public void setCreateStoryFile(Boolean createStoryFile) {
        isCreateStoryFile = createStoryFile;
    }

    public void setCreateMDFile(Boolean createMDFile) {
        isCreateMDFile = createMDFile;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentTemplateFile() {
        return componentTemplateFile;
    }

    public String getLessTemplateFile() {
        return lessTemplateFile;
    }

    public String getSpecTemplateFile() {
        return specTemplateFile;
    }

    public String getStoryTemplateFile() {
        return storyTemplateFile;
    }

    public String getMarkdownTemplateFile() {
        return markdownTemplateFile;
    }

    public boolean isCreateStorybookDefaultChecked() {
        return isCreateStorybookDefaultChecked;
    }

    public boolean isCreateSpecDefaultChecked() {
        return isCreateSpecDefaultChecked;
    }

    public boolean isCreateLessDefaultChecked() {
        return isCreateLessDefaultChecked;
    }

    public boolean isCreateMarkdownDefaultChecked() {
        return isCreateMarkdownDefaultChecked;
    }

    public void setCreateStorybookDefaultChecked(boolean createStorybookDefaultChecked) {
        isCreateStorybookDefaultChecked = createStorybookDefaultChecked;
    }

    public void setCreateSpecDefaultChecked(boolean createSpecDefaultChecked) {
        isCreateSpecDefaultChecked = createSpecDefaultChecked;
    }

    public void setCreateLessDefaultChecked(boolean createLessDefaultChecked) {
        isCreateLessDefaultChecked = createLessDefaultChecked;
    }

    public void setCreateMarkdownDefaultChecked(boolean createMarkdownDefaultChecked) {
        isCreateMarkdownDefaultChecked = createMarkdownDefaultChecked;
    }

    public boolean isCreatePresenterDefaultChecked() {
        return isCreatePresenterDefaultChecked;
    }
    public void setCreatePresenterDefaultChecked(boolean isChecked) {
        isCreatePresenterDefaultChecked = isChecked;
    }
    public void setCreatePresenterFile(Boolean createFile) {
        isCreatePresenterFile = createFile;
    }

    public boolean isCreateHookDefaultChecked() {
        return isCreateHookDefaultChecked;
    }
    public void setCreateHookDefaultChecked(boolean isChecked) {
        isCreateHookDefaultChecked = isChecked;
    }
    public void setCreateHookFile(Boolean createFile) {
        isCreateHookFile = createFile;
    }

    public void setCreateSubComponent(Boolean createFolder) {
        isCreateSubComponentFolder = createFolder;
    }

    public void setCreateViewModel(Boolean createFolder) {
        isCreateViewModelFolder = createFolder;
    }

    public boolean equals(ComponentCreateOptions options) {
        return (options.getComponentTemplateFile().equals(componentTemplateFile)
                && options.getStoryTemplateFile().equals(storyTemplateFile)
                && options.getSpecTemplateFile().equals(specTemplateFile)
                && options.getLessTemplateFile().equals(lessTemplateFile)
                && options.getMarkdownTemplateFile().equals(markdownTemplateFile)
                && options.isCreateMarkdownDefaultChecked() == isCreateMarkdownDefaultChecked
                && options.isCreateLessDefaultChecked() == isCreateLessDefaultChecked
                && options.isCreateSpecDefaultChecked() == isCreateSpecDefaultChecked
                && options.isCreateStorybookDefaultChecked() == isCreateStorybookDefaultChecked
                && options.isCreatePresenterDefaultChecked() == isCreatePresenterDefaultChecked
                && options.isCreateHookDefaultChecked() == isCreateHookDefaultChecked
        );
    }
}
