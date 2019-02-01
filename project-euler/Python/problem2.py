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
    a, b = 1, 1
    sum = 0
    while b < 4000000:
        a, b = b, a + b
        if b % 2 == 0:
            sum += b
    return sum


if __name__ == '__main__':
    print(even_fibonacci())
