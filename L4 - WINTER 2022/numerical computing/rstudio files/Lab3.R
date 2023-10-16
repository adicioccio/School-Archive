# Exercise 1
vec1 <- c(seq(from = 0.1, to = 1, by = 0.1))

# Find length of vector
print(length(vec1))

# Create matrix
mat1 <- matrix(data=vec1, nrow=5, ncol=2, dimnames = list(c("row1", "row2", "row3", "row4", "row5"), c("col1", "col2")))

print(mat1)

mat1[3,2] <- 10

print(mat1[3,])
print(mat1[,2])

print(mat1)

# Exercise 2
examDF <- data.frame(
  Name = c("Adam", "Anastasia", "Dima", "Katherine", "James", "Emily", "Michael", "Matthew", "Laura", "Kevin", "Jonas"),
  Score = c(20.0, 12.5, 9.0, 16.5, 12.0, 9.0, 20.0, 14.5, 13.5, 8.0, 19.0),
  Attempts = c(1, 1, 3, 2, 3, 2, 3, 1, 1, 2, 1),
  Qualify = c("yes", "yes", "no", "yes", "no", "no", "yes", "yes", "no", "no", "yes")
)

examRES = subset(examDF, select = -c(Name, Score))
examQUAL <- examRES[-c(3, 5, 6, 9, 10), ]

print(examDF)
print(examRES)
print(examQUAL)

# Exercise 3
F_to_C <- function(fahrenheight) {
  celsius <- 5/9 * (fahrenheight - 32)
  return(celsius)
}

temps <- c(45, 77, 19, 101, 120)

for (item in temps) {
  print(F_to_C(item))
}


