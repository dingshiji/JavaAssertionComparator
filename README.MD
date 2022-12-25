## 比较两个assertion

处理了的常见情况
1. 两个assertion字符串完全相同 exact_match
2. 有一些额外的空白字符, 或者error message correct_answer
3. equals()交换参数  swap_order
4. assertTrue/False的参数取非 true_or_false
   1. 一般情况下, 两个assertion type不同时, incorrect_type = true
   2. 但是 assertTrue(a)和assertFalse(!a) 例外
5. 多了一个error message参数 with_error_msg


这些情况考虑了, 可以看TestTypicalCases.java

另外一些情况, 例如比较这段代码. 没有做特殊处理. 会认为(a)和a不同, 是错误答案. 
```java
assertEquals((a),b) 
assertEquals(a,b)
```

assertEquals()和assertTrue()是完整的. 另外六种类型, 现在只是调用了一个简单的比较函数. 还没有处理各种情况.   
等到assertEquals()和assertTrue()没问题, 复制一下代码稍微调一下就好了. 