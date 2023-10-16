# Lab 7
student.LinRegress <- function(mtcarsmpg, mtcarswt) {
  #               Y             X
  test1_lm <- lm(mtcars$mpg ~ mtcars$wt)
  
  print(paste0("LINE OF BEST LINEAR FIT -> y = ", test1_lm$coefficients[2], "x + ", test1_lm$coefficients[1]))
  
  print(paste0("SUM OF SQUARE RESIDUALS -> ", round(anova(test1_lm)$"Sum Sq"[2], digits = 2)))
  
  print(paste0("STANDARD ERROR -> ", round(sqrt(anova(test1_lm)$"Mean Sq"[2]), digits = 3)))
}

student.LinRegress(mtcars$wt, mtcars$mpg)


summary(test1_lm)

anova(test1_lm)

