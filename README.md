# Object Maven Wagon
##NOTE: THIS PROJECT IS ALSO NOT SUPPORTED ANYMORE!!!

## Description
This project is a fork of a [Maven Wagon](https://github.com/platform-team/aws-maven) for [Amazon S3](http://aws.amazon.com/s3/).  In order to to publish artifacts to an S3 bucket, the user (as identified by their access key) must be listed as an owner on the bucket.

## Why this fork?
- original repo not maintained for a long time but we updated fork to the latest libs.
- we fixed some of issues that blocks others and us.
- no support from maintainers of original repo. 


## Usage
To publish Maven artifacts to S3 a build extension must be defined in a project's `pom.xml`.  The latest version of the wagon can be found on the [`aws-maven`](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.platform-team%22%20AND%20a%3A%22aws-maven%22) page in Maven Central.

```xml
<project>
  ...
  <build>
    ...
    <extensions>
      ...
      <extension>
        <groupId>me.sundp</groupId>
        <artifactId>oss-maven</artifactId>
        <version>7.0.0</version>
      </extension>
      ...
    </extensions>
    ...
  </build>
  ...
</project>
```

Once the build extension is configured distribution management repositories can be defined in the `pom.xml` with an `s3://` scheme.

```xml
<project>
  ...
  <distributionManagement>
    <repository>
      <id>oss-release</id>
      <name>Oss Release Repository</name>
      <url>oss://<BUCKET>/release</url>
    </repository>
    <snapshotRepository>
      <id>oss-snapshot</id>
      <name>Oss Snapshot Repository</name>
      <url>oss://<BUCKET>/snapshot</url>
    </snapshotRepository>
  </distributionManagement>
  ...
</project>
```

Finally the `~/.m2/settings.xml` must be updated to include access and secret keys for the account. The access key should be used to populate the `username` element, and the secret access key should be used to populate the `password` element.

```xml
<settings>
  ...
  <servers>
    ...
    <server>
      <id>oss-release</id>
      <username>0123456789ABCDEFGHIJ</username>
      <password>0123456789abcdefghijklmnopqrstuvwxyzABCD</password>
      <configuration>
        <wagonProvider>s3</wagonProvider>
      </configuration>
    </server>
    <server>
      <id>oss-snapshot</id>
      <username>0123456789ABCDEFGHIJ</username>
      <password>0123456789abcdefghijklmnopqrstuvwxyzABCD</password>
      <configuration>
        <wagonProvider>s3</wagonProvider>
      </configuration>
    </server>
    ...
  </servers>
  ...
</settings>
```

## Release Notes
* `7.0.0`
  - Updated to the latest versions of aws-sdk and maven-wagon.
  