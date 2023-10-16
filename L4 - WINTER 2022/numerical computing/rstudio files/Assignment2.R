# Assignment 2


# PART A

#print(TransistorCount1974_2020$Year)

#print(TransistorCount1974_2020$`Transistor Count`)

x.linear <- lm(TransistorCount ~ Year, TransistorCount1974_2020copy)

plot(x.linear$model$Year, x.linear$model$TransistorCount)
abline(x.linear, col="red")
points(x= 2016, y= 7.15, col="red")

# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
# Was this a good fit? 
# Explain why or why not and provide evidence to support your explanation.
#
# I don't think it's a great fit as it doesn't follow the points very
# accurately but it has a slightly similar direction.
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
# Are you able to visually identify any distinct outliers? (just 1 or 2)
#
# Yes, there are two outliers above 3e+10 that are further from the rest
# of the point.
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -

summary(x.linear)
# Residual standard error: 4.16e+09 
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -


# PART B
x.loglinear <- lm(log(TransistorCount) ~ Year, TransistorCount1974_2020copy)

plot(x.loglinear$model$Year, x.loglinear$model$`log(TransistorCount)`)
abline(x.loglinear, col="red")

# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
# Was this a good fit? 
# Explain why or why not and provide evidence to support your explanation.
#
# I think this line is a good fit and follows the majority of the points
# pretty accurately.
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
# Are you able to visually identify any distinct outliers? (just 1 or 2)
#
# Yes, I am able to distinguish one outlier at the very bottom right of
# the chart that strays very far from the rest of the points.
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -

summary(x.loglinear)
# Residual standard error: 1.586
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -

# PART C

points(x= 2016, y= 7.15, col="red")

# Did you identify this data point as an outlier in Part A?
# Explain why or why not?
# 
# I did not as in Part A they are decently close to the rest of the points
# and the other two were further.
#
# -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
#
# Which data plot is more suited for visually identifying outliers?  Explain your reason.
#
# Part B as the line takes a linear shape and you can easily identify the
# outlier located at the bottom right as its on its own extremely far
# from the rest.
