# README

## 1. Running the Application

### Running the application with Intellij

1. Unzip the zipped file *RouteOptimizer.zip*
2. Open the file *RouteOptimizer* as a project in Intellij
3. In Intellij, *Build* >  *Build Project*
4. Select the Dockerfile
5. Click the green arrows *Run On Docker*

## 2. Interface

You may specify the source, query and output file names as command line arguments.

### Input Files
The application takes in two files named *queries.txt* and *source.txt*.

#### source.txt

*source.txt* is the source file and should contain a single line denoting the list of routes between two towns **delimited by spaces**

e.g. AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7

#### queries.txt

*queries.txt* is the query file and should contain one or more lines denoting a query. A query is composed of a command, a list of town names and depending on the command, a number.

e.g. dst A B C D

## 3. Queries

### `dst`

This query returns the **d**i**st**ance of a route that spans the given list of towns.

#### Example
Graph: AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7

Route: A E B C D

Query: `dst A E B C D`

Returns: 22

---

### `rcs`

This query returns the number of routes that start at one town and end at another with a maximum of k stops.

#### Example
Graph: AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7

Start Town: C

End Town: C

k: 3

Query: `rcs C C 3`

Returns: 2

---

### `rce`

This query returns the number of routes that start at one town and end at another with **exactly**  k stops.

#### Example
Graph: AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7

Start Town: A

End Town: C

k: 4

Query: `rce A C 4`

Returns: 3

---

### `src`

This query returns the shortest route between two towns.

#### Example
Graph: AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7

Start Town: A

End Town: C

Query: `src A C`

Returns: 9

--- 

### `rcd`

This query returns the number of different routes from one town to another with a distance of less than k.

#### Example
Graph: AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7

Start Town: C

End Town: C

k: 30

Query: `rcd C C 30`

Returns: 7



# route-optimizer
