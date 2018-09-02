**OrderCombiner2**

This project is used to find combinable orders for riders.

Distances between locations are calculated using google's *Distance Matrix API*.

#Order Combination
Given a set of orders ( Pick up , Dropoff ) Combinable orders are determined using a radius metric from the first order.

#TSP
Once combinable orders are determined, the traveling salesman approach is used to get the shortest distance through nodes
