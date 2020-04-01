package fabs.reducer.data;

import fabs.util.SerializableOptions;
import org.jdom.Element;

import java.util.ArrayList;

public class ReducerCreateOptions implements SerializableOptions {
    public static final String STORE_KEY = "rcc.reducer";
    private final static String ACTION_TEMPLATE = "ACTION_TEMPLATE";
    private final static String ACTION_TYPES_TEMPLATE = "ACTION_TYPES_TEMPLATE";
    private final static String INDEX_TEMPLATE = "INDEX_TEMPLATE";
    private final static String TYPES_TEMPLATE = "TYPES_TEMPLATE";

    private String defaultActionTemplateFile = "templates/reducer/actions.ts.mustache";
    private String defaultModuleIndexTemplateFile = "templates/reducer/index.ts.mustache";
    private String defaultTypesTemplateFile = "templates/reducer/types.ts.mustache";
    private String defaultActionTypesTemplateFile = "templates/reducer/action-types.ts.mustache";

    private String actionTemplateFile = defaultActionTemplateFile;
    private String moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
    private String typesTemplateFile = defaultTypesTemplateFile;
    private String actionTypesTemplateFile = defaultActionTypesTemplateFile;

    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(ACTION_TEMPLATE, actionTemplateFile);
        element.setAttribute(INDEX_TEMPLATE, moduleIndexTemplateFile);
        element.setAttribute(ACTION_TYPES_TEMPLATE, actionTypesTemplateFile);
        element.setAttribute(TYPES_TEMPLATE, typesTemplateFile);
        return element;
    }

    public void deserialize(Element element) {
        setActionTemplateFile(element.getAttributeValue(ACTION_TEMPLATE));
        setActionTypesTemplateFile(element.getAttributeValue(ACTION_TYPES_TEMPLATE));
        setModuleIndexTemplateFile(element.getAttributeValue(INDEX_TEMPLATE));
        setTypesTemplateFile(element.getAttributeValue(TYPES_TEMPLATE));
    }

    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(actionTemplateFile);
        files.add(moduleIndexTemplateFile);
        files.add(typesTemplateFile);
        files.add(actionTypesTemplateFile);
        return files;
    }

    public void setActionTemplateFile(String actionTemplateFile) {
        if (actionTemplateFile == null) {
            this.actionTemplateFile = null;
            return;
        }

        if (actionTemplateFile.isEmpty()) {
            this.actionTemplateFile = defaultActionTemplateFile;
            return;
        }
        this.actionTemplateFile = actionTemplateFile;
    }

    public void setModuleIndexTemplateFile(String moduleIndexTemplateFile) {
        if (moduleIndexTemplateFile == null) {
            this.moduleIndexTemplateFile = null;
            return;
        }

        if (moduleIndexTemplateFile.isEmpty()) {
            this.moduleIndexTemplateFile = defaultModuleIndexTemplateFile;
            return;
        }
        this.moduleIndexTemplateFile = moduleIndexTemplateFile;
    }


    public void setTypesTemplateFile(String typesTemplateFile) {
        if (typesTemplateFile == null) {
            this.typesTemplateFile = null;
            return;
        }

        if (typesTemplateFile.isEmpty()) {
            this.typesTemplateFile = defaultTypesTemplateFile;
            return;
        }
        this.typesTemplateFile = typesTemplateFile;
    }

    public void setActionTypesTemplateFile(String actionTypesTemplateFile) {
        if (actionTypesTemplateFile == null) {
            this.actionTypesTemplateFile = null;
            return;
        }

        if (actionTypesTemplateFile.isEmpty()) {
            this.actionTypesTemplateFile = defaultActionTypesTemplateFile;
            return;
        }
        this.actionTypesTemplateFile = actionTypesTemplateFile;
    }

    public String getActionTemplateFile() {
        return actionTemplateFile;
    }

    public String getModuleIndexTemplateFile() {
        return moduleIndexTemplateFile;
    }

    public String getTypesTemplateFile() {
        return typesTemplateFile;
    }

    public String getActionTypesTemplateFile() {
        return actionTypesTemplateFile;
    }

    public boolean isActionTemplateDefault() {
        return this.actionTemplateFile.equals(this.defaultActionTemplateFile);
    }

    public boolean isModuleTemplateDefault() {
        return this.moduleIndexTemplateFile.equals(this.defaultModuleIndexTemplateFile);
    }

    public boolean isTypesTemplateDefault() {
        return this.typesTemplateFile.equals(this.defaultTypesTemplateFile);
    }

    public boolean isActionTypesTemplateDefault() {
        return this.actionTypesTemplateFile.equals(this.defaultActionTypesTemplateFile);
    }
}
