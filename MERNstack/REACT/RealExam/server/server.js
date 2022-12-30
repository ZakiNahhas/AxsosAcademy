const express = require("express");
const app = express();

// This will fire our mongoose.connect statement to initialize our database connection
require("./config/mongoose.config");

app.use(express.json(), express.urlencoded({ extended: true }));
const cors = require("cors"); // This is new
app.use(cors()); // This is new
// This is where we import the users routes function from our user.routes.js file
const AllMyCompetitionRoutes = require("./routes/competition.routes");
AllMyCompetitionRoutes(app);

app.listen(8000, () => console.log("The server is all fired up on port 8000"));
