// *** some query examples execute in JavaScript
//product = db.products.findOne({'slug': 'wheel-barrow-9092'})
//db.products.update({_id: product['_id']}, {$set: {"sku": "8900"}})
//db.products.insertOne({"slug" : "wheel-barrow-9092", "sku" : "9092", "name" : "Extra Large Wheel Barrow", "description" : "Heavy duty wheel barrow...", "details" : { "weight" : 47, "weight_units" : "lbs", "model_num" : 4039283402, "manufacturer" : "Acme", "color" : "Green" }, "total_reviews" : 4, "average_review" : 4.5, "pricing" : { "retail" : 5897, "sale" : 4897 }, "price_history" : [ { "retail" : 5297, "sale" : 4297, "start" : { "$date" : "2010-05-01T00:00:00.000-0700" }, "end" : { "$date" : "2010-05-08T00:00:00.000-0700" } }, { "retail" : 5297, "sale" : 5297, "start" : { "$date" : "2010-05-09T00:00:00.000-0700" }, "end" : { "$date" : "2010-05-16T00:00:00.000-0700" } } ], "category_ids" : [ { "$oid" : "6a5b1476238d3b4dd5000048" }, { "$oid" : "6a5b1476238d3b4dd5000049" } ], "main_cat_id" : { "$oid" : "6a5b1476238d3b4dd5000048" }, "tags" : [ "tools", "gardening", "soil" ] })
//product = db.products.findOne({_id:ObjectId("5c2d0a5aa02e2d359a49d937")})
//product._id = ObjectId("4c4b1476238d3b4dd5003981")
//db.products.insertOne(product)
//db.products.remove({_id:ObjectId("5c2d0a5aa02e2d359a49d937")})
product = db.products.findOne({'slug': 'wheel-barrow-9092'})

//*** end query examples
