# Assignment 1

# PART 1

# pasted from d2l
n <- 1.0
x<-1.0
i<-0
cat(paste("i", "x", "n\n", sep="\t\t"))
while (i < 1025) {
  n<-n*2.0
  x<-1.0/n
  
  if (i > 1000){
    
    if (x != 0){
      cat(paste( i, x, n, "\n", sep="\t"))
    }else{
      cat(paste( i, x, n, "\n", sep="\t\t"))
    }
  }
  
  
  i<-i+1
}

#?.Machine

# double.xmin -> 2.225074e-308

# PART 2

n <- c(1:10)
nFactorial <- factorial(n)
nNumApprox <-((n/exp(1))^n) * (sqrt(2*pi*n))
nAbsError <- (abs(n - nNumApprox))
nPerRelErr <- (nAbsError * 100)

nNumApprox <- format(nNumApprox, scientific = F, digits = 2)
nAbsError <- format(nAbsError, scientific = F, digits = 2)
nPerRelErr <- format(nPerRelErr, scientific = F, digits = 3)

numbers <- c(n, nFactorial, nNumApprox, nAbsError, nPerRelErr)
frame <- matrix(data=numbers, nrow=10, ncol=5, dimnames = list(c(), c("Number", "Factorial","Num Approximation", "Absolute Error","Percent Rel Err")))


print(frame)

# PART 3

#data()
#?data
#?mtcars
df <- mtcars

df["vs"][df["vs"] == 0] <- "V-Shaped"
df["vs"][df["vs"] == 1] <- "Straight"

head(df)

plot(mtcars$mpg, mtcars$hp, xlab = "Miles Per Gallon", ylab = "Horse Power")



