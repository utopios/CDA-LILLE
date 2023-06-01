// Demo pour un one to one

use("onToOne");
//db.createCollection("users");
//db.createCollection("adress");
//db.users.insertOne({name: "Karim", age: 45});
//db.adress.insertOne({street: "rue des fleurs", number: 47,city: "croix", user_id: ObjectId("6478659aa1c739dc163ae446")})
//db.adress.find();
//db.users.aggregate({$lookup: {from: "adress", localField: "_id", foreignField: "user_id", as: "adresse"}}, {$project: {"adresse.user_id": 0}})
//db.adress.aggregate({$lookup: {from: "users", localField: "user_id", foreignField: "_id", as: "users"}})

// Demo pour une one to many
use("oneToMany")
//db.createCollection("authors")
//db.createCollection("books")
//db.books.insertOne({title: "La nuit c'est cool"})
//db.books.insertOne({title: "Le jour c'est mieux"})
//db.books.find()
//db.authors.find()
//db.authors.insertOne({name: "michel", books : [ObjectId("64786f279f410cc76a6c1f90"), ObjectId("64786f279f410cc76a6c1f91")]})
db.authors.aggregate({$lookup : {from: "books", localField: "books", foreignField: "_id", as: "books"}})

// Demo pour une many to many
use(manyToMany)
db.createCollection("orders")
db.createCollection("products")
db.products.insertMany([{name : "Clavier", orders : []},{name : "souris",orders : []}])
db.orders.insertMany([{company : "Apple", products : []},{compagny : "Sony", products : []}])
db.orders.updateOne({_id : ObjectId("637e865a251d499fa4a82b11")}, {$push : {products : ObjectId("637e85df251d499fa4a82b0f")}})
db.orders.updateOne({_id : ObjectId("637e865a251d499fa4a82b11")}, {$push : {products : ObjectId("637e85df251d499fa4a82b10")}})
db.orders.updateOne({_id : ObjectId("637e865a251d499fa4a82b12")}, {$push : {products : ObjectId("637e85df251d499fa4a82b10")}})
db.orders.updateOne({_id : ObjectId("637e865a251d499fa4a82b12")}, {$push : {products : ObjectId("637e85df251d499fa4a82b0f")}})
db.products.update({_id : ObjectId("637e85df251d499fa4a82b0f")},{$push :{orders : ObjectId("637e865a251d499fa4a82b12")}})
db.products.update({_id : ObjectId("637e85df251d499fa4a82b0f")},{$push :{orders : ObjectId("637e865a251d499fa4a82b11")}})
db.products.update({_id : ObjectId("637e85df251d499fa4a82b10")},{$push :{orders : ObjectId("637e865a251d499fa4a82b12")} })
db.products.update({_id : ObjectId("637e85df251d499fa4a82b10")},{$push :{orders : ObjectId("637e865a251d499fa4a82b11")} })
db.products.aggregate({$lookup : {from: "orders",localField : "orders", foreignField : "_id", as: "orders"}})