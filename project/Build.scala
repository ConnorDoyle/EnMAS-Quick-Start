import sbt._
import Keys._
object EnMASBuild extends Build {

  val bundlerTask = TaskKey[Unit]("bundler") <<= (target, fullClasspath in Runtime) map {
    (target, cp) => {
      val cpOpt = cp.map(_.data).mkString(":")
      val jars = cp map { item  ⇒ new File(item.data.toString) }
      (new Fork.ForkScala("Bundler"))(
        None,               // java home
        Seq("-cp", cpOpt),  // jvm options
        jars,               // scala jars
        Seq(),              // arguments
        None,               // working directory
        StdoutOutput        // output strategy
      )
    }
  }

  lazy val EnMASproject = Project (
    "EnMAS",
    file ("."),
    settings = Defaults.defaultSettings ++ Seq(bundlerTask)
  )
}