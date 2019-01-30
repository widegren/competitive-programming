#!/usr/bin/env python
"""
Python solution for Project Euler Problem 2: Even Fibonacci numbers
"""
__author__ = "Emelie Widegren"
__email__ = "emeliewide@gmail.com"


def even_fibonacci():
    """
    Returns the sum of the even-valued terms below four million.
    """
    first_term, second_term = 1, 1
    result = 0
    while second_term < 4000000:
        first_term, second_term = second_term, first_term + second_term
        if second_term % 2 == 0:
            result += second_term
    return result


if __name__ == '__main__':
    print(even_fibonacci())
