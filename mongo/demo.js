use('books');
// command insert 

//db.books.insertOne({title: "je suis un livre",pageCount: 455});
//db.books.insertMany([{title: "je suis un livre",pageCount: 455},{title: "cassandra, elle est la", status: "PUBLISHED" }])

// command find

//db.books.find();
//db.books.find().limit(5);
//db.books.findOneAndDelete({title: "Unlocking Android"});

//db.books.find({pageCount: {$gt: 500}}).pretty();

//db.books.find({categories: {$in: ['Java', 'Web Development']}});

//db.books.find({categories: {$all: ['Java', 'Web Development']}});

//db.books.find({categories: {$all: ['PowerBuilder', 'Client-Server']}});

//db.books.find({$or: [{_id: 19}, {_id:98745}]});

//db.books.find({}, {title:1, status: 1});

//db.books.find({longDescription: {$regex: 'Distributed', $options: "i"}});


//db.books.find({longDescription: {$regex: '^ext', $options: "i"}});

//db.books.find({title: {$regex: 'Perl$', $options: "i"}});

// command update 


//db.books.updateOne({_id: 55}, {$set: {title: "Object Oriented Cassandre"}});
//db.books.findOne({_id: 55});

//db.books.updateMany({_id:{$in:[55,75]}},{$set: {status: "CANCELED"}})

//db.books.find({_id: {$in:[55,75]}});