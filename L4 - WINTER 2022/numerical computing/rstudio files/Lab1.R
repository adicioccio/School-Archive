# example 1
print("--- Example 1 ---")
print("Hello World!")
print("Hello World!", quote = FALSE)
print(paste("Hello", "World!"))

# example 2
print("--- Example 2 ---")
my.name <- readline(prompt="Enter name: ")
my.age <- readline(prompt="Enter age: ")
my.age <- as.integer(my.age)

print(paste("Hi,", my.name, "next year you will be", my.age+1, "years old."))

# example 3
print("--- Example 3 ---")
my.name0 <- readline(prompt="Enter full name: ")
my.year <- readline(prompt="Enter current year of study: ")
my.term <- readline(prompt="Enter term of study: ")
my.id <- readline(prompt="Enter your student ID: ")

print(paste("My name is", my.name0, ". My current study term is", my.year, my.term, "and my student ID is", my.id))

# signature
print("Program created by Adam Di Cioccio")


