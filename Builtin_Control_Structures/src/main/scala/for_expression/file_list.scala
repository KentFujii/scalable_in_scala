package for_expression

object FileList extends App {
  val filesHere = (new java.io.File(".")).listFiles
  for (file <- filesHere) println(file)
}
