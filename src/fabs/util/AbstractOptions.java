package fabs.util;

import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractOptions implements SerializableOptions {
    abstract public ArrayList<String> getFiles();

    abstract public Map<String, String> getTemplateVariables();

    abstract public ArrayList<String> getTestFiles();

    abstract public ArrayList<String> getHookFiles();

    abstract public boolean getCreateSubComponent();

    abstract public boolean getCreateViewModel();

    public String[] getFileList() {
        return getFiles().toArray(new String[getFiles().size()]);
    }

    public String[] getTestFileList() {
        return getTestFiles().toArray(new String[getTestFiles().size()]);
    }

    public String[] getHookFileList() {
        return getHookFiles().toArray(new String[getHookFiles().size()]);
    }

    public boolean isCreateSubComponent() {
        return getCreateSubComponent();
    }

    public boolean isCreateViewModel() {
        return getCreateViewModel();
    }
}
