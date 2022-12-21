const mongoose = require('mongoose');
 
const PlayerSchema = new mongoose.Schema({
    name: {type:String , required:[true, "Name is required"
    ], minLength:[
3, "Minimum length is 3 characters"
    ]
}, 
position: {type:String , required:[true, "Position is required"
], minLength:[
3, "Minimum length is 3 characters"
]
}
}, { timestamps: true });
 
const Player = mongoose.model('Player', PlayerSchema);
 
module.exports = Player;
