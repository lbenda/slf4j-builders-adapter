# slf4j-builders-adapter
Adapters for loging in custom plugins (tasks, mojos etc.) in builders tool.

# Repository configuration
```
<pluginRepositories>
  <pluginRepository>
    <id>db-maven-plugin-mvn-repo</id>
    <url>https://raw.github.com/lbenda/sl4j-build-adapter/mvn-repo/</url>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </pluginRepository>
</pluginRepositories>
```

# Use
```
<plugin>
  <groupId>GROUP</groupId>
  <artifactId>Artifacts</artifactId>
  <dependencies>
    <dependency>
      <groupId>cz.lbenda.slf4j.adapter</groupId>
      <artifactId>slf4j-maven-adapter</artifactId>
      <version>1.0</version>
    </dependency>
  </dependencies>
</plugin>
```
