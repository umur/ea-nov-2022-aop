

# Spring AOP

You can continue to your last lab assignment to implement followings.

###  Requirements
--- 
* Make a `ActivityLog` database table (`id,date,operation,duration`) that will store all method names that have `ExecutionTime` annotations.
* Make an `Aspect` that has an annotation pointcut `@ExecutionTime`, when placed on a method, it calculates the time taken to complete that method and writes it to `ActivityLog` table.
* Make an `Aspect` that has an pointcut for classes in `edu.miu.service` package to check if `POST` requests has `AOP-IS-AWESOME` header. If the header is not present then throw a `AopIsAwesomeHeaderException`.

### Technical Details
---
* Use n-tier software architecture model.
* Use DTOs.
* PostgreSQL is recommended as a Relational Database system.
* Populate your database with dummy data using `data.sql`.


## Submission

* Fork the repository and push your changes.
* Once you finished your project, send a Pull Request. (Send only one Pull Request once you finish the assignment.)

### Important Notes
---

* You are not allowed to share codes with your classmates. If detected, you will get NC.
* **For pairs:**
	* Individual's work will be checked from the commits.
	*  Share tasks evenly and fairly.
	*  To have a clearer understanding of pair programming:
		*  > **Pair programming** is an agile software development technique in which two programmers work together at one workstation. One, the _driver_, writes code while the other, the _observer_ or _navigator_ reviews each line of code as it is typed in. The two programmers switch roles frequently.
		* [Wikipedia](https://en.wikipedia.org/wiki/Pair_programming#:~:text=Pair%20programming%20is%20an%20agile,two%20programmers%20switch%20roles%20frequently.)

-   Remember to respect the code honor submission policy. All written code must be original. Presenting something as one’s own work when it came from another source is plagiarism and is forbidden.

-   Plagiarism is a very serious thing in all American academic institutions and is guarded against vigilantly by every professor.
	Make domain models for

Category with id and name.
A Category can have many Products.
Product with id, name, price and rating.
A Product can belong to only one Category.
A Product can have many Reviews.
User with id, email, password, firstName, lastname.
User can create many Reviews.
User can have only one Address.
Address with id, street, zip and city.
An Address can belong to only one User.
Review with id, comment.
A Review can only belong to one User and Product.
Create entity relationship mappings as follows: (Creating a package for each requirement is advised.)

Create them using uni-directional.
Create them using bi-directional.
Create User and Review mapping with Join Table.
Create User and Review mapping with Join Column.
Create User and Address mapping with Join Table.
Create User and Address mapping with Join Column.



### Explanation


```

@OneToOne(MappedBy) => for establishing the Bidirectional relationship usually, when you put it on a field that means don't create a foreign key of this guy
(field I'm putting the mappedBy on) on the table I'm currently in

@OneToMany(MappedBy) => when you put it on a field that means the relationship is already established on the other direction and don't create a third table
and put the field(I'm putting it on) as a foreignKey

@OneToOne => Creates fK for the field in the table , if it followed by @JoinTable that means do the third table and ignore creating the fK

@OneToMany => if it followed by @JoinColumn it means ignore making a third table and create a fK on the many side(weak side) with the name specified
so if we are in Entity Restaurant and on field List<Table> I put @OneToMany @JoinColumn it will as who's the many? Ans:Table and go create a fk inside it with the name specified
, another scenario if I'm inside Table Entity and on field Restaurant restaurant I put @ManyToOne , @JoinColumn() , it will ask who is the many?
Ans: Table (current table) and go create fk inside it with the specified name(restaurant_id)

when we want to establish a bi-directional relationship lets say reviews and products , the common sense is to go inside Entity Product and do
association with List<Review> @OneToMany and @JoinColumn(product_id) this is as if we think of it as a java code (uml diagram) , then when we go to
Review Entity, we put Product product @ManyToOne To establish the relationship then we want to ignore create a fk here (because of ToOne) so we leave it as
is if the name matches because we don't have mappedBy on @ManyToOne so if the name is miss spelled we will end having another fk in this table, it would work if name matches but this is as we think it
in java relationship, what if we flip the relationship? we would have more control on specifying mappedBy on the other entity because we have there
@OneToMany which have mappedBy attribute and we would get: so we code the relationship on the table itself not as java relationship
Product:
@OneToMany(mappedBy ="product")
List<Review> reviews
Review
@ManyToOne
Product product; => table will be created with the name of the field in this case product_id


mappedBy if used with @JoniTable on the field it means don't create fk of this field on the associated table, so if we don't specify the
relationship of the @JoinTable on the other side we will only get pk of the table @JonTable has been put on, if it is specified on the other
side and name of the field matches the created fk on the other table we will get it right if no match with names we will have 3 fk then
because @JoinTable automatically creates a third table containing of the primary key of the table we are on (id) and then makes the field as fk

@ManyToMany on both sides doesn't have a weak and strong entity so we put it on both side and to prevent creating fouth table on one of them we used mappedBy

@JoinColumn => if we don't specify the name we will put it as the name of the field in that table and this would be very confusing like Product table has products_id in it
so if we want to make it bidirectional using @Joincolumn , the name of the field should be the same in the other table to not create different fk
so to solve this issue of missspelling giving us another fk, we use mappedBy because it will throw an error directly saying that it cannot map
to a field that doesn't exist and we solve the issue dynamically so mappedBy gives us more flexibilty over naming when establishing bi-directional rlationship

mappedBy is an elegent way of saying don't create fk here it is already established there and having more more flexibility over naming because it will be mapped dunamically using that field name
and that field will be responsible of creating the fk for himself


in one directional relationship we have to specify where to put the field in order to have the required queries, so we can use only @joinColumn
if it helps putting it in the side we want, but if not we have to delete the whole field and put it on the other side to have the required queries in hand.


so to conclude mappedBy is as joincolumn but it is another way of saying that on the entity itself(not like java relationship) and let the table that
will have the fk specifiy the @ManyToOne because toOne will create the fk and this way we get a bidirectional relationship


so: don't code depending on the automatic creation of the name have more control and specify eveything expecilty, remember code the relation on the table
itself and remember there's no mappedBy on @ManyTOne 



```

continue lab4 ... 


# Spring AOP

You can continue to your last lab assignment to implement followings.

###  Requirements
--- 
* Make a `ActivityLog` database table (`id,date,operation,duration`) that will store all method names that have `ExecutionTime` annotations.
* Make an `Aspect` that has an annotation pointcut `@ExecutionTime`, when placed on a method, it calculates the time taken to complete that method and writes it to `ActivityLog` table.
* Make an `Aspect` that has an pointcut for classes in `edu.miu.service` package to check if `POST` requests has `AOP-IS-AWESOME` header. If the header is not present then throw a `AopIsAwesomeHeaderException`.

### Technical Details
---
* Use n-tier software architecture model.
* Use DTOs.
* PostgreSQL is recommended as a Relational Database system.
* Populate your database with dummy data using `data.sql`.


## Submission

* Fork the repository and push your changes.
* Once you finished your project, send a Pull Request. (Send only one Pull Request once you finish the assignment.)

### Important Notes
---

* You are not allowed to share codes with your classmates. If detected, you will get NC.
* **For pairs:**
	* Individual's work will be checked from the commits.
	*  Share tasks evenly and fairly.
	*  To have a clearer understanding of pair programming:
		*  > **Pair programming** is an agile software development technique in which two programmers work together at one workstation. One, the _driver_, writes code while the other, the _observer_ or _navigator_ reviews each line of code as it is typed in. The two programmers switch roles frequently.
		* [Wikipedia](https://en.wikipedia.org/wiki/Pair_programming#:~:text=Pair%20programming%20is%20an%20agile,two%20programmers%20switch%20roles%20frequently.)

-   Remember to respect the code honor submission policy. All written code must be original. Presenting something as one’s own work when it came from another source is plagiarism and is forbidden.

-   Plagiarism is a very serious thing in all American academic institutions and is guarded against vigilantly by every professor.
