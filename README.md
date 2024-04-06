# ShoppingCartGrouping
Recruitment task for Ocado company

# About

This task is an example of the set cover problem.

The Set Cover Problem is a classic problem in computer science and optimization. It is an NP-hard problem that involves finding the smallest set of subsets that covers all elements in a given set. In other words, the goal is to find the smallest number of subsets that together cover all elements. 
  
There are several algorithms for solving the Set Cover Problem, including greedy algorithms, dynamic programming, and integer programming. The problem is labeled as NP-hard, which means that there is no known polynomial-time algorithm that can solve it in the worst case. However, there are algorithms which can find almost optimal solutions.

In this project I used greedy algorithm to find optimal way of grouping items in a shopping cart by delivery methods. 

First step in this solution is to take input from configuration file with all items in shop and their all delivery methods. To do that I use gson library which allows converting JSON file to equivalent Java Object. Here, data from JSON is being loaded as Map with item from shop as key and delivery methods as values. 

Later I am using this data to find delivery methods for items in the cart to group them. 

Speaking in a simple maner this algorithm works this way:
- In every iteration it searches for the delivery method that covers the maximum number of ungrouped products.
- For each delivery method, it creates a set named productsCovered containing products from ungroupedProducts that can be covered by that method and it finds the greatest productsCovered.
- After finding the best delivery method, it adds the delivery method with its corresponding products to the finalGroups map.
- Then it removes these products from the ungroupedProducts set and new iteration begins with smaller set of ungrouped items. It continues until ungroupedProducts reaches 0.