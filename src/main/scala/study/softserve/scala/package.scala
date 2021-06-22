package study.softserve

package object scala {
<<<<<<< HEAD
  implicit val system: ActorSystem = ActorSystem("Actor")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val formats: DefaultFormats.type = DefaultFormats



  val openWeatherApiKey: String = "932990025e60573ec55fb150d6ae8368"
  val cities = List("London", "Paris", "Kyiv", "Lviv", "Singapore", "Rome", "Beijing", "Seoul", "Milan")

  val apiResponseTimeout = 3
  val schedulerTimeout = 1
=======
  val openWeatherApiKey: String = "932990025e60573ec55fb150d6ae8368"
  val cities = List("London", "Paris", "Kyiv", "Lviv", "Singapore", "Rome", "Beijing", "Seoul")
>>>>>>> parent of ef52027... added communication between actors / added sort by temperature
}
