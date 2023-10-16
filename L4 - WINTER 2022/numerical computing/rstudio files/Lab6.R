# Lab6

# STEP 1

# Display data sets
#data()

# Display mtcars data set
#?mtcars

# Plot based on weight and miles per gallon
plot(mtcars$wt, mtcars$mpg)

# STEP 2
meanC <- function(v1) {
  m <- sum(v1) / length(v1)
}

medianC <- function(v1) {
  vec <- sort(v1, decreasing = FALSE)
  m <- vec[((length(v1) + 1) / 2)]
}

modeC <- function(v1) {
  m <- unique(v1)
  m[which.max(tabulate(match(v1, m)))]
}

rangeC <- function(v1) {
  vec <- sort(v1, decreasing = FALSE)
  r <- paste(vec[1], vec[length(vec)], sep=" - ", collapse=NULL)
}

sdC <- function(v1) {
  sd <- sqrt( sum( (v1-mean(v1))^2) / (length(v1)-1) )
}

student.stats <- function(v1) {
  print(paste0("Mean: ", meanC(v1)))
  print(paste0("Mean: ", mean(v1)))
  print(paste0("Median: ", medianC(v1)))
  print(paste0("Median: ", median(v1)))
  print(paste0("Mode: ", modeC(v1)))
  print(paste0("Range: ", rangeC(v1)))
  print(paste0("Standard Deviation: ", sdC(v1)))
  print(paste0("Standard Deviation: ", sd(v1)))
}
student.stats(mtcars$mpg)

# STEP 3
n1 <- 100
n2 <- 10000
x_ran1 <- rnorm(n1)
x_ran2 <- rnorm(n2)

hist(x_ran1, breaks = 80, main = paste("n=",n1))
hist(x_ran2, breaks = 80, main = paste("n=",n2))

print(paste0("(n=100) Mean: ", meanC(x_ran1)))
print(paste0("(n=100) Standard Deviation: ", sdC(x_ran1)))
print(paste0("(n=10000) Mean: ", meanC(x_ran2)))
print(paste0("(n=10000) Standard Deviation: ", sdC(x_ran2)))

# STEP 4
#?women
print(paste0("(HEIGHT) Mean: ", meanC(women$height)))
print(paste0("(HEIGHT) Standard Deviation: ", sdC(women$height)))
print(paste0("(WEIGHT) Mean: ", meanC(women$weight)))
print(paste0("(WEIGHT) Standard Deviation: ", sdC(women$weight)))

# STEP 5
pnorm(0.19)
round(pnorm(0.19), digits=5)

