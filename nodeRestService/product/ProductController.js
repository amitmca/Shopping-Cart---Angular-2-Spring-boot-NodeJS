// var jwt = require('jsonwebtoken');
// var bcrypt = require('bcryptjs');
// var config = require('../config');



var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');
router.use(bodyParser.urlencoded({ extended: false }));
router.use(bodyParser.json());

const Product = require("./Product");


router.post('/:id', function (req, res) {
    const id = req.params.id;
    //Code goes here
});

router.get('/productList', function (req, res) {

    //Code goes here
    Product.find({}, (err, productResponse) => {
        console.log("Product response :" + productResponse);
        if (err) return res.status(500).send("There was a problem fetching data.");

        return res.status(200).send(JSON.stringify(productResponse));
    });

    // if (err) return res.status(500).send("There was a problem fetching data.")

    //     if (!res || productResponse.length == 0) {
    //         var products = [
    //             {
    //                 name: 'Iphone 8',
    //                 src: 'https://www.t-mobile.com/images/png/products/phones/Apple-iPhone-8-Space-Gray/250x270_1.png',
    //                 info: `iPhone 8 is a new generation of iPhone. Designed with the most durable glass ever in a smartphone and a stronger aerospace grade aluminum band. Charges wirelessly. Resists water and dust. 4.7-inch Retina HD display with True Tone. 12MP camera with new sensor and advanced image signal processor. Powered by A11 Bionic, the most powerful and smartest chip ever in a smartphone. Supports augmented reality experiences in games and apps. With iPhone 8, intelligence has never looked better`,
    //                 price: 774.46
    //             },
    //             {
    //                 name: 'Skull Candy Grind',
    //                 src: 'https://fthmb.tqn.com/zcg_6eKNC9vfnTQr8VztakCSmlU=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/SkullcandyGrindOn-EarHeadphones-59f8f295845b340011dc9e6c.jpg',
    //                 info: `Grind delivers a premium listening experience without breaking the bank thanks to high-quality materials and a secure and comfortable fit. And the built-in microphone and remote with track, call, and volume control make managing music and phone calls a breeze`,
    //                 price: 69.87
    //             },
    //             {
    //                 name: 'Denon AH-MM400',
    //                 src: 'http://cdn2.expertreviews.co.uk/sites/expertreviews/files/2017/01/best_headphones_denon_ah-mm400_review.jpg?itok=5zt_EW-k',
    //                 info: `The wood-effect looks might not be everyone's idea of a classy pair of headphones, but the Denon AH-MM400 more than make amends for their potential fashion ...`,
    //                 price: 275.57
    //             },
    //         ];

    //         Product.create({
    //             id: number,
    //             name: String,
    //             src: String,
    //             info: String,
    //             price: number
    //         }, function (err, user) {
    //             if (err) return res.status(500).send("There was a problem adding the information to the database.");
    //         });

    //         Product.insertMany(products, function (err, res) {
    //             if (err) throw err;
    //             console.log("Number of documents inserted: " + res.insertedCount);
    //         });
    //     }

});

router.get('/product/:id', function (req, res) {
    
});

module.exports = router;