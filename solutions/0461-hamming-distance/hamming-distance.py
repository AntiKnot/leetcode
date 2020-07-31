# -*- coding:utf-8 -*-


# The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
#
# Given two integers x and y, calculate the Hamming distance.
#
# Note:
# 0 ≤ x, y < 231.
#
#
# Example:
#
# Input: x = 1, y = 4
#
# Output: 2
#
# Explanation:
# 1   (0 0 0 1)
# 4   (0 1 0 0)
#        ↑   ↑
#
# The above arrows point to positions where the corresponding bits are different.
#
#


class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        bin_x = bin(x)[2:]
        bin_y = bin(y)[2:]
        str_0 = "00000000000000000000000000000000"
        str_x = (str_0 + bin_x)[-32:]
        str_y = (str_0 + bin_y)[-32:]
        sum = 0
        for i in range(32):
            if str_x[i]!=str_y[i]:
                sum +=1
        return sum

