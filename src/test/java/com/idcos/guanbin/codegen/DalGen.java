package com.idcos.guanbin.codegen;

import com.idcos.common.codegen.plugin.jpa.JpaTask;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 12/09/2017.
 */
public class DalGen {

    public static void main(String[] args) throws IOException {

        String projectPath = new File(".").getCanonicalPath();

        JpaTask task = new JpaTask();

        String bizDir = projectPath + "/src/main/java/";

        task.setAppname("guanbin");

        task.setDatabaseConfigFile("application-local.properties");

        task.setConfigfile(projectPath + "/codegen/dal-config.xml");

        JpaTask.setTabs("GuanTest");

        task.createDynamicElement("jpa");

        task.getPlugin().addConfiguredFileproducer(task.getRepositoryProducer(bizDir));
        task.getPlugin().addConfiguredFileproducer(task.getEntryProducer(bizDir));

        task.execute();

    }
}
