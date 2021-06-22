package study.softserve.scala

object JSONParser {
  case class Weather(main: String, description: String) {
    override def toString: String = {
      s"(main=$main, description=$description)"
    }
  }
  case class Clouds(all: Int) {
    override def toString: String = {
      s"(count=$all)"
    }
  }
  case class Sys(country: String, sunrise: Long, sunset: Long) {
    override def toString: String = {
      s"(country=$country, sunriseTime=$sunrise, sunsetTime=$sunset)"
    }
  }
  case class CityWeather(name: String, dt: Long, weather: List[Weather], clouds: Clouds, sys: Sys, timezone: Int) {
    override def toString: String = {
      s"(name=$name, date=$dt, weather=$weather, clouds=$clouds, system=$sys, timezone=$timezone)"
    }
  }
}
