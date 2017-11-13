from itertools import permutations

"""
original draft of algorithm

ONE_CUP = 8
coffee_pot = CoffeePot()
employee = Employee()

@synchronized
def get_coffee():
    if coffee_pot.is_empty:
        coffee_pot.brew()
        coffee_pot.is_empty = False
    elif not employee.has_coffee:
        employee.pour(coffee_pot)
        employee.has_coffee = True
        coffee_pot.is_empty = \
            coffee_pot.volume() <= ONE_CUP
    else:
        employee.return_to_desk()
        return
    get_coffee()

"""


def run():
    p = 'abbc'
    s = 'abcbabbacbaabccbbabbabaabbbcbabcbcbcabbabababaaaabcbcbbbcbab'
    s_dict = {}

    for index, char in enumerate(s):
        pass

    x = permutations(p)
    x.__iter__()
    perms = [''.join(p) for p in permutations(p)]

    print(perms)
    # permutations
    # for


import math

DEFAULT_BUCKET_SIZE = 26


def bucket_sort(array, bucketSize=DEFAULT_BUCKET_SIZE):
    if len(array) == 0:
        return array

    # Determine minimum and maximum values
    minValue = array[0]
    maxValue = array[0]
    for i in range(1, len(array)):
        if array[i] < minValue:
            minValue = array[i]
        elif array[i] > maxValue:
            maxValue = array[i]

    # Initialize buckets
    bucketCount = math.floor((ord(maxValue) - ord(minValue)) / bucketSize) + 1
    buckets = []
    for i in range(0, bucketCount):
        buckets.append([])

    # Distribute input array values into buckets
    for i in range(0, len(array)):
        buckets[math.floor((ord(array[i]) - ord(minValue)) / bucketSize)].append(array[i])

    # Sort buckets and place back into input array
    array = []
    for i in range(0, len(buckets)):
        insertion_sort(buckets[i])
        for j in range(0, len(buckets[i])):
            array.append(buckets[i][j])

    return array


# =======================================================================
#  Author: Isai Damier
#  Title: Insertionsort
#  Project: geekviewpoint
#  Package: algorithms
#
#  Statement:
#  Given a disordered list of integers (or any other items),
#  rearrange the integers in natural order.
#
#  Sample Input: [8,5,3,1,9,6,0,7,4,2,5]
#  Sample Output: [0,1,2,3,4,5,5,6,7,8,9]
#
#  Time Complexity of Solution:
#  Best O(n); Average O(n^2); Worst O(n^2).
#
#  Approach:
#  Insertion sort is good for collections that are very small
#  or nearly sorted. Otherwise it's not a good sorting algorithm:
#  it moves data around too much. Each time an insertion is made,
#  all elements in a greater position are shifted.
# =======================================================================
def insertion_sort(a_list):
    for i in range(1, len(a_list)):
        tmp = a_list[i]
        k = i
        while k > 0 and tmp < a_list[k - 1]:
            a_list[k] = a_list[k - 1]
            k -= 1
        a_list[k] = tmp


if __name__ == '__main__':
    print('Hello world!')
    print(bucket_sort('Hello world'))
    run()
