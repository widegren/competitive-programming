#!/usr/bin/env python
"""
Python solution for Project Euler Problem 1: Multiples of 3 and 5
"""
__author__ = "Emelie Widegren"
__email__ = "emeliewide@gmail.com"


def multiples():
    """
    Returns the sum of all the multiples of 3 or 5 below 1000.
    """
    result = 0
    for i in range(1000):
        if (i % 3) == 0 or (i % 5) == 0:
            result += i
    return result


if __name__ == '__main__':
    print(multiples())
