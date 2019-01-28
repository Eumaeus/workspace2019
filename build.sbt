
name := "hmtTwiddle"

version := "0.0.1"

// must be at least 2.11 to use hmt_textmodel
scalaVersion := "2.11.8"

run / connectInput := true

resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith","maven")
libraryDependencies ++=   Seq(
  "edu.holycross.shot.cite" %% "xcite" % "3.6.0",
  "edu.holycross.shot" %% "ohco2" % "10.9.2",
  "edu.holycross.shot" %% "orca" % "4.2.0",
  "edu.holycross.shot" %% "scm" % "6.1.3",
  "edu.holycross.shot" %% "greek" % "1.4.0",
  "edu.holycross.shot" %% "gsphone" % "1.1.0",
  "org.homermultitext" %% "hmt-textmodel" % "4.0.0"
)

