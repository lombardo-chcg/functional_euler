// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

// Find the sum of all the multiples of 3 or 5 below 1000.

def fancyFizzBuzz(num: Int) : Boolean = {
  if (num % 3 == 0) return true
  if (num % 5 == 0) return true
  false
}

val answer =
  (1 to 999)
    .toList
    .filter(fancyFizzBuzz)
    .foldLeft(0)(_+_)

println(answer)