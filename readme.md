#### Create restaurant
 <code>
 curl -s -X POST -d '{"name":"newRestaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin_1@gmail.com:admin
 
 
 
 fetch(
         '/rest/restaurants', 
         { 
           method: 'POST', 
           headers: { 'Content-Type': 'application/json' },
           body: JSON.stringify({name: "newRestaurant" })
         }
       ).then(result => result.json().then(console.log))
 </code>
 
#### Update restaurant
 <code>
 fetch(
   '/rest/restaurants/0', 
   { 
     method: 'PUT', 
     headers: { 'Content-Type': 'application/json' },
     body: JSON.stringify({name: "updated" })
   }
 )
 </code>
 
#### Create menu
  <code>
   fetch(
           '/rest/restaurants/1/menu', 
           { 
             method: 'POST', 
             headers: { 'Content-Type': 'application/json' },
             body: JSON.stringify({name: "newFood", price: "100" })
           }
         ).then(result => result.json().then(console.log))
  </code>
  
#### Delete menu
   <code>
   fetch('/rest/restaurants/1/menu', { method: 'DELETE' }).then(result => console.log(result))
   </code>
   
   #### Create vote for restaurant with id 0
   <code>
   curl -s -X POST -d'{}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/vote/0 --user user_1@gmail.com:user
   </code>
   
   ### Get All Votes
   <code>
   curl -s http://localhost:8080/rest/vote --user user_1@gmail.com:user
   </code>