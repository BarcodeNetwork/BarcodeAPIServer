package com.vjh0107.barcode.api.server

import org.gradle.api.Plugin
import org.gradle.api.Project

class ProjectManagerPlugin : Plugin<Project> {
    companion object {
        lateinit var project: Project
    }
    override fun apply(target: Project) {
        project = target
    }
}