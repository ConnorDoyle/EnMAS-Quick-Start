name := "EnMAS-quickstart"

version := "1.0"

fork in run := true

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "EnMAS Repository" at "http://repo.enmas.org/"
)

retrieveManaged := true

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.9.1",
  "org.scala-lang" % "scala-swing" % "2.9.1",
  "org.scala-lang" % "scala-compiler" % "2.9.1",
  "org.enmas" % "enmas_2.9.1" % "0.9",
  "com.typesafe.akka" % "akka-actor" % "2.0",
  "com.typesafe.akka" % "akka-remote" % "2.0"
)

unmanagedClasspath in Runtime <+= (baseDirectory) map {
  bd => Attributed.blank(bd / "config")
}
