const mongoose = require('mongoose');
const CompetitionSchema = new mongoose.Schema({
question: {
        type: String,
        required: [
            true,
            "Question is required"
        ],
        minLength: [
            10,
            "Question must be at least 10 characters"
        ]
    },
country1:{
    type:String,
    required: [
        true,
        "country 1 is required"
    ]
},
vote1:{
    type:Number,
    default: 0
},
country2:{
    type:String,
    required: [
        true,
        "country 2 is required"
    ]

},
vote2:{
    type:Number,
    default: 0
},
country3:{
    type:Number,
},
vote3:{
    type:Number,
    default: 0
}
   

}, { timestamps: true });

const Competition = mongoose.model('Competition', CompetitionSchema);
 
module.exports = Competition;
