# Question 9

irisLM <- lm(iris$Petal.Width ~ iris$Sepal.Width)

print(paste0("Sum of Square residuals -> ", round(anova(irisLM)$"Sum Sq"[2], digits = 2)))

print(paste0("Residual Standard Error -> ", round(sqrt(anova(irisLM)$"Mean Sq"[2]), digits = 3)))

summary(irisLM)
