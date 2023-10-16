# LaGrange Interpolation

x <- 1.22
#numbers <- c(0.12, 1.32, 2.21, 3.12, 7.65, 8.9822, 11.1230, 1.2, 3.1, 2.22, 5.980, 9.987, 12.873, 19.233)
#numbers <- c(2, 5, 8, -3, 9, 21)
numbers <- c(1.2, 1.3, 0.3849, 0.4032)
mat1 <- matrix(data=numbers, nrow=(length(numbers)/2), ncol=2, dimnames = list(c(), c("x", "f(x)")))

LaGrange.poly <- function(num, mat) {
  result <- 0
  print(mat)
  print("--------------")
  print(paste0("Find f(", num, ")"))
  
  for(i in 1:nrow(mat)) {
    nume <- 1
    dom <- 1
    for(j in 1:nrow(mat)) {
          if (mat[i,1] != mat[j,1]) {
            nume <- nume * (num - mat[j,1])
            dom <- dom * (mat[i,1] - mat[j,1])
          }
    }
    result <- result + nume/dom * mat[i,2]
  }
  
  print(paste0("Answer -> ", result))
}

print("Adam Di Cioccio - 041019241")

LaGrange.poly(x, mat1)

