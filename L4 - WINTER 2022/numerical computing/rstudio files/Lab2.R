# Lab 2 Numerical Computing
# Adam Di Cioccio
# 041019241

# Step 5.1
v1 <- c(1, 3, 5)
v2 <- c(7, 9, 11)
v3 <- c(13, 15, 17)

# Two matrices
cbind(v1, v2, v3)
rbind(v1, v2, v3)

# Step 5.2
STUDENT <- data.frame(
  Name = c("Adam D", "Hubert F", "John D", "Jane D", "Michael S", "Dwight S", "Joe B"),
  Gender = c("M", "M", "M", "F", "M", "M", "F"),
  StuID = c(435323, 324432, 461353, 146321, 420912, 124144, 190294),
  Program = c("CET", "CP", "CET", "CP", "CET", "CET", "CET"),
  NumCourses = c(2, 4, 2, 5, 1, 3, 7)
)

print(STUDENT)
