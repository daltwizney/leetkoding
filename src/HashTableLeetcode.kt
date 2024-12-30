package com.wizneylabs.leetcoding.exercises

class HashTableLeetcode {

    /**
     *  find first non-repeating character
     */

    fun findFirstNonRepeatingCharacter(data : String) : Char {

        var characterCounts = HashMap<Char, Int>();

        for (i in 0..data.length - 1)
        {
            val c = data[i];

            if (characterCounts.containsKey(c))
            {
                val count = characterCounts[c] ?: 0;

                characterCounts[c] = count + 1;
            }
            else
            {
                characterCounts[c] = 1;
            }
        }

        for (i in 0..data.length - 1)
        {
            val c = data[i];

            val count = characterCounts[c] ?: 0;

            if (count < 2)
            {
                return c;
            }
        }

        return '\u0000';
    }

    fun testFirstNonRepeatingCharacter() {

        val data = "truetalent";

        println("result = ${this.findFirstNonRepeatingCharacter(data)}");
    }

    /**
     *  find duplicates
     */

    fun findDuplicates(items : ArrayList<Int>) : ArrayList<Int> {

        val itemsSeen : HashMap<Int, Int> = HashMap<Int, Int>();

        val duplicates : ArrayList<Int> = ArrayList<Int>();

        for (i in 0..items.size - 1)
        {
            val item = items[i];

            if (itemsSeen.containsKey(item))
            {
                val count : Int? = itemsSeen[item];

                if (count != null)
                {
                    itemsSeen[item] = count + 1;

                    if (itemsSeen[item] == 2)
                    {
                        duplicates.add(item);
                    }
                }
            }
            else
            {
                itemsSeen[item] = 1;
            }
        }

        return duplicates;
    }

    fun testFindDuplicates() {

        val items = arrayListOf<Int>(0, 42, 1, 2, 3, 4, 5, 6, 2, 3, 42, 6, 54);

        val duplicates = findDuplicates(items);

        for (i in 0..duplicates.size - 1)
        {
            println("duplicate = ${duplicates[i]}");
        }
    }

    /**
     *  find if items in common exist
     */
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