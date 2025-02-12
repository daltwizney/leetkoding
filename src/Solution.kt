import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun sortedSquares(nums: IntArray): IntArray {

        if (nums.size == 0)
        {
            return nums;
        }

        if (nums.size == 1)
        {
            nums[0] *= nums[0];
            return nums;
        }

        // find index of minSquareValue
        var minSquareValue = Int.MAX_VALUE;
        var minSquareIndex = 0;

        for (i in 0..nums.size - 1)
        {
            val square = nums[i] * nums[i];

            if (square < minSquareValue)
            {
                minSquareValue = square;
                minSquareIndex = i;
            }
        }

        // starting from minSquareIndex, compute squares in order
        val squareArray = IntArray(nums.size);

        var leftIndex = minSquareIndex;
        var rightIndex = minSquareIndex + 1;

        for (i in 0..squareArray.size - 1)
        {
            val canGoRight = (rightIndex < nums.size);
            val canGoLeft = (leftIndex >= 0);

            if (canGoLeft && canGoRight)
            {
                val leftSquare = nums[leftIndex] * nums[leftIndex];
                val rightSquare = nums[rightIndex] * nums[rightIndex];

                if (leftSquare < rightSquare)
                {
                    squareArray[i] = leftSquare;
                    leftIndex--;
                }
                else
                {
                    squareArray[i] = rightSquare;
                    rightIndex++;
                }
            }
            else if (canGoLeft)
            {
                val leftSquare = nums[leftIndex] * nums[leftIndex];

                squareArray[i] = leftSquare;
                leftIndex--;
            }
            else // canGoRight
            {
                val rightSquare = nums[rightIndex] * nums[rightIndex];

                squareArray[i] = rightSquare;
                rightIndex++;
            }
        }

        return squareArray;
    }
}