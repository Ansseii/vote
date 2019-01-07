## API documentation
##### Used technologies 
* Spring Boot
* Spring Security(Base)
* Spring Data JPA
* H2 as chosen database

## Curl commands
###For user
##### Get user by Email
<code>
    curl -i http://localhost:8080/rest/admin/users/find?email=user_1@gmail.com --user admin_1@gmail.com:admin
</code>

##### Get user by Email not found
<code>
    curl -i http://localhost:8080/rest/admin/users/find?email=user@gmail.com --user admin_1@gmail.com:admin
</code>

##### Get user by Email access denied for users
<code>
    curl -i http://localhost:8080/rest/admin/users/find?email=user_1@gmail.com --user user_1@gmail.com:user
</code>

##### Get all users
<code>
    curl -i http://localhost:8080/rest/admin/users --user admin_1@gmail.com:admin
</code>

### For restaurants and menu lists
###### restaurants
##### Create restaurant
<code>
    curl -i -X POST -d '{"name":"newRestaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin_1@gmail.com:admin
</code>
 
##### Update restaurant
<code>
    curl -i -X PUT -d '{"name":"updateRestaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants/1 --user admin_1@gmail.com:admin
</code>
 
##### Get restaurant by id 1
<code>
    curl -i http://localhost:8080/rest/admin/restaurants/1 --user admin_1@gmail.com:admin
</code>

##### Get all restaurants 
<code>
    curl -i http://localhost:8080/rest/admin/restaurants --user admin_1@gmail.com:admin
</code>

###### menu
##### Create menu for restaurant 1
<code>
    curl -i -X POST -d '[{"name":"newFood", "price":300},{"name":"someFood","price":200}]' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants/1/menu --user admin_1@gmail.com:admin
</code>
  
##### Get menu for restaurant 1
<code>
    curl -i http://localhost:8080/rest/admin/restaurants/1/menu --user admin_1@gmail.com:admin
</code>
  
##### Delete menu
<code>
    curl -i -X DELETE http://localhost:8080/rest/admin/restaurants/1/menu --user admin_1@gmail.com:admin
</code>
   
### For voting
##### Create vote for restaurant with id 0
<code>
    curl -s -X POST -d'{}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/vote/0 --user user_1@gmail.com:user
</code>
   
##### Get history voting
<code>
    curl -s http://localhost:8080/rest/vote --user user_1@gmail.com:user
</code>