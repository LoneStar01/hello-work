/*95. Unique Binary Search Trees II
Medium

2037

158

Add to List

Share
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 

Constraints:

0 <= n <= 8
Accepted
185.7K
Submissions
467.5K
Seen this question in a real interview before?

Yes

No
Contributor
LeetCode
*/

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def generateTrees(n: Int): List[TreeNode] = {
        def rangeTrees(from: Int, to: Int): List[TreeNode] = {
            if (from > to) List(null)
            else if (from == to) List(new TreeNode(from, null, null) )
            else from.to(to).toList.flatMap (m => { 
                val allL = rangeTrees(from, m - 1)
                val allR = rangeTrees(m + 1, to)
                for {
                    t1 <- allL 
                    t2 <- allR
                } yield {
                    new TreeNode(m, t1, t2)
                }
            })
            
        }
        rangeTrees(1, n).filter(_ != null)
        
    }
}
