class TreeNode(var `val` : Int) {
    var left : TreeNode? = null;
    var right : TreeNode? = null;
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private fun _isUpOneDir(word: String): Boolean {

        return word.length == 2 && word[0] == '.' && word[1] == '.';
    }

    private fun _isSameDir(word: String): Boolean {

        return word.length == 1 && word[0] == '.';
    }

    fun simplifyPath(path: String): String {

        val queue = ArrayDeque<String>();

        val words = path.split('/');

        for (i in 0..words.size - 1)
        {
            val word = words[i];

            if (_isUpOneDir(word))
            {
                if (queue.size > 0)
                {
                    queue.removeLast();
                }
            }
            else if (word.isEmpty())
            {
                // no-op
            }
            else if (!_isSameDir(word))
            {
                queue.addLast(word);
            }
        }

        val builder = StringBuilder();

        builder.append('/');

        for (i in 0..queue.size - 1)
        {
            builder.append(queue[i]);

            if (i != queue.size - 1)
            {
                builder.append('/');
            }
        }

        return builder.toString();
    }
}