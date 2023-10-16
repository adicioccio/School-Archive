# Lab 9

# Part B

x <- 1

x.mac <- c(seq(from = -4, to = 4, by = 0.1))

student.maclaurin.approx <- function(x) {
  answer = 8 + x - (x^2) + ((x^3)/3) - ((x^5)/30)
  
  print(answer)
}

student.maclaurin.exact <- function(x) {
  answer = 8 + (exp(1)^(-x))*(sin(x))
  print(answer)
}

student.maclaurin.approx(x)
student.maclaurin.exact(x)

points(x.mac, student.maclaurin.approx(x.mac), col="red")
points(x.mac, student.maclaurin.exact(x.mac), col="green")



