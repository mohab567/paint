package model;

import java.io.File;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class ShapesLoader {

    private ArrayList<Class<?>> Shapes;

    public ShapesLoader() {
        Shapes = new ArrayList<>();
        File dir = new File("GameData");
        dir.mkdir();
        Shapes.add(loadClass(new File(dir + "\\"), "Oval.class"));
    }

    public ArrayList<Class<?>> getList() {
        return Shapes;
    }

    public Class<?> loadClass(File source, String name) {

        try {

            String path = new File("").getAbsolutePath() + "\\model\\";
            new File(path).mkdirs();
            Files.copy(new File(source.toPath() + "\\" + name).toPath(),
                    new File(path + name).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            source = new File(new File("").getAbsolutePath());
            java.net.URL url = source.toURI().toURL();
            java.net.URL[] urls = new java.net.URL[] { url };

            // load this folder into Class loader
            ClassLoader cl = new URLClassLoader(urls);

            // load the Address class in 'c:\\other_classes\\'
            Class<?> cls = cl.loadClass("model." + name.substring(0, name
                    .indexOf('.')));

            try {
                Files.delete(new File(path + name).toPath());
                Files.delete(new File(new File("").getAbsolutePath()
                        + "\\model\\").toPath());
            } catch (Exception e) {}
            return cls;
        } catch (Exception e) {

        }
        return null;
    }

}
