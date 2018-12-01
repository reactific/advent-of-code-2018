enablePlugins(ReactificPlugin)
enablePlugins(UniversalPlugin)
enablePlugins(JavaAppPackaging)

name := "AOC2018"
titleForDocs := "Advent Of Code 2018"
codePackage := "com.reactific.aoc2018"

scalaVersion := "2.12.6"

mainClass := Some("MakingMusicWithAkkaStreams")

val akka_version = "2.5.16"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % akka_version,
  "com.typesafe.akka" %% "akka-actor-typed" % akka_version,
  "com.typesafe.akka" %% "akka-http" % "10.1.4",
  
  "com.github.scopt" %% "scopt" % "3.7.0",
  "org.scalactic" %% "scalactic" % "3.0.5",
  
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.typesafe.akka" %% "akka-testkit" % akka_version % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % akka_version % Test

)

javaOptions in Universal ++= Seq(
  // For making Pi4J use dynamic loading of wiring.so
  "-Dpi4j.linking=dynamic",
  
  "--illegal-access=warn",
  
  // For making Pi4J work in debug mode
  "-Dpi4j.debug",

  // -J params will be added as jvm parameters
  "-J-Xmx512m",
  "-J-Xms256m",
  
  // you can access any build setting/task here
  s"-Dversion=${version.value}"
)

parallelExecution in Test := false
