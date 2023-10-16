# Lab 10 - Adam Di Cioccio
ascent <- lm(`Altitude\r\n(meters)` ~ `Time\r\n(seconds)`, Ascent_STS121_Data)

plot(ascent$model$`Time\r\n(seconds)`, ascent$model$`Altitude\r\n(meters)`, xlab = "Time(seconds)", ylab = "Altitude(meters)", main = "Shuttle STS121 Launch - Plot of Time vs Altitude")

h <- 20
student.numDiff.fdd <- function (time, altitude) {

  answer <- (altitude[(time/h)+2] - altitude[(time/h)+1]) / h
  plot(x=time, y=answer, col="red", xlab = "Time(seconds)", ylab = "Velocity", main = "Shuttle STS121 Launch - Plot of Time vs Velocity")
}

student.numDiff.bdd <- function (time, altitude) {
  naVector <- c(NA)
  altitude1 <- append(naVector, altitude)
  
  answer <- (altitude1[(time/h)+2] - altitude1[(time/h)+1]) / h
  points(x=time, y=answer, col="blue", pch = 2)
}

student.numDiff.cdd <- function (time, altitude) {
  naVector <- c(NA)
  altitude1 <- append(naVector, altitude)
  
  answer <- (altitude1[(time/h)+3] - altitude1[(time/h)+1]) / (2*h)
  points(x=time, y=answer, col="green", pch = 3)
}

student.numDiff.secDer <- function (time, altitude) {
  naVector <- c(NA)
  altitude1 <- append(naVector, altitude)
  
  answer <- (altitude1[(time/h)+3] - (2*altitude1[(time/h)+2]) + altitude1[(time/h)+1]) / (h*h)
  plot(x=time, y=answer, col="red", xlab = "Time(seconds)", ylab = "Acceleration", main = "Shuttle STS121 Launch - Plot of Time vs Acceleration")
}

student.numDiff.fdd(ascent$model$`Time\r\n(seconds)`, ascent$model$`Altitude\r\n(meters)`)
student.numDiff.bdd(ascent$model$`Time\r\n(seconds)`, ascent$model$`Altitude\r\n(meters)`)
student.numDiff.cdd(ascent$model$`Time\r\n(seconds)`, ascent$model$`Altitude\r\n(meters)`)
student.numDiff.secDer(ascent$model$`Time\r\n(seconds)`, ascent$model$`Altitude\r\n(meters)`)

