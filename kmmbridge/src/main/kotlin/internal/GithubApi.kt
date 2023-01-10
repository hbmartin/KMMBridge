/*
 * Copyright (c) 2022 Touchlab.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package co.touchlab.faktory.internal

import co.touchlab.faktory.findStringProperty
import co.touchlab.faktory.kmmBridgeExtension
import org.gradle.api.Project
import java.io.File

interface GithubApi {

    fun createRelease(project: Project, repo: String, tag: String, commitId: String?): Int
}

internal val Project.githubPublishToken
    get() = (project.property("GITHUB_PUBLISH_TOKEN")
        ?: throw IllegalArgumentException("KMMBridge Github operations need property GITHUB_PUBLISH_TOKEN")) as String

internal val Project.githubPublishUser: String?
    get() = project.findStringProperty("GITHUB_PUBLISH_USER")

internal val Project.githubRepo
    get() = (project.findStringProperty("GITHUB_REPO")
        ?: throw IllegalArgumentException("KMMBridge Github operations need a repo param or property GITHUB_REPO"))
