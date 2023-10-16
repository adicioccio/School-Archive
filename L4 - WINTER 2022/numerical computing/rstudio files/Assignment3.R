# Assignment 3

student.ode.euler <- function (x, y, h) {
  yVec <- c(0)
  for (i in 1:length(x)) {
    yVec[i] <- y
    y <- y + h * (cos(2*x[i]) - y)
  }
  return (yVec)
}

student.ode.exactvalue <- function (x) {
  yVec <- c(0)
  for (j in 1:length(x)) {
    yVec[j] <- (0.2*cos(2*x[j])) + (0.4*sin(2*x[j])) + 2.8*(exp(-x[j]))
  }
  return (yVec)
}

student.ode.rk4 <- function (x, y, h) {
  yVec <- c(0)
  for (l in 1:length(x)) {
    yVec[l] <- y
    k1 <- (cos(2*x[l]) - y)
    k2 <- (cos(2*(x[l]+h/2)) - (k1*h*(1/2) + y))
    k3 <- (cos(2*(x[l]+h/2)) - (k2*h*(1/2) + y))
    k4 <- (cos(2*(x[l]+h)) - (y + (k3*h)))
    y <- y + (h/6)*(k1 + 2*k2 + 2*k3 + k4)
  }
  return(yVec)
}

y <- 3

xVec <- c(seq(from = 0, to = 3, by = 0.8))
xVec1 <- c(seq(from = 0, to = 3, by = 0.2))
xVec2 <- c(seq(from = 0, to = 3, by = 0.05))

h <- 0.8
h1 <- 0.2
h2 <- 0.05

test3 <- student.ode.exactvalue(xVec2)

test <- student.ode.euler(xVec, y, h)
test1 <- student.ode.euler(xVec1, y, h1)
test2 <- student.ode.euler(xVec2, y, h2)

test4 <- student.ode.rk4(xVec, y, h)
test5 <- student.ode.rk4(xVec1, y, h1)
test6 <- student.ode.rk4(xVec2, y, h2)


plot(xVec2, test3, col="brown", pch = 4, xlab = "Time(seconds)", ylab = "Temperature", xlim = c(0,3), main = "Euler's Method (ODE)", sub = "Red=0.8 | Green=0.2 | Blue=0.05")
points(xVec, test, col="red", pch = 1)
points(xVec1, test1, col="green", pch = 2)
points(xVec2, test2, col="blue", pch = 3)

plot(xVec2, test3, col="brown", pch = 4, xlab = "Time(seconds)", ylab = "Temperature", xlim = c(0,3), main = "RK4 Method (ODE)", sub = "Red=0.8 | Green=0.2 | Blue=0.05")
points(xVec, test4, col="red", pch = 1)
points(xVec1, test5, col="green", pch = 2)
points(xVec2, test6, col="blue", pch = 3)

