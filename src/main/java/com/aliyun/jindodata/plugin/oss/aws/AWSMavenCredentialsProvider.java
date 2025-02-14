/*
 * Copyright 2018-Present Platform Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyun.jindodata.plugin.oss.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import org.apache.maven.wagon.authentication.AuthenticationInfo;

public class AWSMavenCredentialsProvider implements AWSCredentialsProvider {

    private final AuthenticationInfo authenticationInfo;

    public AWSMavenCredentialsProvider(AuthenticationInfo authenticationInfo) {
        this.authenticationInfo = authenticationInfo;
    }

    @Override
    public AWSCredentials getCredentials() {
        return this.authenticationInfo != null ? new AWSMavenCredentials(this.authenticationInfo) : null;
    }

    @Override
    public void refresh() {
    }
}
