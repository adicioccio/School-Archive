# Exercise 1 


v1 <- c(1, 2, 4, 8, 16)
print(v1)

vecSqr <- function (vector) {
  newVector <- vector * vector
  return(newVector)
}

v2 <- vecSqr(v1)
print(v2)
print("Program by: Adam Di Cioccio - 041019241")

# Exercise 2
s <- "Hello World!"

first3let <- function(string) {
  if (nchar(string) >= 3) {
    print(substr(string,1,3))
  } else {
    print("Length of input string is less than 3")
  }
}

first3let(s)
print("Program by: Adam Di Cioccio - 041019241")

# Exercise 3
v3 <- c(1, 2, 5, 69, NaN, 100)

vecTF <- function (vector) {
  newVector <- (vector %% 2) == 0
  return(newVector)
}

v4 <- vecTF(v3)
print(v4)
print("Program by: Adam Di Cioccio - 041019241")
  
# Exercise 4
number <- 4

factorial <- function(num){
  factor <- 1
  
  if (num < 0) {
    return("Please input positive number")
  } else if (num == 0) {
    factor <- 1
  } else {
    for( i in 1:num) {
      factor <- factor * i
    }
  }
  return (factor)
}

print(factorial(number))
print("Program by: Adam Di Cioccio - 041019241")
