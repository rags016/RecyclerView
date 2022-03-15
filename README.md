
Nested RecyclerView implementatio![Screenshot 2022-03-16 at 12 45 35 AM](https://user-images.githubusercontent.com/33841926/158455424-ab23cdfa-656d-434e-b249-191043c521a7.png)
n 



# RecyclerView implementation with dummy data
## Objective:
We needed to create an app in which we need to add header row and for each header row we needed to show a list.

## Approach
The approach i took is simple. I am using nested recyclerview like parent and child recyclerview.
The data is dummy data and is saved in assets folder in .json format
I fetched the data and parsed the data into JSON object as out data class defined.
And for two recycler views we are having two corresponding adapters to fill the data into them.

