//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6331 👎 0


package leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//Java：无重复字符的最长子串 todo 优化方案
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        final int c = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(c);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            final char[] chars = s.toCharArray();
            int start = 0, end = 0, length = 0;
            final LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            while (end < s.length()) {
                final char aChar = chars[end];
                if (map.containsKey(aChar)) {
                    final Integer index = map.get(aChar);
                    final Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        final boolean equals = iterator.next().getKey().equals(aChar);
                        iterator.remove();
                        if (equals) {
                            break;
                        }
                    }
                    if (end - start > length) {
                        length = end - start;
                    }
                    start = index + 1;
                }
                map.put(aChar, end);
                end++;
            }
            if (end - start > length) {
                length = end - start;
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}