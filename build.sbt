import com.typesafe.sbt.packager.docker.DockerChmodType

version in ThisBuild := "0.1"

scalaVersion in ThisBuild := "2.13.3"

// Docker
def dockerSettings = Seq(
  dockerUpdateLatest := true,
  dockerBaseImage := "adoptopenjdk/openjdk8",
  dockerUsername := Some("uc4official"),
  dockerChmodType := DockerChmodType.UserGroupWriteExecute,
)

// Projects
lazy val Pipeline = (project in file("."))
  .aggregate(test_service)

lazy val test_service = (project in file("test"))
  .settings(dockerSettings)