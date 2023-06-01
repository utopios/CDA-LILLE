// aggregation : 
use("resto");
//db.createCollection("restaurant");
//db.restaurant.find().limit(4);

//db.restaurant.aggregate({$match: {rating : 5}});

//db.restaurant.aggregate({$match: {rating : 5}},{$count: "comptage"});

//db.restaurant.aggregate({$match: {rating: 5}}, {$project: {URL: 1, name: 1}});

//db.restaurant.aggregate({$group: {_id: "$type_of_food", count: {$sum:1}}})

//db.restaurant.aggregate({$group: {_id: "$type_of_food", count: {$sum:1}}},{$match:{count: {$gt: 10}}});

//db.restaurant.aggregate({$match: {rating: 6}}, {$project: {_id: 0, name: 1, type_of_food:1, rating:1}},{$limit:3});

db.restaurant.aggregate({$match: {rating: {$ne: "Not yet rated"}}},{$group: {_id: "$type_of_food", total_rating: {$sum: "$rating"}, avg_rating:{$avg: "$rating"}
, max_rating:{$max: "$rating"}, min_rating: {$min: "$rating"}}});




