class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        values = list(range(1,n+1))
        print(values)
        solution = []
        for x in values:
            if ((x%3 == 0) & (x%5 == 0)):
                solution.append("FizzBuzz")
            elif (x % 3) == 0:
                solution.append("Fizz")
            elif (x%5) == 0:
                solution.append("Buzz")
            else:
                solution.append(str(x))
        return solution
