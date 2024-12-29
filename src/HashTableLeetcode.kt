package com.wizneylabs.leetcoding.exercises

class HashTableLeetcode {

    /* hashtable leetcode exercise */
    fun itemInCommon(list1 : ArrayList<Int>, list2 : ArrayList<Int>) : Boolean {

        val itemsSeen : HashSet<Int> = HashSet<Int>();

        for (i in 0..list1.size - 1)
        {
            itemsSeen.add(list1[i]);
        }

        for (i in 0..list2.size - 1)
        {
            if (itemsSeen.contains(list2[i]))
            {
                return true;
            }
        }

        return false;
    }

    fun testItemInCommon() {

        val list1 : ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7);
        val list2 : ArrayList<Int> = arrayListOf(42, 43, 44, 4, 45, 46, 47);

        val result = itemInCommon(list1, list2);

        println("result = $result");
    }

}