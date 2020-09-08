package org.jetbrains.research.ml.codetracker

import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.application.ex.ApplicationInfoEx
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import org.jetbrains.research.ml.codetracker.tracking.TaskFileHandler


class InitActivity : StartupActivity {
    private val logger: Logger = Logger.getInstance(javaClass)

    init {
        logger.info("${Plugin.PLUGIN_NAME}: startup activity")
    }

    override fun runActivity(project: Project) {
        Plugin.installRequiredPlugins(project)
        logger.info("${Plugin.PLUGIN_NAME}: run activity")
        TaskFileHandler.addProject(project)
    }
}
