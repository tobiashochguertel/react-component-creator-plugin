package fabs.util;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.util.Map;

public class Creator implements Runnable {
    protected VirtualFile directory;
    protected String componentName;
    protected String directoryName;
    protected AbstractOptions options;

    public Creator(VirtualFile directory, String directoryName, String componentName, AbstractOptions options) {
        this.directory = directory;
        this.componentName = componentName;
        this.directoryName = directoryName;
        this.options = options;
    }

    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        this.writeFiles();
    }

    protected void writeFiles() throws IOException {
        FileUtils utils = new FileUtils();
        TemplateRenderer renderer = new TemplateRenderer();
        VirtualFile componentDirectory = directory.createChildDirectory(directory, directoryName);
        Map<String, String> variablemap = options.getTemplateVariables();

        String[] files = options.getFileList();
        String[] testFiles = options.getTestFileList();
        String[] hookFiles = options.getHookFileList();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            utils.writeFile(renderer.render(file, variablemap), componentDirectory.createChildData(componentDirectory, TemplateRenderer.transformTemplateName(file, variablemap)));
        }

        if (testFiles.length > 0) {
            VirtualFile testDirectory = componentDirectory.createChildDirectory(componentDirectory, "__test__");
            for (int i = 0; i < testFiles.length; i++) {
                String file = testFiles[i];
                utils.writeFile(renderer.render(file, variablemap), testDirectory.createChildData(testDirectory, TemplateRenderer.transformTemplateName(file, variablemap)));
            }
        }

        if (hookFiles.length > 0) {
            VirtualFile hookDirectory = componentDirectory.createChildDirectory(componentDirectory, "hooks");
            for (int i = 0; i < hookFiles.length; i++) {
                String file = hookFiles[i];
                utils.writeFile(renderer.render(file, variablemap), hookDirectory.createChildData(hookDirectory, TemplateRenderer.transformTemplateName(file, variablemap)));
            }
        }

        if (options.getCreateSubComponent()) {
            componentDirectory.createChildDirectory(componentDirectory, "components");
        }

        if (options.getCreateViewModel()) {
            componentDirectory.createChildDirectory(componentDirectory, "viewModel");
        }
    }

    @Override
    public void run() {
        try {
            this.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
