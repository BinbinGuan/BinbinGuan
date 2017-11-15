package com.idcos.guanbin.codegen;

import com.idcos.common.codegen.plugin.controller.ControllerPlugin;
import com.idcos.common.codegen.plugin.controller.ControllerTask;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 12/09/2017.
 */
public class ControllerGen {

    public static void main(String[] args) throws IOException {

        String projectPath = new File(".").getCanonicalPath();

        ControllerTask task = new ControllerTask();

        String appDir = projectPath + "/src/main/java/";

        String webDir = appDir + "/#controllerClassPackage#";

        ControllerPlugin plugin = new ControllerPlugin();
        plugin.setName("controller");

        plugin.addConfiguredFileproducer(task.getControllerFileProducer(webDir));
        plugin.addConfiguredFileproducer(task.getFormProducer(appDir));
        plugin.addConfiguredFileproducer(task.getQueryManagerProducer(appDir));
        plugin.addConfiguredFileproducer(task.getOperateManagerProducer(appDir));
        plugin.addConfiguredFileproducer(task.getQueryImplManagerProducer(appDir));
        plugin.addConfiguredFileproducer(task.getOperateImplManagerProducer(appDir));
        plugin.addConfiguredFileproducer(task.getConvertProduecer(appDir));
        plugin.addConfiguredFileproducer(task.getVoProducer(appDir));

        task.setPlugin(plugin);
        task.setConfigFile(projectPath + "/codegen/controller-config.xml");
        task.setAppname("GuanBin");

        task.setControllers("GuanTest");

        task.execute();
    }
}
