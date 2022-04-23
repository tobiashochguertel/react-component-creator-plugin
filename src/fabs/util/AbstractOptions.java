package fabs.util;

import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractOptions implements SerializableOptions {
    abstract public ArrayList<String> getFiles();

    abstract public Map<String, String> getTemplateVariables();

    abstract public ArrayList<String> getTestFiles();

    public String[] getFileList() {
        return getFiles().toArray(new String[getFiles().size()]);
    }

    public String[] getTestFileList() {
        return getTestFiles().toArray(new String[getTestFiles().size()]);
    }
}
