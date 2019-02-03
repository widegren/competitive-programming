#!/usr/bin/env python
"""
Python solution for Advent of Code Day 11: Radioisotope Thermoelectric Generators
"""
__author__ = "Emelie Widegren"
__email__ = "emeliewide@gmail.com"

if __name__ == '__main__':
    print(sum(2 * sum([2, 4, 4, 0][:x]) for x in range(1, 4)) - 3)
    print(sum(2 * sum([6, 4, 4, 0][:x]) for x in range(1, 4)) - 3)
