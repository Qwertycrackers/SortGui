
lazy val root = (project in file(".")).
    settings(
        inThisBuild(List(
            scalaVersion := "2.12.4",
            version := "0.1.0-SNAPSHOT"
        )),
        name := "SortGui",
        libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2"
        )

